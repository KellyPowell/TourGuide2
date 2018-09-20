package com.example.android.tourguide.Tests
import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import com.example.android.tourguide.Models.OutdoorsActivityModel
import com.example.android.tourguide.OutdoorsActivity
import org.hamcrest.core.IsNot
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class OutdoorsActivityTests {
    private val outdoorsActivityModel = OutdoorsActivityModel()

    @get:Rule
    var intentsTestRule = IntentsTestRule<OutdoorsActivity>(OutdoorsActivity::class.java)

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
    // click on Moonstone Beach from list, click website, check intent
    fun clickOnMoonstoneBeachTapWebsite() {
        outdoorsActivityModel.openMoonstoneAndTapWebsite()
    }

    @Test
    @Throws(Exception::class)
    // click on Moonstone Beach from list, click map, check intent
    fun clickOnMoonstoneBeachMap() {
        outdoorsActivityModel.openMoonstoneAndTapMap()
    }

    @Test
    @Throws(Exception::class)
    // click on Oso Flaco from list, click website, check intent
    fun clickOnOsoTapWebsite() {
        outdoorsActivityModel.openOsoAndTapWebsite()
    }

    @Test
    @Throws(Exception::class)
    // click on Oso Flaco from list, click map, check intent
    fun clickOnOsoMap() {
        outdoorsActivityModel.openOsoAndTapMap()
    }

    @Test
    @Throws(Exception::class)
    // click on Oso Flaco from list, click website, check intent
    fun clickOnMorroTapWebsite() {
        outdoorsActivityModel.openMorroRockAndTapWebsite()
    }

    @Test
    @Throws(Exception::class)
    // click on Oso Flaco from list, click map, check intent
    fun clickOnMorroRockMap() {
        outdoorsActivityModel.openMorroRockAndTapWebsite()
    }
}
