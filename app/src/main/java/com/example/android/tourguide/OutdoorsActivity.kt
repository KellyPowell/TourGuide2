package com.example.android.tourguide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

class OutdoorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_list)

        // create a list of Desinations
        val destinations = ArrayList<Destination>()

        destinations.add(Destination("Montana de Oro", "Los Osos",
                "A real gem of the Central Coast. Be sure to check out Spooner's " + "Cove, the Bluff Trail, and the tidal pools.",
                "geo:0,0?q=Montana+de+Oro+Park+Los+Osos+CA", R.drawable.mdo,
                "http://www.parks.ca.gov/?page_id=592"))
        destinations.add(Destination("Oso Flaco Lake Trail", "Nipomo",
                "Very easy beautiful trail. The trail turns into a boardwalk that" +
                        " crosses the lake, always teeming with birds. Continue down the trail all " +
                        "the way to the ocean.",
                "geo:0,0?q=Oso+Flaco+Lake+Rd+Nipomo+CA+93420", R.drawable.oso,
                "https://www.alltrails.com/trail/us/california/oso-flaco-lake-trail"))
        destinations.add(Destination("Morro Rock", "Morro Bay",
                "An idyllic backdrop for Morro Bay, Morro Rock is a 576' tall " +
                        "extinct volcanic peak. This landmark stands at the mouth of the harbor and " +
                        "is home to nesting Peregrine Falcons. ",
                "geo:0,0?q=1300+Embarcadero+Morro+Bay+CA+93442", R.drawable.morro_rock,
                "https://www.morro-bay.ca.us/383/Morro-Rock-Beach"))
        destinations.add(Destination("Elephant Seal Rookery", "San Simeon",
                "This popular spot to observe elephant seals has a boardwalk & " + "viewing areas. The peak season is December to March.",
                "geo:0,0?q=Elephant+Seal+Vista+Point+San+Simeon+CA", R.drawable.seal,
                "http://www.elephantseal.org/"))
        destinations.add(Destination("Monarch Butterfly Grove", "Pismo Beach",
                "Eucalyptus grove with thousands of monarch butteries " + "in late October through February.",
                "geo:0,0?q=Monarch+Butterfly+Grove+Pismo+Beach+CA+93449", R.drawable.monarch,
                "http://www.monarchbutterfly.org/"))
        destinations.add(Destination("Sub Sea Tours", "Morro Bay",
                "Whale watching and harbor tours. Peak months for seeing humpback " + "whales are May through July.",
                "geo:0,0?q=699+Embarcadero+Morro+Bay+CA+93442", R.drawable.humpback,
                "http://www.subseatours.com", "805-772-9463"))
        destinations.add(Destination("Moonstone Beach", "Cambria",
                "Spend an hour or two, or three combing through all the little " +
                        "rocks on the beach. Beautiful scenery and the warm rocks feel great under " +
                        "your feet.",
                "geo:0,0?q=Moonstone+Beach+Cambria+CA+93428", R.drawable.moonstone,
                "https://visitcambriaca.com/itinerary-element/moonstone-beach-2/"))


        // Create an DestinationAdapater, whose data source is a list of Destinations. The
        // adapter knows how to create list items for each item in the list.
        val adapter = DestinationAdapter1(destinations, R.color.OutdoorsColor)

        // Find the ListView object in the view hierarchy of the Activity.
        // There should be a ListView with the view ID called list, which is declared in the
        // word_list.xml layout file.
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Make the ListView use the DestinationAdapter we created above, so that the
        // ListView will display list items for each Destination in the list.
        recyclerView.adapter = adapter
    }

}