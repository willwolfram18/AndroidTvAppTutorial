package com.willwolfram.androidtvapptutorial

import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import android.widget.Toast
import java.lang.StringBuilder
import kotlin.math.roundToInt

class Utils {
    val MillisecondsInSecond: Int = 1000
    val SecondsInMinutes = 60
    val MillisecondsInMinute = MillisecondsInSecond * SecondsInMinutes

    val MinuesInHour = 60
    val MillisecondsInHour = MillisecondsInMinute * MinuesInHour;

    fun getPoint(context: Context): Point {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()

        display.getSize(size)

        return size
    }

    fun showLongToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showLongToast(context: Context, resourceId: Int) {
        showLongToast(context, context.getString(resourceId))
    }

    fun convertDpToPixel(context: Context, dp: Int): Int {
        val density = context.resources.displayMetrics.density

        return (dp * density).roundToInt()
    }

    fun millisecondsToTimeString(milliseconds: Int): String {
        val timeStringBuilder = StringBuilder()
        var currentMilliseconds = milliseconds

        val hours = currentMilliseconds / MillisecondsInHour
        currentMilliseconds %= MillisecondsInHour

        val minutes = currentMilliseconds / MillisecondsInMinute
        currentMilliseconds %= MillisecondsInMinute

        val seconds = milliseconds / MillisecondsInSecond
        currentMilliseconds %= MillisecondsInSecond

        if (hours > 0) {
            timeStringBuilder.append("$hours:")
        }

        timeStringBuilder.append(String.format("%2d", minutes))
        timeStringBuilder.append(String.format("%2d", seconds))

        return timeStringBuilder.toString()
    }
}