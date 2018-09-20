package com.example.android.tourguide.Models


import android.app.Instrumentation
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.example.android.tourguide.*
import org.junit.Assert.assertNotNull

class MainActivityModel {

    private val diningTextView = onView(withId(R.id.dining_text_view))
    private val outdoorsTextView = onView(withId(R.id.outdoours_text_view))
    private val shoppingTextView = onView(withId(R.id.shopping_text_view))
    private val artTextView = onView(withId(R.id.art_text_view))

    internal var diningMonitor: Instrumentation.ActivityMonitor = getInstrumentation().addMonitor(DiningActivity::class.java.getName(), null, false)
    internal var outdoorMonitor: Instrumentation.ActivityMonitor = getInstrumentation().addMonitor(OutdoorsActivity::class.java.getName(), null, false)
    internal var artMonitor: Instrumentation.ActivityMonitor = getInstrumentation().addMonitor(ArtActivity::class.java.getName(), null, false)
    internal var shoppingMonitor: Instrumentation.ActivityMonitor = getInstrumentation().addMonitor(ShoppingActivity::class.java.getName(), null, false)


    // click on Dining category, verify activity, then click back to return to MainActivity
    fun clickOnDiningAndBack() {
        assertNotNull(diningTextView.perform(click()))
        val diningActivity = getInstrumentation().waitForMonitorWithTimeout(diningMonitor, 5000)
        assertNotNull(diningActivity)
        pressBack()
    }

    // click on Outdoors category, verify activity, then click back to return to MainActivity
    fun clickOnOutdoorsAndBack() {
        assertNotNull(outdoorsTextView.perform(click()))
        val outdoorActivity = getInstrumentation().waitForMonitorWithTimeout(outdoorMonitor, 5000)
        assertNotNull(outdoorActivity)
        pressBack()
    }

    // click on Shopping category, verify activity, then click back to return to MainActivity
    fun clickOnShoppingAndBack() {
        assertNotNull(shoppingTextView.perform(click()))
        val shoppingActivity = getInstrumentation().waitForMonitorWithTimeout(shoppingMonitor, 5000)
        assertNotNull(shoppingActivity)
        pressBack()
    }

    // click on Art category, verify activity, then click back to return to MainActivity
    fun clickOnArtAndBack() {
        assertNotNull(artTextView.perform(click()))
        val artActivity = getInstrumentation().waitForMonitorWithTimeout(artMonitor, 5000)
        assertNotNull(artActivity)
        pressBack()
    }

    fun verifyAllDefaultElements() {

        closeSoftKeyboard()
        diningTextView.check(matches(isDisplayed()))
        outdoorsTextView.check(matches(isDisplayed()))
        shoppingTextView.check(matches(isDisplayed()))
        artTextView.check(matches(isDisplayed()))
    }
}


