package com.willwolfram.androidtvapptutorial;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.leanback.app.BrowseFragment;

public class MainFragment extends BrowseFragment {
    private static final String Tag = MainFragment.class.getSimpleName();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(Tag, "onActivityCreated");

        super.onActivityCreated(savedInstanceState);
    }
}
