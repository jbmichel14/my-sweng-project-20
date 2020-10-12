package com.github.jbmichel14.bootcamp;


import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class GreetingActivtiyTest {

    @Test
    public void GreetingActivityDisplaysCorrectUsername(){
        String name = "Jay";
        String greeting = "Hello Jay!";

        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        intent.putExtra(GreetingActivity.EXTRA_USER_NAME, name);
        ActivityScenario.launch(intent);





        try (ActivityScenario<GreetingActivity> scenario = ActivityScenario.launch(intent)) {
            onView(withId(R.id.greetingMessage)).check(matches(withText(greeting)));
        }




    }




}
