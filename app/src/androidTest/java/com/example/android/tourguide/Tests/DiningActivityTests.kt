package com.example.android.tourguide.Tests

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.support.test.espresso.intent.rule.IntentsTestRule

import com.example.android.tourguide.DiningActivity
import com.example.android.tourguide.Models.DiningActivityModel

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import org.hamcrest.core.IsNot

class DiningActivityTests {

    private val diningActivityModel = DiningActivityModel()

    @get:Rule
    var intentsTestRule = IntentsTestRule<DiningActivity>(DiningActivity::class.java)

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
    // click on Tapatio from list, click phone, check intent
    fun clickOnTapatioAndDialPhone() {
        diningActivityModel.open0AndTapPhone()
    }

    @Test
    @Throws(Exception::class)
    // click on Tapatio from list, click website, check intent
    fun clickOnTapatioAndLaunchWebsite() {
        diningActivityModel.open0AndTapWebsite()
    }

    @Test
    @Throws(Exception::class)
    // click on Tapatio from list, click map, check intent
    fun clickOnTapatioAndLaunchMap() {
        diningActivityModel.open0AndTapMap()
    }


    @Test
    @Throws(Exception::class)
    // click on Giuseppes from list, swipe down to see more, click phone, check intent
    fun clickOnTGiuseppesAndDialPhone() {
        diningActivityModel.open6AndTapPhone()
    }

    @Test
    @Throws(Exception::class)
    // click on Giuseppes from list, swipe down to see more, click website, check intent
    fun clickOnGiuseppesAndTapWebsite() {
        diningActivityModel.open6AndTapWebsite()
    }

    @Test
    @Throws(Exception::class)
    // click on Giuseppes from list, swipe down to see more, click map, check intent
    fun clickOnGiuseppesAndLaunchMap() {
        diningActivityModel.open6AndTapMap()
    }
}
