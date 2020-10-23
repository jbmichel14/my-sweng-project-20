package com.github.jbmichel14.bootcamp;


import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class GreetingActivtiyTest {

    private static final String TEST_NAME = "Jay";

    @Test
    public void greetingActivityDisplaysCorrectUsername(){

        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);

        intent.putExtra(GreetingActivity.EXTRA_USER_NAME, TEST_NAME);

        try (ActivityScenario<GreetingActivity> scenario = ActivityScenario.launch(intent)) {
            onView(withId(R.id.greetingMessage)).check(matches(ViewMatchers.withText(Matchers.containsString(TEST_NAME))));
        }




    }




}
