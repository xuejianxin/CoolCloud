package com.bilibili.magicasakura.utils;

import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

public class InputConnectionImpl extends InputConnectionWrapper {

    public InputConnectionImpl(InputConnection target, boolean mutable) {
        super(target, mutable);
    }

    @Override
    public boolean setSelection(int start, int end) {
        if (start < 0 || end < 0) {
            // If the given selection is out of bounds, just ignore it.
            // Most likely the text was changed out from under the IME,
            // and the IME is going to have to update all of its state
            // anyway.
            return true;
        }
        return super.setSelection(start, end);
    }
}
