package com.example.android.tourguide.Tests

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import android.support.test.espresso.intent.rule.IntentsTestRule
import com.example.android.tourguide.ArtActivity
import com.example.android.tourguide.Models.ArtActivityModel
import org.hamcrest.core.IsNot
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class ArtActivityTests {
    private val artActivityModel = ArtActivityModel()

    @get:Rule
    var intentsTestRule = IntentsTestRule<ArtActivity>(ArtActivity::class.java)

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
    // click on Kelly from list, click phone, check intent
    fun clickKellyAndDialPhone() {
        artActivityModel.openKellyAndTapPhone()
    }

    @Test
    @Throws(Exception::class)
    // click on Kelly from list, click website, check intent
    fun clickKellyAndLaunchWebsite() {
        artActivityModel.openKellyAndTapWebsite()
    }

    @Test
    @Throws(Exception::class)
    // click on Kelly from list, click map, check intent
    fun clickKellyAndLaunchMap() {
        artActivityModel.openKellyAndTapMap()
    }

    @Test
    @Throws(Exception::class)
    // click on Bay from list, click phone, check intent
    fun clickBayAndDialPhone() {
        artActivityModel.openBayAndTapPhone()
    }

    @Test
    @Throws(Exception::class)
    // click on Bay from list, click website, check intent
    fun clickBayAndLaunchWebsite() {
        artActivityModel.openBayAndTapWebsite()
    }

    @Test
    @Throws(Exception::class)
    // click on Bay from list, click map, check intent
    fun clickBayAndLaunchMap() {
        artActivityModel.openBayAndTapMap()
    }

    @Test
    @Throws(Exception::class)
    // click on Kate from list, click phone, check intent
    fun clickKateAndDialPhone() {
        artActivityModel.openKateAndTapPhone()
    }

    @Test
    @Throws(Exception::class)
    // click on Bay from list, click website, check intent
    fun clickKateAndLaunchWebsite() {
        artActivityModel.openKateAndTapWebsite()
    }

    @Test
    @Throws(Exception::class)
    // click on Bay from list, click map, check intent
    fun clickKateAndLaunchMap() {
        artActivityModel.openKateAndTapMap()
    }
    @Test
    @Throws(Exception::class)
    // click on Elevator Art from list, click website, check intent
    fun clickElevatorAndLaunchWebsite() {
        artActivityModel.openElevatorAndTapWebsite()
    }

}
