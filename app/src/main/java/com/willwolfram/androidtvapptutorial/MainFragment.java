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

        setupUIElements();
    }

    private void setupUIElements() {
        setTitle("Hello Fire TV!");

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        setBrandColor(getColor(R.color.fastlane_background));
        setSearchAffordanceColor(getColor(R.color.search_opaque));
    }

    private int getColor(int colorId) {
        return getResources().getColor(colorId);
    }
}
