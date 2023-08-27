package com.marco.menu.itemLista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.marco.menu.model.Food

@Composable
fun FoodItem(
    food: Food
) {

    val imagemFood = food.imgFood
    val nameFood = food.foodName
    val description = food.foodDescription
    val price = food.price

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        ConstraintLayout(
            Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp)
        ){
            val (img, titulo, descricao, preco, btn, contFood) = createRefs()

            Card(
                modifier = Modifier
                    .constrainAs(contFood) {
                        top.linkTo(parent.top, margin = 0.dp)
                        start.linkTo(parent.start, margin = 0.dp)
                    }
                    .size(130.dp)
                    .padding(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )

            ){

            }

            Image(
                painter = painterResource(imagemFood!!),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(img) {
                        top.linkTo(contFood.top, 0.dp)
                        start.linkTo(contFood.start, 0.dp)
                        end.linkTo(contFood.end, 0.dp)
                        bottom.linkTo(contFood.bottom, 0.dp)
                    }
                    .size(60.dp)
            )

            Text(
                text = nameFood!!,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(titulo){
                    top.linkTo(parent.top, 15.dp)
                    start.linkTo(contFood.end, 0.dp)
                }
                )

            Text(
                text = description!!,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(descricao) {
                        top.linkTo(titulo.bottom, 0.dp)
                        start.linkTo(contFood.end, 0.dp)

                    }
                    .padding(0.dp, 10.dp, 40.dp, 0.dp),
                maxLines = 3
            )

            Text(
                text = price!!,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(preco){
                    top.linkTo(descricao.bottom, 20.dp)
                    start.linkTo(contFood.end, 0.dp)
                }
            )

            Button(
                onClick = {

                },
                modifier = Modifier.constrainAs(btn){
                    top.linkTo(descricao.bottom, 10.dp)
                    start.linkTo(preco.end, 20.dp)
                    end.linkTo(parent.end, 10.dp)
                }
            ) {
                Text(
                    text = "Add Cart",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,

                )
            }
        }
    }
}

