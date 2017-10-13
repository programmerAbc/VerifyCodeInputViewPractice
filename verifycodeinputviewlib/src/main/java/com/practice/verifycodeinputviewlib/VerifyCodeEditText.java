package com.practice.verifycodeinputviewlib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;

/**
 * Created by zhuyakun on 2017/10/13.
 */

public class VerifyCodeEditText extends EditText {
    KeyboardListener listener;

    public VerifyCodeEditText(Context context) {
        super(context);
    }

    public VerifyCodeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerifyCodeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return new VerifyCodeInputConnection(super.onCreateInputConnection(outAttrs), true);
    }

    private class VerifyCodeInputConnection extends InputConnectionWrapper {

        /**
         * Initializes a wrapper.
         * <p>
         * <p><b>Caveat:</b> Although the system can accept {@code (InputConnection) null} in some
         * places, you cannot emulate such a behavior by non-null {@link InputConnectionWrapper} that
         * has {@code null} in {@code target}.</p>
         *
         * @param target  the {@link InputConnection} to be proxied.
         * @param mutable set {@code true} to protect this object from being reconfigured to target
         *                another {@link InputConnection}.  Note that this is ignored while the target is {@code null}.
         */
        public VerifyCodeInputConnection(InputConnection target, boolean mutable) {
            super(target, mutable);
        }

        @Override
        public boolean sendKeyEvent(KeyEvent event) {
            boolean keyEventConsumed = false;
            if (listener != null) {
                keyEventConsumed = listener.onKey(VerifyCodeEditText.this, event.getKeyCode(), event);
            }
            if (keyEventConsumed) {
                return true;
            } else {
                return super.sendKeyEvent(event);
            }
        }
    }


    public void setKeyboardListener(KeyboardListener listener) {
        this.listener = listener;
    }

    public interface KeyboardListener {
        boolean onKey(VerifyCodeEditText editText, int keyCode, KeyEvent keyEvent);
    }

}
