package com.yoesuv.networkkotlin2

import android.content.Context
import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.yoesuv.networkkotlin2.main.views.MainActivity
import com.yoesuv.networkkotlin2.utils.IdlingResource
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@LargeTest
class MainActivityTest {
    private val delay = 1000L
    private lateinit var context: Context
    private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun register() {
        hiltRule.inject()
        context = InstrumentationRegistry.getInstrumentation().targetContext
        IdlingRegistry.getInstance().register(IdlingResource.idlingresource)
    }

    @After
    fun unregister() {
        IdlingRegistry.getInstance().unregister(IdlingResource.idlingresource)
    }

    @Test
    fun load1MainTest() {
        onView(withText(context.getString(R.string.pilih_menu))).check(matches(isDisplayed()))
        onView(withId(R.id.buttonOne)).perform(click())
        SystemClock.sleep(delay)
        device.pressBack()
        SystemClock.sleep(delay)
        onView(withId(R.id.buttonTwo)).perform(click())
        SystemClock.sleep(delay)
        device.pressBack()
    }

    @Test
    fun load2ListPlaceTest() {
        onView(withId(R.id.buttonOne)).perform(click())
        SystemClock.sleep(delay)
        onView(allOf(withId(R.id.recyclerviewListPlace), isDisplayed()))
            .perform(swipeDown())
            .perform(swipeUp())
        SystemClock.sleep(delay)
        device.pressBack()
    }

    @Test
    fun load3ListGalleryTest() {
        onView(withId(R.id.buttonTwo)).perform(click())
        SystemClock.sleep(delay)
        onView(allOf(withId(R.id.recyclerviewGallery), isDisplayed()))
            .perform(swipeDown())
            .perform(swipeUp())
        SystemClock.sleep(delay)
        device.pressBack()
    }
}
