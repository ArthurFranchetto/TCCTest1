package com.example.arthurf.tcc.app.Controller;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.arthurf.tcc.app.R;
import java.io.IOException;
import model.Morador;
import network.MoradorRequester;


public class LoginActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Object> {

    private UserLoginTask mAuthTask = null;
    private TextView username;
    private EditText mPassword;
    private View mProgressView;
    private View mLoginFormView;;
    public MoradorRequester requester;
    public Morador morador;
    public Intent intent;

    final String servidor = "10.0.2.2:8080/tcc_SI_M_12_-_21-10-2016_v4";



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

    public final boolean isCancelled() {
        return true;
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
                            else{
                                cancel(true);
                            }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Toast toast = Toast.makeText(LoginActivity.this, "Rede indisponível!", Toast.LENGTH_LONG);
                toast.show();
            }

            Snackbar.make(findViewById(android.R.id.content), "Usuário e/ou senha inválido(s)", Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.RED)
                    .show();
            cancel(true);
            return false;
        }


        @Override
        protected void onCancelled() {
            mAuthTask = null;

            showProgress(false);
        }
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


}
