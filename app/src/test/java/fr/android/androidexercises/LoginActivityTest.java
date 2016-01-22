package fr.android.androidexercises;

import android.content.Intent;

import junit.framework.TestCase;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowHandler;
import org.robolectric.shadows.ShadowToast;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Darknight on 22/01/2016.
 */
@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTest {

    LoginActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void testNotLogged() throws Exception {
        activity.logged();

        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();

    }

    @Test
    public void testLogged() throws Exception {
        activity.notLogged();

        Assertions.assertThat(activity.loginLayout).isVisible();
        Assertions.assertThat(activity.loggedText).isGone();
    }

    @Test
    public void testMessage() throws Exception {
        activity.message(R.string.action_login);
        String textToast =ShadowToast.getTextOfLatestToast();
        org.assertj.core.api.Assertions.assertThat(textToast).isEqualTo("log me in");
    }
}