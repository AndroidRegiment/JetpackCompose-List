package com.xtremedevx.pirateslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.xtremedevx.pirateslist.data.Pirate
import com.xtremedevx.pirateslist.data.PirateList
import com.xtremedevx.pirateslist.data.PirateList.piratesListSnapshot
import com.xtremedevx.pirateslist.data.pirateList
import com.xtremedevx.pirateslist.ui.ShowPiratesInGrid
import com.xtremedevx.pirateslist.ui.theme.PiratesListTheme

import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiratesListTheme {
                Content()
            }
        }
    }

}

@Composable
fun Content(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        var index by remember {
            mutableStateOf(0)
        }

        ShowPiratesInGrid(pirateList = piratesListSnapshot)
        Button(
            onClick = {
                piratesListSnapshot.add(pirateList[index]).also {
                    index++
                }
            },
            enabled = index <= pirateList.lastIndex,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(
                    50.dp
                )
                .offset(x = (-10).dp, y = (-10).dp),


            ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
            )
        }
        Button(
            onClick = {
            },
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .size(
                    50.dp
                )
                .offset(x = 10.dp, y = -10.dp),


            ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null,

                )
        }
    }

}


fun toTheTop() {
}