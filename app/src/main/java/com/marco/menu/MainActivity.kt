package com.marco.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.marco.menu.itemLista.FoodItem
import com.marco.menu.model.Food

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {

    val foodList: MutableList<Food> = mutableListOf(
        Food(
            imgFood = R.drawable.food1,
            foodName = "Food 1",
            foodDescription = "Rato com arroz",
            price = "$ 120.00",
        ),
        Food(
            imgFood = R.drawable.food2,
            foodName = "Food 2",
            foodDescription = "Rato com arroz",
            price = "$ 80.00",
        ),
        Food(
            imgFood = R.drawable.food3,
            foodName = "Food 3",
            foodDescription = "Rato com arroz",
            price = "$ 100.00",
        ),
        Food(
            imgFood = R.drawable.food4,
            foodName = "Food 4",
            foodDescription = "Rato com arroz",
            price = "$ 20.00",
        ),
        Food(
            imgFood = R.drawable.food5,
            foodName = "Food 5",
            foodDescription = "Rato com arroz",
            price = "$ 150.00",
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){

        LazyColumn{
            itemsIndexed(foodList){position, food->
                FoodItem(food = food)
            }
        }
    }
}

