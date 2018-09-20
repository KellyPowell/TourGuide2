package com.example.android.tourguide.Tests

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import android.support.test.espresso.intent.rule.IntentsTestRule
import com.example.android.tourguide.Models.ShoppingActivityModel
import com.example.android.tourguide.ShoppingActivity
import org.hamcrest.core.IsNot
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ShoppingActivityTests {
    private val shoppingActivityModel = ShoppingActivityModel()

    @get:Rule
    var intentsTestRule = IntentsTestRule<ShoppingActivity>(ShoppingActivity::class.java)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        //Before Test case execution
    }

    /**
     * By default, Espresso Intents won't stub your intents. Since we just want to verify that the
     * phone intent was started, let's just have all intents return {@value Activity#RESULT_OK}.
     */
    @Before
    fun stubAllExternalIntents() {
        intending(hasAction(Intent.ACTION_DIAL)).respondWith(
                Instrumentation.ActivityResult(Activity.RESULT_OK, null))
        intending(IsNot.not(IntentMatchers.isInternal())).respondWith(
                Instrumentation.ActivityResult(Activity.RESULT_OK, null))
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        //After Test case Execution
    }

    @Test
    @Throws(Exception::class)
    // click on ByTheBay from list, click phone, check intent
    fun clickOnByTheBayAndDialPhone() {
        shoppingActivityModel.open0AndTapPhone()
    }

    @Test
    @Throws(Exception::class)
    // click on ByTheBay from list, click website, check intent
    fun clickOnByTheBayAndLaunchWebsite() {
        shoppingActivityModel.open0AndTapWebsite()
    }

    @Test
    @Throws(Exception::class)
    // click on Tapatio from list, click map, check intent
    fun clickOnByTheBayAndLaunchMap() {
        shoppingActivityModel.open0AndTapMap()
    }

    @Test
    @Throws(Exception::class)
    // click on BoltAbout from list, swipe down to see more, click phone, check intent
    fun clickOnBoltAboutAndDialPhone() {
        shoppingActivityModel.open2AndTapPhone()
    }

    @Test
    @Throws(Exception::class)
    // click on BoltAbout from list, swipe down to see more, click website, check intent
    fun clickOnBoltAboutAndTapWebsite() {
        shoppingActivityModel.open2AndTapWebsite()
    }

    @Test
    @Throws(Exception::class)
    // click on BoltAbout from list, swipe down to see more, click map, check intent
    fun clickOnBoltAboutAndLaunchMap() {
        shoppingActivityModel.open2AndTapMap()
    }
}
