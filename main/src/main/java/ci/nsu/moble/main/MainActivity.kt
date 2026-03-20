package ci.nsu.moble.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ci.nsu.moble.main.ui.theme.PracticeTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

private val colorMap = mapOf(
    "Red" to Color.Red,
    "Yellow" to Color.Yellow,
    "Green" to Color.Green,
    "Blue" to Color.Blue
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val helloAndroid = "Hello Android".filter { it.isLetter() }
        val firstPart = helloAndroid.take(5)
        val secondPart = helloAndroid.takeLast(7)

        setContent {
            var textInput by remember {mutableStateOf("")}
            var buttonColor by remember {mutableStateOf(Color.Gray)}
            Column(modifier = Modifier.padding(top = 80.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row()
                {
                    TextField(modifier = Modifier.fillMaxWidth(),
                        value = textInput,
                        onValueChange = { textInput = it },
                        label = {Text("Enter color")}
                    )
                }
                Row(modifier = Modifier.padding(bottom=25.dp)
                    .background(buttonColor)
                    .fillMaxWidth())
                {
                    Box(modifier = Modifier
                        .clickable{
                            val foundColor = colorMap[textInput.trim()]
                            if(foundColor != null)
                            {
                               buttonColor = foundColor
                            }
                            else
                            {
                                android.util.Log.d("ColorSearch", "Пользовательский цвет '$textInput' не найден")
                            }
                        }
                        .padding(20.dp))
                    {
                        Text(text = "Apply color",
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center)
                    }
                }
                Row (modifier = Modifier.background(Color.Red)
                    .fillMaxWidth())
                {
                    Box(modifier = Modifier.padding(20.dp))
                    {
                        Text(text = "Red",
                        color = Color.White, fontSize = 18.sp,)
                    }
                }
                Row (modifier = Modifier.background(Color.Yellow)
                    .fillMaxWidth()
                )
                {
                    Box(Modifier.padding(20.dp))
                    {
                        Text(text = "Yellow",
                            color = Color.White, fontSize = 18.sp,)
                    }
                }

                Row (modifier = Modifier.background(Color.Green)
                    .fillMaxWidth())
                {
                    Box(Modifier.padding(20.dp))
                    {
                        Text(text = "Green",
                            color = Color.White, fontSize = 18.sp,)
                    }
                }

                Row (modifier = Modifier.background(Color.Blue)
                    .fillMaxWidth())
                {
                    Box(Modifier.padding(20.dp))
                    {
                        Text(text = "Blue",
                            color = Color.White, fontSize = 18.sp,)
                    }
                }



            }

        }
    }
}
