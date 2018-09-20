package com.example.android.tourguide.Models

import android.content.Intent
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.*
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.android.tourguide.DestinationAdapter1
import com.example.android.tourguide.R
import org.hamcrest.Matchers.anything
import org.hamcrest.core.AllOf.allOf

class OutdoorsActivityModel {

    private val visiblePhoneIcon = onView(allOf<View>(withId(R.id.phone_icon), isDisplayed()))
    private val visibleWebsiteIcon = onView(allOf<View>(withId(R.id.website_icon), isDisplayed()))
    private val visibleMapIcon = onView(allOf<View>(withId(R.id.map_icon), isDisplayed()))

    private val moonstoneBeach = ViewMatchers.withChild(ViewMatchers.withChild(ViewMatchers.withText("Moonstone Beach")))
    private val osoFlaco = ViewMatchers.withChild(ViewMatchers.withChild(ViewMatchers.withText("Oso Flaco Lake Trail")))
    private val morroRock = ViewMatchers.withChild(ViewMatchers.withChild(ViewMatchers.withText("Morro Rock")))
    private val list = onView(withId(R.id.recycler_view))


    // Test expanding MoonstoneBeach and tapping website
    @Throws(Exception::class)
    fun openMoonstoneAndTapWebsite() {

        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(moonstoneBeach, click()))
        list.perform(swipeUp())
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_MOONSTONE_WEBSITE)))
    }

    // Test expanding MoonstoneBeach and tapping map
    @Throws(Exception::class)
    fun openMoonstoneAndTapMap() {

        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(moonstoneBeach, click()))
        list.perform(swipeUp())
        // click on website icon
        visibleMapIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_MOONSTONE_MAP)))
    }

    // Test expanding Oso Flaco and tapping website
    @Throws(Exception::class)
    fun openOsoAndTapWebsite() {

        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(osoFlaco, click()))
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_OSO_FLACO_WEBSITE)))
    }

    // Test expanding Oso Flaco and tapping map
    @Throws(Exception::class)
    fun openOsoAndTapMap() {

        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(osoFlaco, click()))
        // click on website icon
        visibleMapIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_OSO_FLACO_MAP)))
    }

    // Test expanding Oso Flaco and tapping website
    @Throws(Exception::class)
    fun openMorroRockAndTapWebsite() {

        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(morroRock, click()))
        list.perform(swipeUp())
        // click on website icon
        visibleWebsiteIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_MORRO_ROCK_WEBSITE)))
    }

    // Test expanding Oso Flaco and tapping map
    @Throws(Exception::class)
    fun openMorroROckAndTapMap() {

        list.perform(RecyclerViewActions.actionOnItem<DestinationAdapter1.DestinationViewHolder>(morroRock, click()))
        list.perform(swipeUp())
        // click on website icon
        visibleMapIcon.perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(INTENT_DATA_MORRO_ROCK_MAP)))
    }



    companion object {


        // to test website intent
        private val INTENT_DATA_MOONSTONE_WEBSITE = "https://visitcambriaca.com/itinerary-element/moonstone-beach-2/"
        private val INTENT_DATA_OSO_FLACO_WEBSITE = "https://www.alltrails.com/trail/us/california/oso-flaco-lake-trail"
        private val INTENT_DATA_MORRO_ROCK_WEBSITE = "https://www.morro-bay.ca.us/383/Morro-Rock-Beach"
        //to test maps intent
        private val INTENT_DATA_MOONSTONE_MAP = "geo:0,0?q=Moonstone+Beach+Cambria+CA+93428"
        private val INTENT_DATA_OSO_FLACO_MAP = "geo:0,0?q=Oso+Flaco+Lake+Rd+Nipomo+CA+93420"
        private val INTENT_DATA_MORRO_ROCK_MAP = "geo:0,0?q=1300+Embarcadero+Morro+Bay+CA+93442"
    }

}
