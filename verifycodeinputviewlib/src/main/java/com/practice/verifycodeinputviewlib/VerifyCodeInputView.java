package com.practice.verifycodeinputviewlib;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Created by zhuyakun on 2017/10/11.
 */

public class VerifyCodeInputView extends FrameLayout implements View.OnFocusChangeListener, View.OnKeyListener {
    public static final String TAG = VerifyCodeInputView.class.getSimpleName();
    EditText vcEt0;
    EditText vcEt1;
    EditText vcEt2;
    EditText vcEt3;
    EditText vcEt4;
    EditText vcEt5;
    TextView vcEmptyView;

    public VerifyCodeInputView(Context context) {
        super(context);
        init();
    }

    public VerifyCodeInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerifyCodeInputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.verify_code_input_view, this, true);
        vcEt0 = (EditText) findViewById(R.id.vc_et0);
        vcEt1 = (EditText) findViewById(R.id.vc_et1);
        vcEt2 = (EditText) findViewById(R.id.vc_et2);
        vcEt3 = (EditText) findViewById(R.id.vc_et3);
        vcEt4 = (EditText) findViewById(R.id.vc_et4);
        vcEt5 = (EditText) findViewById(R.id.vc_et5);
        vcEmptyView = (TextView) findViewById(R.id.vc_emptyView);
        initOnFocusChangeListener();
        initOnKeyListener();
    }

    private void initOnKeyListener() {
        vcEt0.setOnKeyListener(this);
        vcEt1.setOnKeyListener(this);
        vcEt2.setOnKeyListener(this);
        vcEt3.setOnKeyListener(this);
        vcEt4.setOnKeyListener(this);
        vcEt5.setOnKeyListener(this);
    }

    private void initOnFocusChangeListener() {
        vcEt0.setOnFocusChangeListener(this);
        vcEt1.setOnFocusChangeListener(this);
        vcEt2.setOnFocusChangeListener(this);
        vcEt3.setOnFocusChangeListener(this);
        vcEt4.setOnFocusChangeListener(this);
        vcEt5.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!vcEt0.hasFocus() && !vcEt1.hasFocus() && !vcEt2.hasFocus() && !vcEt3.hasFocus() && !vcEt4.hasFocus() && !vcEt5.hasFocus()) {
            if (TextUtils.isEmpty(vcEt0.getText().toString()) &&
                    TextUtils.isEmpty(vcEt1.getText().toString()) &&
                    TextUtils.isEmpty(vcEt2.getText().toString()) &&
                    TextUtils.isEmpty(vcEt3.getText().toString()) &&
                    TextUtils.isEmpty(vcEt4.getText().toString()) &&
                    TextUtils.isEmpty(vcEt5.getText().toString())
                    ) {
                vcEmptyView.setVisibility(VISIBLE);
            } else {
                vcEmptyView.setVisibility(INVISIBLE);
            }
        } else {
            vcEmptyView.setVisibility(INVISIBLE);
        }
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != KeyEvent.ACTION_UP) return true;
        if (v.getId() == R.id.vc_et0) {
            EditText et = (EditText) v;
            if (!TextUtils.isEmpty(et.getText().toString())) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_DEL:
                        et.setText("");
                        break;
                    default:
                        break;
                }
            } else {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_0:
                    case KeyEvent.KEYCODE_1:
                    case KeyEvent.KEYCODE_2:
                    case KeyEvent.KEYCODE_3:
                    case KeyEvent.KEYCODE_4:
                    case KeyEvent.KEYCODE_5:
                    case KeyEvent.KEYCODE_6:
                    case KeyEvent.KEYCODE_7:
                    case KeyEvent.KEYCODE_8:
                    case KeyEvent.KEYCODE_9:
                        et.setText(Character.toString((char) event.getUnicodeChar()));
                        vcEt1.requestFocus();
                        break;
                }
            }

        } else if (v.getId() == R.id.vc_et1) {
            EditText et = (EditText) v;
            if (!TextUtils.isEmpty(et.getText().toString())) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_DEL:
                        et.setText("");
                        break;
                    default:
                        break;
                }
            } else {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_0:
                    case KeyEvent.KEYCODE_1:
                    case KeyEvent.KEYCODE_2:
                    case KeyEvent.KEYCODE_3:
                    case KeyEvent.KEYCODE_4:
                    case KeyEvent.KEYCODE_5:
                    case KeyEvent.KEYCODE_6:
                    case KeyEvent.KEYCODE_7:
                    case KeyEvent.KEYCODE_8:
                    case KeyEvent.KEYCODE_9:
                        et.setText(Character.toString((char) event.getUnicodeChar()));
                        vcEt2.requestFocus();
                        break;
                    case KeyEvent.KEYCODE_DEL:
                        vcEt0.requestFocus();
                        vcEt0.setSelection(vcEt0.getText().length());
                        break;
                    default:
                        break;
                }
            }
        } else if (v.getId() == R.id.vc_et2) {
            EditText et = (EditText) v;
            if (!TextUtils.isEmpty(et.getText().toString())) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_DEL:
                        et.setText("");
                        break;
                    default:
                        break;
                }
            } else {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_0:
                    case KeyEvent.KEYCODE_1:
                    case KeyEvent.KEYCODE_2:
                    case KeyEvent.KEYCODE_3:
                    case KeyEvent.KEYCODE_4:
                    case KeyEvent.KEYCODE_5:
                    case KeyEvent.KEYCODE_6:
                    case KeyEvent.KEYCODE_7:
                    case KeyEvent.KEYCODE_8:
                    case KeyEvent.KEYCODE_9:
                        et.setText(Character.toString((char) event.getUnicodeChar()));
                        vcEt3.requestFocus();
                        break;
                    case KeyEvent.KEYCODE_DEL:
                        vcEt1.requestFocus();
                        vcEt1.setSelection(vcEt1.getText().length());
                        break;
                    default:
                        break;
                }
            }
        } else if (v.getId() == R.id.vc_et3) {
            EditText et = (EditText) v;
            if (!TextUtils.isEmpty(et.getText().toString())) {
                switch (keyCode) {

                    case KeyEvent.KEYCODE_DEL:
                        et.setText("");
                        break;
                    default:
                        break;
                }
            } else {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_0:
                    case KeyEvent.KEYCODE_1:
                    case KeyEvent.KEYCODE_2:
                    case KeyEvent.KEYCODE_3:
                    case KeyEvent.KEYCODE_4:
                    case KeyEvent.KEYCODE_5:
                    case KeyEvent.KEYCODE_6:
                    case KeyEvent.KEYCODE_7:
                    case KeyEvent.KEYCODE_8:
                    case KeyEvent.KEYCODE_9:
                        et.setText(Character.toString((char) event.getUnicodeChar()));
                        vcEt4.requestFocus();
                        break;
                    case KeyEvent.KEYCODE_DEL:
                        vcEt2.requestFocus();
                        vcEt2.setSelection(vcEt2.getText().length());
                        break;
                    default:
                        break;
                }
            }
        } else if (v.getId() == R.id.vc_et4) {
            EditText et = (EditText) v;
            if (!TextUtils.isEmpty(et.getText().toString())) {
                switch (keyCode) {

                    case KeyEvent.KEYCODE_DEL:
                        et.setText("");
                        break;
                    default:
                        break;
                }
            } else {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_0:
                    case KeyEvent.KEYCODE_1:
                    case KeyEvent.KEYCODE_2:
                    case KeyEvent.KEYCODE_3:
                    case KeyEvent.KEYCODE_4:
                    case KeyEvent.KEYCODE_5:
                    case KeyEvent.KEYCODE_6:
                    case KeyEvent.KEYCODE_7:
                    case KeyEvent.KEYCODE_8:
                    case KeyEvent.KEYCODE_9:
                        et.setText(Character.toString((char) event.getUnicodeChar()));
                        vcEt5.requestFocus();
                        break;
                    case KeyEvent.KEYCODE_DEL:
                        vcEt3.requestFocus();
                        vcEt3.setSelection(vcEt3.getText().length());
                        break;
                    default:
                        break;
                }
            }
        } else if (v.getId() == R.id.vc_et5) {
            EditText et = (EditText) v;
            if (!TextUtils.isEmpty(et.getText().toString())) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_DEL:
                        et.setText("");
                        break;
                    default:
                        break;
                }
            } else {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_0:
                    case KeyEvent.KEYCODE_1:
                    case KeyEvent.KEYCODE_2:
                    case KeyEvent.KEYCODE_3:
                    case KeyEvent.KEYCODE_4:
                    case KeyEvent.KEYCODE_5:
                    case KeyEvent.KEYCODE_6:
                    case KeyEvent.KEYCODE_7:
                    case KeyEvent.KEYCODE_8:
                    case KeyEvent.KEYCODE_9:
                        et.setText(Character.toString((char) event.getUnicodeChar()));
                        et.setSelection(et.getText().length());
                        break;
                    case KeyEvent.KEYCODE_DEL:
                        vcEt4.requestFocus();
                        vcEt4.setSelection(vcEt4.getText().length());
                        break;
                    default:
                        break;
                }
            }
        }
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (TextUtils.isEmpty(vcEt0.getText().toString())) {
                vcEt0.requestFocus();
                ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(vcEt0, 0);
            } else if (TextUtils.isEmpty(vcEt1.getText().toString())) {
                vcEt1.requestFocus();
                ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(vcEt1, 0);
            } else if (TextUtils.isEmpty(vcEt2.getText().toString())) {
                vcEt2.requestFocus();
                ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(vcEt2, 0);
            } else if (TextUtils.isEmpty(vcEt3.getText().toString())) {
                vcEt3.requestFocus();
                ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(vcEt3, 0);
            } else if (TextUtils.isEmpty(vcEt4.getText().toString())) {
                vcEt4.requestFocus();
                ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(vcEt4, 0);
            } else {
                vcEt5.requestFocus();
                ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(vcEt5, 0);
            }
        }
        return true;
    }
}
