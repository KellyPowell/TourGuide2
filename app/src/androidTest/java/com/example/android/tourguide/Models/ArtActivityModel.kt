package com.example.android.tourguide.Models

import android.content.Intent
import android.net.Uri
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItem
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import android.support.test.espresso.intent.matcher.IntentMatchers.hasData
import android.support.test.espresso.matcher.ViewMatchers.*
import android.view.View
import com.example.android.tourguide.DestinationAdapter1
import com.example.android.tourguide.R
import org.hamcrest.core.AllOf.allOf

class ArtActivityModel {

    private val visiblePhoneIcon = onView(allOf<View>(withId(R.id.phone_icon), isDisplayed()))
    private val visibleWebsiteIcon = onView(allOf<View>(withId(R.id.website_icon), isDisplayed()))
    private val visibleMapIcon = onView(allOf<View>(withId(R.id.map_icon), isDisplayed()))
    //private val kellyArt = (allOf<View>(withText("Kelly Art Glass"), isDisplayed()))
    private val kellyArt = withChild(withChild(withText("Kelly Powell Glass")))
    private val kateArt = withChild(withChild(withText("Kate Payne Glass")))
    private val elevatorArt = withChild(withChild(withText("Elevator Glass")))
    private val bayArt = withChild(withChild(withText("By the Bay Gallery")))
    //private val kellyArt = onView(withText("Kelly")).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
    //private val kateArt = onData(anything()).inAdapterView(withId(R.id.list)).atPosition(2)
    //private val elevatorArt = onData(anything()).inAdapterView(withId(R.id.list)).atPosition(3)
    //private val kellyArt = onView(allOf(withText("Kelly Powell Glass"), isDescendantOfA(withId(R.id.recycler_view))))
    private val list = onView(withId(R.id.recycler_view))

    // Test expanding Kelly Art and dialing phone
    @Throws(Exception::class)
    fun openKellyAndTapPhone() {
        // item 0 and click to expand
        list.perform(actionOnItem<DestinationAdapter1.DestinationViewHolder>(kellyArt, click()))
        // click on phone icon
        visiblePhoneIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_DIAL),
                hasData(INTENT_DATA_KELLY_PHONE)))
    }


    // Test expanding Kelly Art and tapping website
    @Throws(Exception::class)
    fun openKellyAndTapWebsite() {
        list.perform(actionOnItem<DestinationAdapter1.DestinationViewHolder>(kellyArt, click()))
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_KELLY_WEBSITE)))
    }

    // Test expanding Kelly Art and tapping map
    @Throws(Exception::class)
    fun openKellyAndTapMap() {
        list.perform(actionOnItem<DestinationAdapter1.DestinationViewHolder>(kellyArt, click()))
        // click on map icon
        visibleMapIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_KELLYART_MAP)))
    }

    // Test expanding By the Bay and dialing phone
    @Throws(Exception::class)
    fun openBayAndTapPhone() {
        // item 0 and click to expand
        list.perform(actionOnItem<DestinationAdapter1.DestinationViewHolder>(bayArt, click()))
        // click on phone icon
        visiblePhoneIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_DIAL),
                hasData(INTENT_DATA_BAY_PHONE)))
    }


    // Test expanding By the Bay and tapping website
    @Throws(Exception::class)
    fun openBayAndTapWebsite() {
        list.perform(actionOnItem<DestinationAdapter1.DestinationViewHolder>(bayArt, click()))
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_BAY_WEBSITE)))
    }

    // Test expanding By the Bay Gallery and tapping map
    @Throws(Exception::class)
    fun openBayAndTapMap() {
        list.perform(actionOnItem<DestinationAdapter1.DestinationViewHolder>(bayArt, click()))
        // click on map icon
        visibleMapIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_BAY_MAP)))
    }

    // Test expanding Kate and dialing phone
    @Throws(Exception::class)
    fun openKateAndTapPhone() {
        // item 0 and click to expand
        list.perform(actionOnItem<DestinationAdapter1.DestinationViewHolder>(kateArt, click()))
        // click on phone icon
        visiblePhoneIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_DIAL),
                hasData(INTENT_DATA_KATE_PHONE)))
    }


    // Test expanding Kate and tapping website
    @Throws(Exception::class)
    fun openKateAndTapWebsite() {
        list.perform(actionOnItem<DestinationAdapter1.DestinationViewHolder>(kateArt, click()))
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_KATE_WEBSITE)))
    }

    // Test expanding Kate Gallery and tapping map
    @Throws(Exception::class)
    fun openKateAndTapMap() {
        list.perform(actionOnItem<DestinationAdapter1.DestinationViewHolder>(kateArt, click()))
        // click on map icon
        visibleMapIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_KATE_MAP)))
    }


    // Test expanding Elevator Art and tapping website
    @Throws(Exception::class)
    fun openElevatorAndTapWebsite() {
        list.perform(actionOnItem<DestinationAdapter1.DestinationViewHolder>(elevatorArt, click()))
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_ELEVATOR_WEBSITE)))
    }

    companion object {

        // to test dialing intent
        private val KELLY_PHONE_NUMBER = "715-379-1248"
        private val INTENT_DATA_KELLY_PHONE = Uri.parse("tel:$KELLY_PHONE_NUMBER")
        private val KATE_PHONE_NUMBER = "805-305-0505"
        private val INTENT_DATA_KATE_PHONE = Uri.parse("tel:$KATE_PHONE_NUMBER")
        private val BAY_PHONE_NUMBER = "805-772-5563"
        private val INTENT_DATA_BAY_PHONE = Uri.parse("tel:$BAY_PHONE_NUMBER")
        //private static String PACKAGE_ANDROID_DIALER = "com.android.server.telecom";

        // to test website intent
        private val INTENT_DATA_KELLY_WEBSITE = "https://www.instagram.com/glassbykelly/"
        private val INTENT_DATA_KATE_WEBSITE = "https://www.instagram.com/payne_inthe_glass/"
        private val INTENT_DATA_ELEVATOR_WEBSITE = "https://www.etsy.com/shop/Elevatorglass/"
        private val INTENT_DATA_BAY_WEBSITE = "https://www.bythebaygallery.com/"

        // to test maps intent
        private val INTENT_DATA_KELLYART_MAP = "geo:0,0?q=521+Buena+Fortuna+Circle+Atascadero+CA"
        private val INTENT_DATA_KATE_MAP = "geo:0,0?q=294+Spruce+St+Arroyo+Grande"
        private val INTENT_DATA_BAY_MAP = "geo:0,0?q=895+Embarcadero+Morro+Bay+CA+93442"
    }

}
