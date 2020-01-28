package com.willwolfram.androidtvapptutorial;

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color;
import android.os.Build
import android.os.Bundle
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.widget.*
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.*
import kotlin.math.absoluteValue
import kotlin.random.Random

private const val GRID_ITEM_WIDTH = 300
private const val GRID_ITEM_HEIGHT = 200

class MainFragment : BrowseFragment() {
    private val TAG = "MainFragment"
    private var _rowsAdapter: ArrayObjectAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "onActivityCreated")

        super.onActivityCreated(savedInstanceState)

        setupUIElements()
        loadRows()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toastViewGroup = LayoutInflater.from(context).inflate(R.layout.custom_toast, null)
        val textView: TextView = toastViewGroup.findViewById(R.id.custom_toast_text)

        textView.text = "The time is currently ${Calendar.getInstance().time}"

        val toast = Toast(context)

        toast.setGravity(Gravity.BOTTOM or Gravity.RIGHT, 0, 0)
        toast.duration = Toast.LENGTH_LONG
        toast.view = toastViewGroup
        toast.show()
    }

    private fun setupUIElements() {
        title = "Hello Fire TV!"

        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        brandColor = getColor(R.color.fastlane_background)
        searchAffordanceColor = getColor(R.color.search_opaque)
    }

    private fun loadRows() {
        _rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        for (i in 1..3) {
            val gridItemPresenterHeader = HeaderItem(i.toLong(), "Grid Item Presenter $i")

            val gridPresenter = CardPresenter()
            val gridRowAdapter = ArrayObjectAdapter(gridPresenter)

            for (j in 1..5) {
                val movieId = (i * 10 + j).toLong()
                val movie = Movie(
                    movieId,
                    "Title $movieId",
                    "Studio $movieId"
                )

                gridRowAdapter.add(movie)
            }

            (_rowsAdapter as ArrayObjectAdapter).add(ListRow(gridItemPresenterHeader, gridRowAdapter))
        }

        adapter = _rowsAdapter
    }

    private fun getColor(colorId: Int): Int {
        return resources.getColor(colorId)
    }

    private class GridItemPresenter : Presenter() {
        override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
            val view = TextView(parent.context)

            view.layoutParams = ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT)
            view.isFocusable = true
            view.isFocusableInTouchMode = true
            view.setBackgroundColor(Color.BLUE)
            view.setTextColor(Color.WHITE)
            view.gravity = Gravity.CENTER

            return ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
            (viewHolder.view as TextView)?.text = item?.toString()
        }

        override fun onUnbindViewHolder(viewHolder: ViewHolder) {

        }
    }
}
