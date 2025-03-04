package com.example.kotlincomposite2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlincomposite2.ui.theme.KotlinComposite2Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinComposite2Theme {
                Grid_(Modifier);
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinComposite2Theme {
        Greeting("Android")
    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Grid_(modifier: Modifier):Unit {
    FlowRow(verticalArrangement = Arrangement.spacedBy(8.dp), horizontalArrangement =  Arrangement.spacedBy(8.dp),
            modifier=modifier) {
        val image=arrayOf(R.drawable.chomper,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground);
        val title=arrayOf("chomper","background","foreground");
        val number=arrayOf(1,2,3);
        for (i in 0..10){
            val j= Random.nextInt(image.size);
            Element(image[j],title[j],image[j],number[j],modifier);
        }
    }
}
@Composable
fun Element(image:Int,title:String,icon:Int,number:Int,modifier: Modifier):Unit{
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(68.dp)
            .width(190.dp)
            .background(color = Color(90,90,90,10),shape= RoundedCornerShape(10.dp))
    ){
        Image(painter=painterResource(image),null,modifier=modifier
            .width(68.dp))
        Spacer(Modifier.size(16.dp))
        Column {
            Spacer(Modifier.size(16.dp))
            Text(text=title)
            Spacer(Modifier.size(8.dp))
            Row {
                Image(painter=painterResource(icon),null,modifier=modifier)
                Spacer(Modifier.size(8.dp))
                Text(text=number.toString())
            }
        }
        Spacer(Modifier.size(16.dp))
    }
}