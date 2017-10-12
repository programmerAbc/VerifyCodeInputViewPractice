package com.practice.verifycodeinputviewlib;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by zhuyakun on 2017/10/11.
 */

public class VerifyCodeInputView extends FrameLayout implements View.OnFocusChangeListener, View.OnKeyListener {
    public static final String TAG = VerifyCodeInputView.class.getSimpleName();
    List<EditText> vcEtList;
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
        vcEtList = new LinkedList<>();
        vcEtList.add((EditText) findViewById(R.id.vc_et0));
        vcEtList.add((EditText) findViewById(R.id.vc_et1));
        vcEtList.add((EditText) findViewById(R.id.vc_et2));
        vcEtList.add((EditText) findViewById(R.id.vc_et3));
        vcEtList.add((EditText) findViewById(R.id.vc_et4));
        vcEtList.add((EditText) findViewById(R.id.vc_et5));
        vcEmptyView = (TextView) findViewById(R.id.vc_emptyView);
        initOnFocusChangeListener();
        initOnKeyListener();
    }

    private void initOnKeyListener() {
        for (EditText editText : vcEtList) {
            editText.setOnKeyListener(this);
        }
    }

    private void initOnFocusChangeListener() {
        for (EditText editText : vcEtList) {
            editText.setOnFocusChangeListener(this);
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        for (EditText editText : vcEtList) {
            if (editText.hasFocus()) {
                vcEmptyView.setVisibility(INVISIBLE);
                editText.setSelection(editText.getText().length());
                return;
            }
        }
        for (EditText editText : vcEtList) {
            if (!TextUtils.isEmpty(editText.getText().toString())) {
                vcEmptyView.setVisibility(INVISIBLE);
                return;
            }
        }
        vcEmptyView.setVisibility(VISIBLE);
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        for (int i = 0; i < vcEtList.size(); ++i) {
            if (v.getId() == vcEtList.get(i).getId()) {
                if (keyCode == KeyEvent.KEYCODE_BACK) return false;
                if (event.getAction() != KeyEvent.ACTION_UP) return true;

                EditText editText = (EditText) v;
                if (TextUtils.isEmpty(editText.getText().toString())) {
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
                            editText.setText(Character.toString((char) event.getUnicodeChar()));
                            editText.setSelection(editText.getText().length());
                            if (i < (vcEtList.size() - 1)) {
                                vcEtList.get(i + 1).requestFocus();
                            }
                            break;
                        case KeyEvent.KEYCODE_DEL:
                            if (i > 0) {
                                vcEtList.get(i - 1).requestFocus();
                            }
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
                            editText.setText(Character.toString((char) event.getUnicodeChar()));
                            if (i < (vcEtList.size() - 1)) {
                                vcEtList.get(i + 1).requestFocus();
                            } else {
                                editText.setSelection(editText.getText().length());
                            }
                            break;
                        case KeyEvent.KEYCODE_DEL:
                            editText.setText("");
                            break;

                        default:
                            break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (int i = vcEtList.size() - 1; i >= 0; --i) {
                if (!TextUtils.isEmpty(vcEtList.get(i).getText().toString())) {
                    vcEtList.get(Math.max(0, Math.min(i + 1, vcEtList.size() - 1))).requestFocus();
                    ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(vcEtList.get(Math.max(0, Math.min(i + 1, vcEtList.size() - 1))), 0);
                    break;
                } else {
                    if (i == 0) {
                        vcEtList.get(0).requestFocus();
                        ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(vcEtList.get(0), 0);
                        break;
                    }
                }
            }
        }
        return true;
    }
}
