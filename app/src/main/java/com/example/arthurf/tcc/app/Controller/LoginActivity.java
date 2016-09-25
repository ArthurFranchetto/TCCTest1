package com.example.arthurf.tcc.app.Controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.design.widget.Snackbar;
import android.widget.Toast;


import com.example.arthurf.tcc.app.R;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import model.Morador;
import network.MoradorRequester;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Object> {

    private static final int REQUEST_READ_CONTACTS = 0;
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "Arthur Franchetto:14/05/1992:arthur.franchetto@gmail.com:1:admin",
            "Guilherme Pelin:01/01/1992:guilhermepelin@gmail.com:2:admin2",
            "Patricia Akemy:01/01/1992:patricia.akemy@gmail.com:3:admin3"
    };

    private UserLoginTask mAuthTask = null;

    private TextView username;
    private EditText mPassword;
    private View mProgressView;
    private View mLoginFormView;
    public static String nome = null;
    public static String email = null;
    public static String data = null;
    public static String apartamento = null;

    public MoradorRequester requester;
    Morador morador;
    final String servidor = "192.168.1.102:8080/tcc_SI_M_12_-_07-08-2016_v1";
    public Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (TextView) findViewById(R.id.etUsername);


        mPassword = (EditText) findViewById(R.id.etPassword);

        Button bLogin = (Button) findViewById(R.id.bSignIn);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private void attemptLogin() {

        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        username.setError(null);
        mPassword.setError(null);

        // Store values at the time of the login attempt.
        String email = username.getText().toString();
        String password = mPassword.getText().toString();

        email = email.replaceAll(" ", "");

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPassword.setError(getString(R.string.error_invalid_password));
            focusView = mPassword;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            username.setError(getString(R.string.error_field_required));
            focusView = username;
            cancel = true;
        } else if (!isEmailValid(email)) {
            username.setError(getString(R.string.error_invalid_email));
            focusView = username;
            cancel = true;
        }

        if (email.length() <= 1) {
            email = email.toLowerCase();
        } else {
            email = email.substring(0, 1).toLowerCase() + email.substring(1);
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);

            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }


    @Override
    public Loader<Object> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Object> loader, Object o) {

    }

    @Override
    public void onLoaderReset(Loader<Object> loader) {

    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPasswordU;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPasswordU = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            requester = new MoradorRequester();

            if(requester.isConnected(LoginActivity.this)) {
                intent = new Intent(LoginActivity.this, UserAreaActivity.class);

                try {
                    morador = requester.get("http://" + servidor + "/ValidacaoLoginAndroid.json", mEmail, mPasswordU);


                            intent.putExtra("MORADOR", morador);
                            if(morador.getValidacao() == true){
                            startActivity(intent);}

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Toast toast = Toast.makeText(LoginActivity.this, "Rede indisponível!", Toast.LENGTH_LONG);
                toast.show();
            }

            return false;
        }


        @Override
        protected void onCancelled() {
            mAuthTask = null;

            showProgress(false);
        }
    }


}
