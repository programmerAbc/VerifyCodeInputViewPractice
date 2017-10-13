package com.practice.verifycodeinputviewlib;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
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

public class VerifyCodeInputView extends FrameLayout {
    public static final String TAG = VerifyCodeInputView.class.getSimpleName();
    List<TextView> vcTvList;
    List<View> vcUlList;
    EditText vcInputEt;

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
        vcTvList = new LinkedList<>();
        vcUlList = new LinkedList<>();
        vcTvList.add((TextView) findViewById(R.id.vc_tv0));
        vcTvList.add((TextView) findViewById(R.id.vc_tv1));
        vcTvList.add((TextView) findViewById(R.id.vc_tv2));
        vcTvList.add((TextView) findViewById(R.id.vc_tv3));
        vcTvList.add((TextView) findViewById(R.id.vc_tv4));
        vcTvList.add((TextView) findViewById(R.id.vc_tv5));
        vcUlList.add(findViewById(R.id.vc_ul0));
        vcUlList.add(findViewById(R.id.vc_ul1));
        vcUlList.add(findViewById(R.id.vc_ul2));
        vcUlList.add(findViewById(R.id.vc_ul3));
        vcUlList.add(findViewById(R.id.vc_ul4));
        vcUlList.add(findViewById(R.id.vc_ul5));
        vcInputEt = (EditText) findViewById(R.id.vc_inputEt);
        vcInputEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateUnderLine();
                updateVerifyCodeShowGrid();
            }
        });
        vcInputEt.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    updateUnderLine();
                } else {
                    resetUnderLine();
                }
                vcInputEt.setHintTextColor(hasFocus ? 0x00000000 : 0xff909090);
            }
        });
        resetUnderLine();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            vcInputEt.requestFocus();
            vcInputEt.setSelection(vcInputEt.getText().length());
            ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(vcInputEt, 0);
        }
        return true;
    }

    public void resetVerifyCodeShowGrid() {
        for (TextView textView : vcTvList) {
            textView.setText("");
        }
    }

    public void updateVerifyCodeShowGrid() {
        resetVerifyCodeShowGrid();
        Editable editable = vcInputEt.getText();
        for (int i = 0; i < editable.length(); ++i) {
            vcTvList.get(i).setText(Character.toString(editable.charAt(i)));
        }
    }

    public void resetUnderLine() {
        for (View line : vcUlList) {
            line.setEnabled(false);
        }
    }

    public void updateUnderLine() {
        resetUnderLine();
        if (vcInputEt.getText().length() < vcUlList.size()) {
            vcUlList.get(vcInputEt.getText().length()).setEnabled(true);
        } else {
            vcUlList.get(vcUlList.size() - 1).setEnabled(true);
        }
    }

    public String getVerifyCode() {
        return vcInputEt.getText().toString();
    }
}
