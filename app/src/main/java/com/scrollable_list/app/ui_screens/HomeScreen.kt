package com.scrollable_list.app.ui_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.scrollable_list.app.classes.CardImage
import com.scrollable_list.app.classes.DataSource




/**
 * Displays the main card application UI.
 * It sets up a full-screen surface with padding for status bars and safe insets, then displays a list of cards.
 *
 * @param navController The navigation controller used for managing navigation actions.
 */
@Composable
fun CardApp(navController: NavController) {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(layoutDirection),
            )
    ) {
        CardList(
            navController,
            modifier = Modifier,
            cardList = DataSource().loadInformation()
        )
    }
}

/**
 * Displays a list of cards using a lazy column.
 * Each card is created using the `CardImageCreator` function.
 *
 * @param navController The navigation controller used for managing navigation actions.
 * @param modifier Modifier for applying customizations to the LazyColumn.
 * @param cardList A list of `CardImage` objects containing the data to display in each card.
 */
@Composable
fun CardList(navController: NavController, modifier: Modifier, cardList: List<CardImage>) {
    LazyColumn(modifier = modifier) {
        items(cardList) { cardImage ->
            CardImageCreator(navController, modifier, cardImage)
        }
    }
}

/**
 * Creates an individual card UI component.
 * The card contains an image and a text description, styled and laid out within a column.
 *
 * @param navController The navigation controller used for managing navigation actions.
 * @param modifier Modifier for applying customizations to the card.
 * @param cardImage A `CardImage` object containing the resource IDs for the image and text to display.
 */
@Composable
fun CardImageCreator(
    navController: NavController,
    modifier: Modifier,
    cardImage: CardImage
) {
    Card(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(cardImage.imageResourceId),
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(295.dp)
                    .padding(start = 16.dp, end = 16.dp, top = 30.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = LocalContext.current.getString(cardImage.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}



