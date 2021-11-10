package com.example.android_bootcamp_anuj

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    /**
     * Use this create and launch the activity under test before each test,
     * and close it after each test.
     */
    @get:Rule
    var activityTestRule = androidx.test.rule.ActivityTestRule(MainActivity::class.java)

    /**
     * Use this test to uncheck the checkbox
     */
    @Test
    fun testAddToFavorite_CheckBoxNotChecked() {
        Espresso.onView(withId(R.id.addToFavorite_BTN))
            .perform(ViewActions.click())
        Espresso.onView(withId(R.id.itemFavorite_CB))
            .check(ViewAssertions.matches(ViewMatchers.isNotChecked()))
    }

    /**
     * Use this test to check the checkbox
     */
    @Test
    fun testAddToFavorite_CheckBoxChecked() {
        Espresso.onView(withId(R.id.addToFavorite_BTN))
            .perform(ViewActions.click())
        Espresso.onView(withId(R.id.itemFavorite_CB))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
    }
}