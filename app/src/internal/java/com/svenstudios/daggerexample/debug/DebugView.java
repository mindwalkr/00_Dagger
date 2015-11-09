package com.svenstudios.daggerexample.debug;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.svenstudios.daggerexample.R;

public class DebugView extends LinearLayout {
    private static final String LOG_TAG = DebugView.class.getSimpleName();

    private Context mContext;

    public DebugView(Context context) {
        super(context);

        mContext = context;

        LayoutInflater.from(context).inflate(R.layout.debug_view_content, this);
    }


}
