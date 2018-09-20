package com.example.android.tourguide

import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class DestinationAdapter1(val destinationList: ArrayList<Destination>, private val colorResourceId: Int): Adapter<DestinationAdapter1.DestinationViewHolder>() {
    private val expandedList= BooleanArray(destinationList.size)
    override fun getItemViewType(position: Int) = R.layout.list_item


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return DestinationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return destinationList.size
    }

    override fun onBindViewHolder(p0: DestinationViewHolder, position: Int) {
        // set a click listener on the overall view
        p0.bind(position)

        // Set the theme color for the list item


    }


    inner class DestinationViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

        private var lastKnownPosition = 0
        override fun onClick(v: View?) {
            expandedList[lastKnownPosition] = !expandedList[lastKnownPosition]
            if (expandedList[lastKnownPosition]) {
                itemView.findViewById<View>(R.id.description_container).visibility = View.VISIBLE
                itemView.findViewById<View>(R.id.collapse_arrow).visibility = View.VISIBLE
                itemView.findViewById<View>(R.id.expand_arrow).visibility = View.GONE

            } else {
                itemView.findViewById<View>(R.id.description_container).visibility = View.GONE
                itemView.findViewById<View>(R.id.collapse_arrow).visibility = View.GONE
                itemView.findViewById<View>(R.id.expand_arrow).visibility = View.VISIBLE

            }
        }

        init {
            view.setOnClickListener(this)
            val textContainer = view.findViewById<View>(R.id.text_container)
            // Find the color that the resource ID maps to
            val color = ContextCompat.getColor(view.context, colorResourceId)
            // set the background color of the text container View
            textContainer?.setBackgroundColor(color)


            // Set the theme color for the description container
            val descriptionContainer = view.findViewById<View>(R.id.description_container)
            descriptionContainer?.setBackgroundColor(color)
        }

        fun bind(position: Int) {
            lastKnownPosition = position
            if (expandedList[lastKnownPosition]) {
                itemView.findViewById<View>(R.id.description_container).visibility = View.VISIBLE
                itemView.findViewById<View>(R.id.collapse_arrow).visibility = View.VISIBLE
                itemView.findViewById<View>(R.id.expand_arrow).visibility = View.GONE

            } else {
                itemView.findViewById<View>(R.id.description_container).visibility = View.GONE
                itemView.findViewById<View>(R.id.collapse_arrow).visibility = View.GONE
                itemView.findViewById<View>(R.id.expand_arrow).visibility = View.VISIBLE

            }

            val listItemView = itemView



            // Get the Destination object located at this position in the list
            val currentDestination = destinationList.get(position)


            // Find the TextView in the list_item.xml layout with the ID name_text_view
            val nameTextView = listItemView.findViewById<TextView>(R.id.name_text_view)
            // Set this text on the name TextView
            nameTextView.text = currentDestination.destinationName

            // Find the TextView in the list_item.xml layout with the city text view
            val cityTextView = listItemView.findViewById<TextView>(R.id.city_text_view)
            // set this text on the city TextView
            cityTextView.text = currentDestination.city


            // Find the ImageView in the list_item.xml layout with the ID image
            val imageView = listItemView.findViewById<ImageView>(R.id.image)
            // Set this image on the ImageView
            imageView.setImageResource(currentDestination.imageResourceId)

            val descriptionTextView = listItemView.findViewById<TextView>(R.id.description_text_view)
            descriptionTextView.text = currentDestination.destinationDescription

            if (currentDestination.hasPhone) {
                // Find the ImageView in the list_item.xml layout with the ID phone_icon
                val phoneIcon = listItemView.findViewById<ImageView>(R.id.phone_icon)

                // Set this image on the ImageView
                phoneIcon.setImageResource(R.drawable.baseline_phone_white_24dp)

                //set a click listener to dial the phone number
                phoneIcon.setOnClickListener(object : View.OnClickListener {
                    var phoneNumber = currentDestination.destinationPhone

                    override fun onClick(view: View) {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                        view.context.startActivity(intent)
                    }
                })

            }


            if (currentDestination.hasWebsite) {
                // Find the ImageView in the list_item.xml layout with the ID email_icon
                val websiteIcon = listItemView.findViewById<ImageView>(R.id.website_icon)

                // Set this image on the ImageView
                websiteIcon.setImageResource(R.drawable.baseline_launch_white_24dp)

                //set a click listener to dial the phone number
                websiteIcon.setOnClickListener(object : View.OnClickListener {
                    var url = currentDestination.destinationWebsite

                    override fun onClick(view: View) {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        view.context.startActivity(intent)
                    }
                })
            }


            if (currentDestination.hasAddress) {
                // Find the ImageView in the list_item.xml layout with the ID map_icon
                val mapIcon = listItemView.findViewById<ImageView>(R.id.map_icon)

                // Set this image on the ImageView
                mapIcon.setImageResource(R.drawable.baseline_map_white_24dp)

                //set a click listener to dial the phone number
                mapIcon.setOnClickListener(object : View.OnClickListener {
                    var address = currentDestination.destinationAddress

                    override fun onClick(view: View) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:" + address))
                        intent.data = Uri.parse(address)
                        view.context.startActivity(intent)
                    }
                })
            }


        }

    }
}

