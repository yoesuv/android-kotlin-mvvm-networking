package com.yoesuv.networkkotlin2

import androidx.appcompat.widget.AppCompatButton
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingPolicies
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.yoesuv.networkkotlin2.main.views.MainActivity
import com.yoesuv.networkkotlin2.utils.IdlingResource
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Before
    fun register() {
        IdlingPolicies.setIdlingResourceTimeout(15, TimeUnit.SECONDS)
        IdlingRegistry.getInstance().register(IdlingResource.idlingresource)
    }

    @After
    fun unregister() {
        IdlingRegistry.getInstance().unregister(IdlingResource.idlingresource)
    }

    @Test
    fun load1ListPlace() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            activity.findViewById<AppCompatButton>(R.id.buttonOne).performClick()
            onView(allOf(withId(R.id.recyclerviewListPlace), isDisplayed()))
            activity.onBackPressedDispatcher.onBackPressed()
        }
    }

    @Test
    fun load2ListGallery() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            activity.findViewById<AppCompatButton>(R.id.buttonTwo).performClick()
            onView(allOf(withId(R.id.recyclerviewGallery), isDisplayed()))
            activity.onBackPressedDispatcher.onBackPressed()
        }
    }
}