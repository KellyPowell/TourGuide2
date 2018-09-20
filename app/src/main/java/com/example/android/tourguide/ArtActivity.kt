package com.example.android.tourguide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

class ArtActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_list)

        // create a list of Desinations
        val destinations = ArrayList<Destination>()

        destinations.add(Destination("Kelly Powell Glass", "Atascadero",
                "Kelly makes glass marbles. They're getting better.",
                "geo:0,0?q=521+Buena+Fortuna+Circle+Atascadero+CA", R.drawable.greensmall,
                "https://www.instagram.com/glassbykelly/", "715-379-1248"))
        destinations.add(Destination("By the Bay Gallery", "Morro Bay",
                "For over three decades, they continue to offer the best selection" +
                        " of high quality, American-made crafts and fine jewelry anywhere on the " +
                        "Central Coast. Whether it's art glass, custom jewelry, wood, ceramics or " +
                        "enamel sculpture, they sell unique, fine quality crafts and provide " +
                        "exceptional personal service.",
                "geo:0,0?q=895+Embarcadero+Morro+Bay+CA+93442", R.drawable.btb,
                "https://www.bythebaygallery.com/", "805-772-5563"))
        destinations.add(Destination("Kate Payne Glass", "Arroyo Grande",
                "Kate is an all-around bad motherfucker, and a natural at " + "sculpting glass in the flame. Can't wait to see what she makes next!",
                "geo:0,0?q=294+Spruce+St+Arroyo+Grande", R.drawable.kate, "https://www.instagram.com/payne_inthe_glass/",
                "805-305-0505"))
        destinations.add(Destination("Elevator Glass", "Pismo Beach",
                "OOhhh....that's how you fume. Damn, son.", R.drawable.brebes,
                "https://www.etsy.com/shop/Elevatorglass"))

        // Create an DestinationAdapater, whose data source is a list of Destinations. The
        // adapter knows how to create list items for each item in the list.
        val adapter = DestinationAdapter1(destinations, R.color.ArtColor)

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
