package com.example.games_app.uis.sudoku

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SudokuGameBox() {

    val listOfNumbers = listOf("1","2","3","4","5","6","7","8","9")

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(9),
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(5.dp)
            ) {
            items(listOfNumbers){number->
                Cell(number = number) {

                }
            }
        }
    }

}


@Composable
fun Cell(number:String,onValueChangeListener:(String)->Unit) {

    TextField(
        value = number,
        onValueChange = onValueChangeListener,
        textStyle = TextStyle(
            fontSize = 15.sp
        ),
        modifier = Modifier
            .width(45.dp)
            .height(55.dp)
            .padding(1.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
        ),
        singleLine = true
    )

}

@Preview(showBackground = true)
@Composable
fun UIPreview() {
    SudokuGameBox()
}
