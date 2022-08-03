package com.xtremedevx.pirateslist.data

import androidx.compose.ui.res.painterResource
import com.xtremedevx.pirateslist.R

object PirateList {
    val piratesList = listOf<Pirate>(
        Pirate(
            name = "Monkey D. Luffy", bounty = "$1,500,000,000", imageId = R.drawable.luffy
        ),Pirate(
            name = "Roronoa Zoro", bounty = "$320,000,000", imageId = R.drawable.zoro
        ),Pirate(
            name = "Nami", bounty = "$66,000,000", imageId = R.drawable.nami
        ),Pirate(
            name = "Sogeking", bounty = "$200,000,000", imageId = R.drawable.sogeking
        ),Pirate(
            name = "Black Leg", bounty = "$330,000,000", imageId = R.drawable.sanji
        ),Pirate(
            name = "Tony Tony Chopper", bounty = "$100", imageId = R.drawable.chopper
        ),Pirate(
            name = "Nico Robin", bounty = "$130,000,000", imageId = R.drawable.robin
        ),Pirate(
            name = "Franky", bounty = "$94,000,000", imageId = R.drawable.franky
        ),Pirate(
            name = "Brook", bounty = "$83,000,000", imageId = R.drawable.brook
        ),Pirate(
            name = "Jinbe", bounty = "$438,000,000", imageId = R.drawable.jinbe
        )

    )
}