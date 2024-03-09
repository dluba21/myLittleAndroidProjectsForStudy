package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.basiccompose.model.DataSource
import com.example.basiccompose.ui.theme.BasicComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtWorkCard()
                }
            }
        }
    }
}



@Composable
fun ArtWorkCard(modifier: Modifier = Modifier) {
    var picCounter by remember { mutableIntStateOf(0) }
    var artWorkList by remember { mutableStateOf(DataSource().getArtWorkList()) }


    Surface(
        color = Color.Blue,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(350.dp)
                    .weight(8f)
                ,
                painter = painterResource(id = artWorkList[picCounter].image),
                contentDescription =   artWorkList[picCounter].toString(),
            )
            AuthorText(stringResource(id = artWorkList[picCounter].artist), modifier.weight(1f))
            PictureNameText(stringResource(id = artWorkList[picCounter].title),  modifier.weight(1f))
            BottomButtons(
                counter = picCounter,
                maxSize = artWorkList.size,
                modifier.weight(1f),
                onClickLeft = {
                    if (picCounter > 0) {
                        picCounter--
                    }
                },
                onClickRight = {
                    if (picCounter + 1 < artWorkList.size)
                             picCounter++
                }
            )

        }
    }
}

@Composable
fun AuthorText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Serif,
        letterSpacing = 0.2.em,
        lineHeight = 20.sp,
        overflow = TextOverflow.Clip,
        softWrap = true,
        maxLines = 2,
        modifier = modifier
            .height(30.dp)
    )
}

@Composable
fun PictureNameText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 0.2.em,
        lineHeight = 20.sp,
        overflow = TextOverflow.Clip,
        softWrap = true,
        maxLines = 2,
        modifier = modifier
            .height(30.dp)
    )
}

@Composable
fun BottomButtons(counter: Int, maxSize: Int, modifier: Modifier = Modifier, onClickLeft: () -> Unit, onClickRight: () -> Unit) {
    Row(
        modifier = modifier
    ) {
        Button(onClick = onClickLeft,
            enabled = counter > 0,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color.DarkGray
            ),
            modifier = Modifier
                .align(Alignment.Top)
                .size(170.dp, 60.dp)
                .padding(start = 10.dp)
        ) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "picture back")
        }
        Spacer(modifier = Modifier
            .width(width = 50.dp)
            .align(Alignment.CenterVertically))
        Button(onClick = onClickRight,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color.DarkGray
            ),
            enabled = counter + 1 < maxSize,
            modifier = Modifier
                .align(Alignment.Top)
                .size(170.dp, 60.dp)
                .padding(end = 10.dp)
        ) {
            Icon(Icons.Filled.ArrowForward, contentDescription = "picture forward")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicComposeTheme {
        ArtWorkCard()
    }
}