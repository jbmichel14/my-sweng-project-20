package com.github.jbmichel14.bootcamp;


import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    // In general, it is good practice to keep test values in constant fields
    private static final String TEST_NAME = "JEAN-BAPTISTE";

    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void enterNameWorks(){
        onView(withId(R.id.mainName)).perform(ViewActions.click()).perform(ViewActions.typeText(TEST_NAME));
    }

    @Test
    public void clickingButtonSayHiChangesActivity(){
        onView(withId(R.id.mainGoButton)).perform(ViewActions.click());
    }

    @Test
    public void clickingSayHiKeepsTheCorrectName(){
        Intents.init();

        onView(withId(R.id.mainName)).perform(ViewActions.click())
                .perform(ViewActions.clearText(), ViewActions.typeText(TEST_NAME))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.mainGoButton)).perform(ViewActions.click());

        //Intent stuff
        Intents.intended(Matchers.allOf(
                IntentMatchers.hasComponent(GreetingActivity.class.getName()),
                IntentMatchers.hasExtra(GreetingActivity.EXTRA_USER_NAME, TEST_NAME)));

        Intents.release();
    }






}
