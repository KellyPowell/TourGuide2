package com.example.android.tourguide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

class DiningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_list)

        // create a list of Desinations
        val destinations = ArrayList<Destination>()

        destinations.add(Destination("El Tapatio", "Guadalupe",
                "The best Mexican food I've ever had, period. No kidding. Hole " + "in the wall family place in a sleepy little town. Trust me, it's worth the drive!",
                "geo:0,0?q=El+Tapatio+Guadalupe+CA", R.drawable.et,
                "https://www.yelp.com/biz/el-tapatio-guadalupe",
                "805-343-2850"))
        destinations.add(Destination("Taco Temple", "Morro Bay",
                "Amazing fresh seafood, Mexican meals, and desserts.",
                "geo:0,0?q=Taco+Temple+Morro+Bay+CA", R.drawable.tt,
                "http://tacotemple.com", "805-772-4965"))
        destinations.add(Destination("Wow Yanagi Sushi", "Pismo Beach",
                "My favorite sushi spot on the Central Coast. Always fresh and " + "delicious, with great service.",
                "geo:0,0?q=Wow+Yanagi+Sushi+Pismo+Beach+CA", R.drawable.sushi,
                "http://www.yanagisushigrill.com/", "805-489-6358"))
        destinations.add(Destination("High Street Deli", "San Luis Obispo",
                "They're busy for a reason. My favorite sandwich is the Heisenburger. " + "Do yourself a favor and get one!",
                "geo:0,0?q=High+Street+Deli+San+Luis+Obispo+CA",
                R.drawable.highst, "https://www.highstdeli.com/",
                "805-541-4738"))
        destinations.add(Destination("Pier 46 Seafood", "Templeton",
                "Best fish and chips in the county.",
                "geo:0,0?q=1131+Rossi+Rd+Templeton+CA+93465", R.drawable.pier46,
                "http://www.pier46seafood.com/", "805-434-1950"))
        destinations.add(Destination("Marston's 101", "Atascadero",
                "Wood fired pizzas, burgers, comfort food.",
                "geo:0,0?q=9006+West+Front+Road+CA+93422", R.drawable.marstons,
                "https://www.marstons101atascadero.com/", "805-434-1950"))
        destinations.add(Destination("Giuseppe's", "Pismo Beach",
                "Fantastic pizza and Italian food.",
                "geo:0,0?q=891+Price+Street+Pismo Beach+CA+93449", R.drawable.giu,
                "http://giusepperustica.wixsite.com/pismogiuseppes", "805-773-2870"))


        // Create an DestinationAdapater, whose data source is a list of Destinations. The
        // adapter knows how to create list items for each item in the list.
        val adapter = DestinationAdapter1(destinations, R.color.DiningColor)

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