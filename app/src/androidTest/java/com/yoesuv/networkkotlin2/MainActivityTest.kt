package com.yoesuv.networkkotlin2

import android.content.Context
import android.os.SystemClock
import androidx.appcompat.widget.AppCompatButton
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingPolicies
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.yoesuv.networkkotlin2.main.views.MainActivity
import com.yoesuv.networkkotlin2.utils.IdlingResource
import org.hamcrest.Matchers.allOf
import org.junit.*
import org.junit.runner.OrderWith
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@LargeTest
class MainActivityTest {

    private val delay = 0L
    private lateinit var context: Context
    private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun register() {
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
        /*val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            activity.findViewById<AppCompatButton>(R.id.buttonOne).performClick()
            onView(allOf(withId(R.id.recyclerviewListPlace), isDisplayed()))
            activity.onBackPressedDispatcher.onBackPressed()
        }*/
    }

    /*@Test
    fun load3ListGalleryTest() {
        onView(withId(R.id.buttonTwo)).perform(click())
        SystemClock.sleep(delay)
        //onView(allOf(withId(R.id.recyclerviewGallery), isDisplayed())).perform(swipeUp())
        /*val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            activity.findViewById<AppCompatButton>(R.id.buttonTwo).performClick()
            onView(allOf(withId(R.id.recyclerviewGallery), isDisplayed()))
            activity.onBackPressedDispatcher.onBackPressed()
        }*/
    }*/
}