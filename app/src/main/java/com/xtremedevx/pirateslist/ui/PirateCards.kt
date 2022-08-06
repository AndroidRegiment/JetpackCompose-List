package com.xtremedevx.pirateslist.ui

import android.widget.GridLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.contentValuesOf
import com.xtremedevx.pirateslist.R
import com.xtremedevx.pirateslist.data.Pirate
import com.xtremedevx.pirateslist.ui.theme.OffWhite


@Composable
fun PirateCard(pirate: Pirate) {
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }
    Spacer(modifier = Modifier.height(10.dp))
    Card(elevation = if (isExpanded) 10.dp else 0.dp, shape = RoundedCornerShape(10.dp)) {
        Column(
            Modifier
//            .border(width = if(isExpanded) 10.dp else 0.dp, color = OffWhite, shape = RoundedCornerShape(10.dp))
                .clickable { isExpanded = !isExpanded },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .size(if (isExpanded) 300.dp else 250.dp)
                    .clip(RoundedCornerShape(10.dp)),

                painter = painterResource(id = pirate.imageId),
                contentDescription = "${pirate.name}'s image",
                contentScale = ContentScale.Crop
            )
            if (isExpanded) {
                Text(text = pirate.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = pirate.bounty)
                Spacer(modifier = Modifier.height(10.dp))

            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}


@Composable
fun ShowPiratesList(pirateList: List<Pirate>) {



    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
        content = {
            items(pirateList){
            pirate ->
            PirateCard(pirate = pirate)
            }

        }
    )


}

@Composable
fun ShowPiratesInGrid(pirateList: List<Pirate>){
    var listState by remember {
        mutableStateOf(pirateList)
    }
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ){
        items(pirateList){
                pirate ->
            PirateCard(pirate = pirate)
        }
    }
}