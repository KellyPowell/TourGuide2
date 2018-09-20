package com.example.android.tourguide.Models

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.swipeUp
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers.*
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.view.View
import com.example.android.tourguide.DestinationAdapter1
import com.example.android.tourguide.R
import org.hamcrest.Matchers.anything
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.IsNot.not

class DiningActivityModel {


    private val visiblePhoneIcon = onView(allOf<View>(withId(R.id.phone_icon), isDisplayed()))
    private val visibleWebsiteIcon = onView(allOf<View>(withId(R.id.website_icon), isDisplayed()))
    private val visibleMapIcon = onView(allOf<View>(withId(R.id.map_icon), isDisplayed()))
    private val tapatio = ViewMatchers.withChild(ViewMatchers.withChild(ViewMatchers.withText("El Tapatio")))
    private val giuseppes = ViewMatchers.withChild(ViewMatchers.withChild(ViewMatchers.withText("Giuseppe's")))
    //private val tapatio = onData(anything()).inAdapterView(withId(R.id.recycler_view)).atPosition(0)
    //private val giuseppes = onData(anything()).inAdapterView(withId(R.id.recycler_view)).atPosition(6)
    private val list = onView(withId(R.id.recycler_view))

    // Test expanding Tapatio and dialing phone
    @Throws(Exception::class)
    fun open0AndTapPhone() {
        // item 0 (Tapatio) and click to expand
        //tapatio.perform(click())
        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(tapatio, click()))
        // click on phone icon
        visiblePhoneIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_DIAL),
                hasData(INTENT_DATA_TACO_PHONE)))
    }

    // Test expanding Tapatio and tapping website
    @Throws(Exception::class)
    fun open0AndTapWebsite() {
        intending(not(isInternal())).respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(tapatio, click()))
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_TAPATIO_WEBSITE)))
    }

    // Test expanding Tapatio and tapping map
    @Throws(Exception::class)
    fun open0AndTapMap() {
        intending(not(isInternal())).respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(tapatio, click()))
        // click on website icon
        visibleMapIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_TAPATIO_MAP)))
    }

    // Tap Giuseppe's, scroll up to show contact icons, taps phone
    @Throws(Exception::class)
    fun open6AndTapPhone() {
        // item 6 (Giuseppe's) and click to expand
        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(giuseppes, click()))
        list.perform(swipeUp())
        // click on phone icon
        visiblePhoneIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_DIAL),
                hasData(INTENT_DATA_GIU_PHONE)))
    }

    // Test expanding Giuseppe's and tapping website icon, test intent
    @Throws(Exception::class)
    fun open6AndTapWebsite() {
        intending(not(isInternal())).respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(giuseppes, click()))
        list.perform(swipeUp())
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_GIUSEPPES_WEBSITE)))
    }

    // Test expanding Giuseppe's and tapping map icon, test intent
    @Throws(Exception::class)
    fun open6AndTapMap() {
        intending(not(isInternal())).respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(giuseppes, click()))
        list.perform(swipeUp())
        // click on website icon
        visibleMapIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_GIUSEPPES_MAP)))
    }

    companion object {

        // to test dialing intent
        private val GIUSEPPES_PHONE_NUMBER = "805-773-2870"
        private val INTENT_DATA_GIU_PHONE = Uri.parse("tel:$GIUSEPPES_PHONE_NUMBER")
        private val TAPATIO_PHONE_NUMBER = "805-343-2850"
        private val INTENT_DATA_TACO_PHONE = Uri.parse("tel:$TAPATIO_PHONE_NUMBER")
        //private static String PACKAGE_ANDROID_DIALER = "com.android.server.telecom";

        // to test website intent
        private val INTENT_DATA_TAPATIO_WEBSITE = "https://www.yelp.com/biz/el-tapatio-guadalupe"
        private val INTENT_DATA_GIUSEPPES_WEBSITE = "http://giusepperustica.wixsite.com/pismogiuseppes"

        // to test maps intent
        private val INTENT_DATA_TAPATIO_MAP = "geo:0,0?q=El+Tapatio+Guadalupe+CA"
        private val INTENT_DATA_GIUSEPPES_MAP = "geo:0,0?q=891+Price+Street+Pismo Beach+CA+93449"
    }


}

