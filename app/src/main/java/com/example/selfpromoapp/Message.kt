package com.example.selfpromoapp

import java.io.Serializable

data class Message(
    var contactName: String,
    var displayName: String,
    var availableFrom: String,
    var includeJunior: Boolean,
    var immediateStart: Boolean,
    var spinnerList: String?
) : Serializable {

    var j: String? = null
    var s: String? = null
    override fun toString(): String {
        j = if (includeJunior)
            " Junior"
        else
            ""
        s = if (immediateStart)
            " immediately"
        else
            ""

        return "Hi $contactName.\n\nMy name is $displayName and I am a$j $spinnerList.\n\nI have a portfolio of apps to demonstrate my technical skills that i can show on request.\n\nI am able to start$s a new position from $availableFrom.\n\nPlease get in touch if you have any suitable roles for me.\n\nThanks and best regards"
    }
}