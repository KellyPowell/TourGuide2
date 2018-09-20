package com.example.android.tourguide.Models

import android.content.Intent
import android.net.Uri
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.swipeUp
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.*
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.android.tourguide.R
import org.hamcrest.core.AllOf.allOf

class ShoppingActivityModel {

    private val visiblePhoneIcon = onView(allOf<View>(withId(R.id.phone_icon), isDisplayed()))
    private val visibleWebsiteIcon = onView(allOf<View>(withId(R.id.website_icon), isDisplayed()))
    private val visibleMapIcon = onView(allOf<View>(withId(R.id.map_icon), isDisplayed()))
    // private val byTheBay = onView(allOf<View>(withText("Bay")))
    //  private val boltAbout = onData(anything()).inAdapterView(withId(R.id.list)).atPosition(2)
    private val list = onView(withId(R.id.recycler_view))

    // Test expanding ByTheBay and dialing phone
    @Throws(Exception::class)
    fun open0AndTapPhone() {
        // item 0  and click to expand
        list.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        // click on phone icon
        visiblePhoneIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_DIAL),
                hasData(INTENT_DATA_BYTHEBAY_PHONE)))
    }

    // Test expanding ByTheBay and tapping website
    @Throws(Exception::class)
    fun open0AndTapWebsite() {
        list.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_BYTHEBAY_WEBSITE)))
    }

    // Test expanding ByTheBay and tapping map
    @Throws(Exception::class)
    fun open0AndTapMap() {
        list.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        // click on website icon
        visibleMapIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_BYTHEBAY_MAP)))
    }

    // Tap BoltAbout, scroll up to show contact icons, taps phone
    @Throws(Exception::class)
    fun open2AndTapPhone() {
        // item 2 and click to expand
        list.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        // click on phone icon
        visiblePhoneIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_DIAL),
                hasData(INTENT_DATA_BOLTABOUT_PHONE)))
    }

    // Test expanding BoltAbout and tapping website icon, test intent
    @Throws(Exception::class)
    fun open2AndTapWebsite() {
        list.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        list.perform(swipeUp())
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_BOLTABOUT_WEBSITE)))
    }

    // Test expanding Boltabout and tapping map icon, test intent
    @Throws(Exception::class)
    fun open2AndTapMap() {
        list.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        list.perform(swipeUp())
        // click on website icon
        visibleMapIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_BOLTABOUT_MAP)))
    }

    companion object {

        // to test dialing intent
        private val BYTHEBAY_PHONE_NUMBER = "805-772-5563"
        private val INTENT_DATA_BYTHEBAY_PHONE = Uri.parse("tel:$BYTHEBAY_PHONE_NUMBER")
        private val BOLTABOUT_PHONE_NUMBER = "805-858-9702"
        private val INTENT_DATA_BOLTABOUT_PHONE = Uri.parse("tel:$BOLTABOUT_PHONE_NUMBER")
        //private static String PACKAGE_ANDROID_DIALER = "com.android.server.telecom";

        // to test website intent
        private val INTENT_DATA_BYTHEBAY_WEBSITE = "https://www.bythebaygallery.com/"
        private val INTENT_DATA_BOLTABOUT_WEBSITE = "https://boltabout.com/"

        // to test maps intent
        private val INTENT_DATA_BYTHEBAY_MAP = "geo:0,0?q=By+The+Bay+Gallery+Morro+Bay+CA"
        private val INTENT_DATA_BOLTABOUT_MAP = "geo:0,0?q=880+Price+St+Pismo+Beach+California+93449"
    }

}
