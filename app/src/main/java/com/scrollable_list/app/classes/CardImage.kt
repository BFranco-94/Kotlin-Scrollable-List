package com.scrollable_list.app.classes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * A data class to represent the information presented in the card
 * @param stringResourceId : receives a @StringRes resource (i.e. -> R.string.card_text1)
 * @param imageResourceId  : receives a @DrawableRes resource (i.e. -> R.drawable.img)
 */
data class CardImage(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)