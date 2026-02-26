package ci.nsu.moble.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ci.nsu.moble.main.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val helloAndroid = "Hello Android".filter { it.isLetter() }
        val firstPart = helloAndroid.take(5)
        val secondPart = helloAndroid.takeLast(7)
        setContent {
            Column(modifier = Modifier.padding(top=50.dp)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row (modifier = Modifier.padding(10.dp)
                    .background(Color.Red)
                    .fillMaxWidth())
                {
                    Box(modifier = Modifier.padding(15.dp))
                    {
                        Text(text = "Red")
                    }
                }
                Row (modifier = Modifier.background(Color.Yellow))
                {
                    Box(Modifier.fillMaxWidth())
                    {
                        Text(text = "Yellow")
                    }
                }


                Row (modifier = Modifier.padding(top = 60.dp)
                    .background(Color.Cyan)
                ){
                    for(char in firstPart){
                        Box(modifier = Modifier.padding(5.dp)
                            .background(Color.Black)
                            .weight(weight = 1f)
                            .aspectRatio(1f)

                            )
                        {
                            Text(
                                text = char.toString())
                        }


                    }
                }

                Row (modifier = Modifier.padding(top = 60.dp)
                    .background(Color.Magenta)
                ) {
                    for (char in secondPart)
                    {
                        Box(modifier = Modifier.padding(5.dp)
                            .weight(weight = 1f)
                            .aspectRatio(1f),
                        )
                        {
                            Text(
                                text = char.toString())
                        }
                    }

                }



            }


        }
    }
}
