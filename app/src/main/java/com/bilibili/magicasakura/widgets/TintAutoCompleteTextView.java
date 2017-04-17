package com.bilibili.magicasakura.widgets;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import com.bilibili.magicasakura.utils.TintManager;

public class TintAutoCompleteTextView extends AutoCompleteTextView implements Tintable, AppCompatBackgroundHelper.BackgroundExtensible,
        AppCompatCompoundDrawableHelper.CompoundDrawableExtensible {
    private AppCompatBackgroundHelper mBackgroundHelper;
    private AppCompatCompoundDrawableHelper mCompoundDrawableHelper;

    public TintAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public TintAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.autoCompleteTextViewStyle);
    }

    public TintAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) {
            return;
        }
        TintManager tintManager = TintManager.get(getContext());

        mBackgroundHelper = new AppCompatBackgroundHelper(this, tintManager);
        mBackgroundHelper.loadFromAttribute(attrs, defStyleAttr);

        mCompoundDrawableHelper = new AppCompatCompoundDrawableHelper(this, tintManager);
        mCompoundDrawableHelper.loadFromAttribute(attrs, defStyleAttr);
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
        if (mBackgroundHelper != null) {
            mBackgroundHelper.setBackgroundDrawableExternal(background);
        }
    }

    @Override
    public void setBackgroundResource(int resId) {
        if (mBackgroundHelper != null) {
            mBackgroundHelper.setBackgroundResId(resId);
        } else {
            super.setBackgroundResource(resId);
        }
    }

    @Override
    public void setBackgroundColor(int color) {
        if (mBackgroundHelper != null) {
            mBackgroundHelper.setBackgroundColor(color);
        } else {
            super.setBackgroundColor(color);
        }
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        if (mCompoundDrawableHelper != null) {
            mCompoundDrawableHelper.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        } else {
            super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        }
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        if (mCompoundDrawableHelper != null) {
            mCompoundDrawableHelper.setCompoundDrawablesWithIntrinsicBounds();
        }
    }

    @Override
    public void setBackgroundTintList(int resId) {
        if (mBackgroundHelper != null) {
            mBackgroundHelper.setBackgroundTintList(resId, null);
        }
    }

    @Override
    public void setBackgroundTintList(int resId, PorterDuff.Mode mode) {
        if (mBackgroundHelper != null) {
            mBackgroundHelper.setBackgroundTintList(resId, mode);
        }
    }

    @Override
    public void setCompoundDrawableTintList(int leftResId, int topResId, int rightResId, int bottomResId) {
        if (mCompoundDrawableHelper != null) {
            mCompoundDrawableHelper.setCompoundDrawablesTintList(leftResId, topResId, rightResId, bottomResId);
        }
    }

    @Override
    public void tint() {
        if (mBackgroundHelper != null) {
            mBackgroundHelper.tint();
        }
        if (mCompoundDrawableHelper != null) {
            mCompoundDrawableHelper.tint();
        }
    }
}
