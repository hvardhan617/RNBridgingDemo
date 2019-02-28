package com.nativeuitest;

import android.graphics.Color;
import android.view.View;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class SimpleSquareViewManager extends SimpleViewManager<View> {

    private ThemedReactContext mContext;
    private View view;

    @Override
    public String getName() {
        return "SimpleSquareView";
    }

    @Override
    protected View createViewInstance(ThemedReactContext reactContext) {
        mContext=reactContext;
        view=new View(reactContext);
        view.setBackgroundColor(Color.BLUE);
        return view;
    }
}
