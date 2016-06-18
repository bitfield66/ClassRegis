package mobile.project1.com.classregis;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtStudentId, edtPassword;
    private ImageView ivLogin;
    private ProgressBar pbProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        defineControls();
        ivLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(validateUserLogin()){
                pbProgress.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(LoginActivity.this, ChooseOptionActivity.class);
                        startActivity(i);
                        finish();
                    }
                },1000);

            }
            }
        });
    }

    private void defineControls() {
        ivLogin = (ImageView) findViewById(R.id.ivLogin);
        edtStudentId = (EditText) findViewById(R.id.edtStudentId);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        pbProgress = (ProgressBar) findViewById(R.id.pbProgress);
    }

/*
     validateUserLogin()
     Method is used to validate user by hitting api
 */
    private boolean validateUserLogin(){
        boolean isAllowed = true;
        String studentID = edtStudentId.getText().toString();
        String password = edtPassword.getText().toString();
        if(TextUtils.isEmpty(studentID)){
            isAllowed = false;
            Toast.makeText(LoginActivity.this,"Please enter student id",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(password)) {
            isAllowed = false;
            Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_LONG).show();
        }

        return isAllowed;
    }
}
