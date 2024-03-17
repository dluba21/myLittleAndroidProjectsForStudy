package com.example.superheroesapp

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        modifier = modifier
            .height(72.dp)

    ) {
        //Column??
        Box(
            modifier = modifier
                .clip(
                    RoundedCornerShape(16.dp)
                )
        ) {
            Row {
                TextColumn(
                    hero,
                    modifier.weight(1f)
                )
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = "Hero card",
                    contentScale = ContentScale.Fit,

                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp)),
                )
            }

        }
    }
}

@Composable
fun TextColumn(hero: Hero, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = hero.nameRes),
            style = MaterialTheme.typography.titleSmall,
        )
        Text(
            text = stringResource(id = hero.descriptionRes),
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis,
            softWrap = true,
        )
    }
}
