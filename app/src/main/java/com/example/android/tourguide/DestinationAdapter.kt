package com.example.android.tourguide

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import org.w3c.dom.Text

import java.util.ArrayList

// This is a custom adapter class that can provide the layout for each list item based
// on a data source, which is a list of Destination objects

class DestinationAdapter
// Create a new Destination object
// @param context is the current context (i.e. Activity) that the adapter is being created in
// @param destinationList is the list of Destinations to be displayed
// @param colorResourceId is the resource ID for the background color for this list of word

(context: Activity, destinationList: ArrayList<Destination>, // Resource ID for the background color for this list of words
 private val colorResourceId: Int) : ArrayAdapter<Destination>(context, 0, destinationList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // check if existing view is being reused, otherwise inflate the view
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                    R.layout.list_item, parent, false)
        }

        // set a click listener on the overall view
        listItemView!!.setOnClickListener(object : View.OnClickListener {
            // boolean to determine whether a list item has already been expanded
            private var isExpanded = false

            override fun onClick(v: View) {
                if (!isExpanded) {
                    v.findViewById<View>(R.id.description_container).visibility = View.VISIBLE
                    v.findViewById<View>(R.id.collapse_arrow).visibility = View.VISIBLE
                    v.findViewById<View>(R.id.expand_arrow).visibility = View.GONE
                    isExpanded = true
                } else {
                    v.findViewById<View>(R.id.description_container).visibility = View.GONE
                    v.findViewById<View>(R.id.collapse_arrow).visibility = View.GONE
                    v.findViewById<View>(R.id.expand_arrow).visibility = View.VISIBLE
                    isExpanded = false
                }
            }
        })

        // Get the Destination object located at this position in the list
        val currentDestination = getItem(position)


        // Find the TextView in the list_item.xml layout with the ID name_text_view
        val nameTextView = listItemView.findViewById<View>(R.id.name_text_view) as TextView
        // Set this text on the name TextView
        nameTextView.text = currentDestination!!.destinationName

        // Find the TextView in the list_item.xml layout with the city text view
        val cityTextView = listItemView.findViewById<View>(R.id.city_text_view) as TextView
        // set this text on the city TextView
        cityTextView.text = currentDestination.city


        // Find the ImageView in the list_item.xml layout with the ID image
        val imageView = listItemView.findViewById<View>(R.id.image) as ImageView
        // Set this image on the ImageView
        imageView.setImageResource(currentDestination.imageResourceId)

        val descriptionTextView = listItemView.findViewById<View>(R.id.description_text_view) as TextView
        descriptionTextView.text = currentDestination.destinationDescription

        if (currentDestination.hasPhone) {
            // Find the ImageView in the list_item.xml layout with the ID phone_icon
            val phoneIcon = listItemView.findViewById<View>(R.id.phone_icon) as ImageView

            // Set this image on the ImageView
            phoneIcon.setImageResource(R.drawable.baseline_phone_white_24dp)

            //set a click listener to dial the phone number
            phoneIcon.setOnClickListener(object : View.OnClickListener {
                internal var phoneNumber = currentDestination.destinationPhone

                override fun onClick(view: View) {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                    context.startActivity(intent)
                }
            })

        }


        if (currentDestination.hasWebsite) {
            // Find the ImageView in the list_item.xml layout with the ID email_icon
            val websiteIcon = listItemView.findViewById(R.id.website_icon) as ImageView

            // Set this image on the ImageView
            websiteIcon.setImageResource(R.drawable.baseline_launch_white_24dp)

            //set a click listener to dial the phone number
            websiteIcon.setOnClickListener(object : View.OnClickListener {
                internal var url = currentDestination.destinationWebsite

                override fun onClick(view: View) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    context.startActivity(intent)
                }
            })
        }


        if (currentDestination.hasAddress) {
            // Find the ImageView in the list_item.xml layout with the ID map_icon
            val mapIcon = listItemView.findViewById<View>(R.id.map_icon) as ImageView

            // Set this image on the ImageView
            mapIcon.setImageResource(R.drawable.baseline_map_white_24dp)

            //set a click listener to dial the phone number
            mapIcon.setOnClickListener(object : View.OnClickListener {
                internal var address = currentDestination.destinationAddress

                override fun onClick(view: View) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:" + address!!))
                    intent.data = Uri.parse(address)
                    context.startActivity(intent)
                }
            })
        }


        // Set the theme color for the list item
        val textContainer = listItemView.findViewById<View>(R.id.text_container)
        // Find the color that the resource ID maps to
        val color = ContextCompat.getColor(context, colorResourceId)
        // set the background color of the text container View
        textContainer.setBackgroundColor(color)


        // Set the theme color for the description container
        val descriptionContainer = listItemView.findViewById<View>(R.id.description_container)
        descriptionContainer.setBackgroundColor(color)


        // Return the whole list item layout so it can be shown in the ListView
        return listItemView

    }
}
