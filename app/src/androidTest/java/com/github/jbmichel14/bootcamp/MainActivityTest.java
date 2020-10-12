package com.github.jbmichel14.bootcamp;


import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void enterNameWorks(){
        onView(withId(R.id.mainName)).perform(ViewActions.click()).perform(ViewActions.typeText("Jay"));
    }

    @Test
    public void clickingButtonSayHiChangesActivity(){
        onView(withId(R.id.mainGoButton)).perform(ViewActions.click());
    }

    @Test
    public void clickingSayHiKeepsTheCorrectName(){
        Intents.init();
        String name = "Jay";
        String greeting = "Hello Jay!";
        onView(withId(R.id.mainName)).perform(ViewActions.click())
                .perform(ViewActions.clearText()).perform(ViewActions.typeText(name))
                .perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.mainGoButton)).perform(ViewActions.click());

        //Intent stuff

        onView(withId(R.id.greetingMessage)).check(matches(withText(greeting)));

        Intents.release();
    }






}
