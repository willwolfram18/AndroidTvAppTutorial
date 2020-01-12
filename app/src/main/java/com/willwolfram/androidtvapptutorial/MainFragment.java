package com.willwolfram.androidtvapptutorial;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;

public class MainFragment extends BrowseFragment {
    private static final String TAG = MainFragment.class.getSimpleName();
    private static final int GRID_ITEM_WIDTH = 300;
    private static final int GRID_ITEM_HEIGHT = 200;

    private ArrayObjectAdapter _rowsAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated");

        super.onActivityCreated(savedInstanceState);

        setupUIElements();
        loadRows();
    }

    private void setupUIElements() {
        setTitle("Hello Fire TV!");

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        setBrandColor(getColor(R.color.fastlane_background));
        setSearchAffordanceColor(getColor(R.color.search_opaque));
    }

    private void loadRows() {
        _rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        HeaderItem gridItemPresenterHeader = new HeaderItem(0, "GridItemPresenter");

        GridItemPresenter gridPresenter = new GridItemPresenter();
        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(gridPresenter);

        for (int i = 1; i <= 5; i++) {
            gridRowAdapter.add("Item " + i);
        }

        _rowsAdapter.add(new ListRow(gridItemPresenterHeader, gridRowAdapter));

        setAdapter(_rowsAdapter);
    }

    private int getColor(int colorId) {
        return getResources().getColor(colorId);
    }

    private class GridItemPresenter extends Presenter {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            TextView view = new TextView(parent.getContext());

            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setBackgroundColor(getColor(R.color.primary));
            view.setTextColor(Color.WHITE);
            view.setGravity(Gravity.CENTER);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            ((TextView) viewHolder.view).setText(item.toString());
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }
}
