package kr.co.shlim.android;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginView extends ConstraintLayout implements View.OnClickListener {
    private Context mContext;

    private ConstraintLayout mRootLayout;
    private EditText mIDEdit;
    private EditText mPWEdit;
    private Button mLogInBtn;

    public LoginView(Context context) {
        super(context);
        initLayout(context);
    }

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public LoginView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    /**
     * layout 초기화
     * @param cxt
     */
    private void initLayout(Context cxt) {
        mContext = cxt;
        View view = inflate(mContext, R.layout.login_layout, this);
        bindView(view);
    }

    /**
     * view 지정
     * @param view
     */
    private void bindView(View view) {
        mRootLayout = view.findViewById(R.id.constraintLayout);
        mIDEdit = view.findViewById(R.id.login_edit);
        mPWEdit = view.findViewById(R.id.password_edit);
        mLogInBtn = view.findViewById(R.id.login_btn);
        mLogInBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                if(false == validInput()) {
                    Toast.makeText(mContext, mContext.getString(R.string.input_check), Toast.LENGTH_SHORT).show();
                }else {
                    //TODO 서버 연동(로그인)
                }
                break;
        }
    }

    /**
     * 입력값이 유효한지 리턴한다.
     * @return
     */
    private boolean validInput() {
        boolean isValid = false;

        String id = mIDEdit.getText().toString();
        String password = mPWEdit.getText().toString();

        if(!TextUtils.isEmpty(id) && !TextUtils.isEmpty(password)) {
            isValid = true;
        }
        return isValid;
    }
}
