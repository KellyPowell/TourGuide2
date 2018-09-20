package com.example.android.tourguide

class Destination {

    // name of our tourist destination
    val destinationName: String

    // public string city/area name (i.e. Los Osos)
    // getter methods
    val city: String

    // address of our tourist destination
    var destinationAddress: String? = null
        private set

    // image/icon resource id of our tourist destination
    var imageResourceId: Int

    // website address
    var destinationWebsite: String? = null
        private set

    // phone number
    var destinationPhone: String? = null

    // description of the destination
    var destinationDescription: String

    // boolean, whether this destination has phone
    var hasPhone: Boolean

    // boolean, whether this destination has website
    var hasWebsite: Boolean

    // boolean, whether destination has address
    var hasAddress: Boolean

    // constructor for name, city, description, imageResourceId
    constructor(destinationName: String, city: String, destinationDescription: String,
                imageResourceId: Int) {
        this.destinationName = destinationName
        this.city = city
        this.destinationDescription = destinationDescription
        this.imageResourceId = imageResourceId
        this.hasAddress = false
        this.hasWebsite = false
        this.hasPhone = false
    }

    // constructor for name, city, description, imageResourceId, website
    constructor(destinationName: String, city: String, destinationDescription: String,
                imageResourceId: Int, destinationWebsite: String) {
        this.destinationName = destinationName
        this.city = city
        this.destinationDescription = destinationDescription
        this.imageResourceId = imageResourceId
        this.destinationWebsite = destinationWebsite
        hasWebsite = true
        hasAddress = false
        hasPhone = false
    }


    // constructor for name, city, description, address, imageResourceId, website
    constructor(destinationName: String, city: String, destinationDescription: String,
                destinationAddress: String, imageResourceId: Int, destinationWebsite: String) {
        this.destinationName = destinationName
        this.city = city
        this.destinationDescription = destinationDescription
        this.destinationAddress = destinationAddress
        this.imageResourceId = imageResourceId
        this.destinationWebsite = destinationWebsite
        hasWebsite = true
        hasPhone = false
        hasAddress = true
    }


    // constructor for name, city, description, address, imageResourceId, website, phone number
    constructor(destinationName: String, city: String, destinationDescription: String, destinationAddress: String, imageResourceId: Int, destinationWebsite: String, destinationPhone: String) {
        this.destinationName = destinationName
        this.city = city
        this.destinationDescription = destinationDescription
        this.destinationAddress = destinationAddress
        this.imageResourceId = imageResourceId
        this.destinationWebsite = destinationWebsite
        this.destinationPhone = destinationPhone
        hasPhone = true
        hasWebsite = true
        hasAddress = true
    }
}
