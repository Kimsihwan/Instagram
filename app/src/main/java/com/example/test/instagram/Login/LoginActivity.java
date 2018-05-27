package com.example.test.instagram.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.instagram.Home.HomeActivity;
import com.example.test.instagram.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private Context mContext;
    private ProgressBar mProgressBar;
    private EditText mEmail, mPassword;
    private TextView mPleaseWait;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mPleaseWait = (TextView) findViewById(R.id.pleaseWait);
        mEmail = (EditText) findViewById(R.id.input_email);
        mPassword = (EditText) findViewById(R.id.input_password);
        mContext = LoginActivity.this;
        Log.d(TAG, "onCreate: stared.");

        mPleaseWait.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);

        setupFirebaseAuth();
        init();

    }

    private boolean isStringNull(String string){
        Log.d(TAG, "isStringNull: checking string if null");
        if(string.equals("")){
            return true;
        } else{
            return false;
        }
    }

     /*
    -------------------------------------Firebase-----------------------------------------------------
     */

     private void init(){

         //initialize the button for logging in
         Button btnLogin = (Button) findViewById(R.id.btn_login);
         btnLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Log.d(TAG, "onClick: attemptting to log in.");

                 String email = mEmail.getText().toString();
                 String password = mPassword.getText().toString();

                 if(isStringNull(email) && isStringNull(password)){
                     Toast.makeText(mContext, "아이디나 비밀번호 적어주세요", Toast.LENGTH_SHORT).show();
                 } else {
                     mProgressBar.setVisibility(View.VISIBLE);
                     mPleaseWait.setVisibility(View.VISIBLE);

                     mAuth.signInWithEmailAndPassword(email, password)
                             .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                 @Override
                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                     Log.d(TAG, "signInWithEmail:onComplete: " + task.isSuccessful());
                                     FirebaseUser user = mAuth.getCurrentUser();

                                     if (!task.isSuccessful()){
                                         Log.w(TAG, "signInWithEmail:로그인 실패", task.getException() );

                                         Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_SHORT).show();
                                         mProgressBar.setVisibility(View.GONE);
                                         mPleaseWait.setVisibility(View.GONE);
                                     } else{
                                         try{
                                             if(user.isEmailVerified()){
                                                 Log.d(TAG, "onComplete: success. email is verified.");
                                                 Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                                 startActivity(intent);
                                             } else{
                                                 Toast.makeText(mContext, "이메일 인증이 되지 않았습니다. \n 이메일 확인 해주세요.", Toast.LENGTH_SHORT).show();
                                                 mProgressBar.setVisibility(View.GONE);
                                                 mPleaseWait.setVisibility(View.GONE);
                                                 mAuth.signOut();
                                             }
                                         }catch (NullPointerException e){
                                             Log.d(TAG, "onComplete: NullPorinterException:" + e.getMessage());
                                         }
                                     }
                                 }
                             });

                 }
             }
         });

         TextView linkSignUp= (TextView) findViewById(R.id.link_signup);
         linkSignUp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Log.d(TAG, "onClick: navigating to register screen");
                 Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                 startActivity(intent);
             }
         });

         /*
         If the user is logged in then navigation to HomeActivity and call 'finish()'
          */
         if(mAuth.getCurrentUser() != null){
             Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
             startActivity(intent);
             finish();
         }
     }

    /**
     *  Setup the firebase auth object
     */

    private void setupFirebaseAuth(){
        Log.d(TAG, "setupFirebaseAuth: setting up firebase auth.");

        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null){
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged: signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged: signed_out");

                }
            }
        };
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthStateListener != null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
}
