package com.example.cryptoapp.view.fragment

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withSpinnerText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cryptoapp.R
import junit.framework.TestCase
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.Matchers.containsString
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CryptoFragmentAndroidTest : TestCase() {

    private lateinit var scenario: FragmentScenario<CryptoFragment>

    @Before
    override fun setUp() {
        scenario = launchFragmentInContainer()
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testSelectedSpinnerValue() {
        onView(withId(R.id.crypto_filter_spinner)).perform(click())
        onData(anything()).atPosition(1).perform(click())
        onView(withId(R.id.crypto_filter_spinner)).check(matches(withSpinnerText(containsString(R.array.spinner_content.toString()))))
    }

    @After
    fun testFragmentCreated() {
        scenario.moveToState(Lifecycle.State.DESTROYED)
    }
}