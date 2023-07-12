/**
 * Project Name：expandeableListTest
 * File Name：ExtendedEditText.java
 * Package Name：com.example.expandeablelisttest
 * Date：2016年3月3日 下午9:58:40
 * Copyright (c) 2016, harris.huang All Rights Reserved.
 */
package com.catail.lib_commons.view;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

import java.util.ArrayList;

public class ExtendedEditText extends AppCompatEditText {

    private ArrayList<TextWatcher> mListeners = null;

    public ExtendedEditText(Context ctx) {
        super(ctx);
    }

    public ExtendedEditText(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
    }

    public ExtendedEditText(Context ctx, AttributeSet attrs, int defStyle) {
        super(ctx, attrs, defStyle);
    }

    @Override
    public void addTextChangedListener(TextWatcher watcher) {
        if (mListeners == null) {
            mListeners = new ArrayList<TextWatcher>();
        }
        mListeners.add(watcher);

        super.addTextChangedListener(watcher);
    }

    @Override
    public void removeTextChangedListener(TextWatcher watcher) {
        if (mListeners != null) {
            int i = mListeners.indexOf(watcher);
            if (i >= 0) {
                mListeners.remove(i);
            }
        }

        super.removeTextChangedListener(watcher);
    }

    public void clearTextChangedListeners() {
        if (mListeners != null) {
            for (TextWatcher watcher : mListeners) {
                super.removeTextChangedListener(watcher);
            }

            mListeners.clear();
            mListeners = null;
        }
    }

    public int getTextChangeCounter() {
        if (mListeners != null) {
            return mListeners.size();
        }
        return 0;
    }

}
