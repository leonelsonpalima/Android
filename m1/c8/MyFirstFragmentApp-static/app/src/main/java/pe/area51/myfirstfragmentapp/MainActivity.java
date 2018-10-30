package pe.area51.myfirstfragmentapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnShowWelcomeClickListener {

<<<<<<< HEAD
=======
    private final static String FRAGMENT_TAG_LOGIN = "LoginFragment";
    private final static String FRAGMENT_TAG_WELCOME = "WelcomeFragment";

>>>>>>> efcda075c2a4068226b8c41a8e27829667057a1f
    private WelcomeFragment welcomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager = getSupportFragmentManager();
<<<<<<< HEAD
        welcomeFragment = (WelcomeFragment) fragmentManager.findFragmentById(R.id.fragment_welcome);
        final LoginFragment loginFragment = (LoginFragment) fragmentManager.findFragmentById(R.id.fragment_login);
        loginFragment.setOnShowWelcomeClickListener(this);
=======
        final LoginFragment loginFragment;

        if(savedInstanceState == null) {
            loginFragment = new LoginFragment();
            welcomeFragment = new WelcomeFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainer1, loginFragment, FRAGMENT_TAG_LOGIN)
                    .replace(R.id.fragmentContainer2, welcomeFragment, FRAGMENT_TAG_WELCOME)
                    .commit();
            loginFragment.setOnShowWelcomeClickListener(this);
            return;
        }
        loginFragment = (LoginFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG_LOGIN);
        welcomeFragment = (WelcomeFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG_WELCOME);
        loginFragment.setOnShowWelcomeClickListener(this);


>>>>>>> efcda075c2a4068226b8c41a8e27829667057a1f
    }

    @Override
    public void onShowWelcomeClick(String name) {
        welcomeFragment.setWelcomeMessage(getString(R.string.welcome_message, name));
    }
}
