package com.example.myapplicationtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText edUserId;
    private EditText edUserPwd;
    private CheckBox checkBox;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        edUserId = findViewById(R.id.userID);
        edUserPwd = findViewById(R.id.userPwd);
        checkBox = findViewById(R.id.cb_rem_userID);
        checkBox.setChecked(getSharedPreferences("login",MODE_PRIVATE)
                .getBoolean("REMEMBE_USERID",false));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                getSharedPreferences("login",MODE_PRIVATE)
                        .edit()
                        .putBoolean("REMEMBE_USERID",b)
                        .commit();
            }
        });

        String USER_ID = getSharedPreferences("login",MODE_PRIVATE)
                .getString("USER_ID","");
        String USER_PWD = getSharedPreferences("login",MODE_PRIVATE)
                .getString("USER_PWD","");
        edUserId.setText(USER_ID);
       // Log.d(TAG,"onCreate======USER_PWD============"+USER_PWD);
    }

    public void login(View view){
        String userId = edUserId.getText().toString();
        String userPwd = edUserPwd.getText().toString();
        if("jay".equals(userId) && "admin".equals(userPwd)){
            boolean bREMEMBER = getSharedPreferences("login",MODE_PRIVATE)
                    .getBoolean("REMEMBE_USERID",false);

            String userIdSave = "";
            if(bREMEMBER) {
                userIdSave = userId;
            }
            getSharedPreferences("login", MODE_PRIVATE)
                    .edit()
                    .putString("USER_ID", userIdSave)
                    //.putString("USER_PWD","admin")
                    .apply();//or commit

            finish();
        }else{
            String message = "帳號密碼輸入錯誤";
            if(userId.length() == 0){
                message = "帳號不可空白";
            }else if(userPwd.length() == 0){
                message = "密碼不可空白";
            }

            new AlertDialog.Builder(this)
                    .setTitle("提示訊息")
                    .setMessage(message)
                    .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            edUserId.setText("");
                            edUserPwd.setText("");
                        }
                    })
                    .show();
            return;
        }
    }
}