package com.navin.melalwallet;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.navin.melalwallet.ui.login.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LoginTest {



    @Rule
    public ActivityTestRule<LoginActivity>  loginActivityActivityTestRule =

            new ActivityTestRule<LoginActivity>(LoginActivity.class);


    @Test
    public void click_button () throws Exception {


        onView(withId(R.id.edt_username))
                .perform(typeText("f"),closeSoftKeyboard());


        onView(withId(R.id.edt_password))
                .perform(typeText("f"),closeSoftKeyboard());

        onView(withId(R.id.btn_login))
                .perform(click());

    }

}
