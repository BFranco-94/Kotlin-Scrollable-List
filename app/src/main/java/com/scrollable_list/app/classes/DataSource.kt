package com.scrollable_list.app.classes

import com.scrollable_list.app.R

/** this class creates a list of card images using the CardImage data class */
class DataSource {

    /** this function returns a list of card images
     * @return List<CardImage>
    **/
    fun loadInformation(): List<CardImage> {
        return listOf(
            CardImage(R.string.card_text1, R.drawable.img),
            CardImage(R.string.card_text2, R.drawable.img_1),
            CardImage(R.string.card_text3, R.drawable.img_2)
        )
    }
}