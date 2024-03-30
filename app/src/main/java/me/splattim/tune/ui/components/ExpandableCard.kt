package me.splattim.tune.ui.components

import android.graphics.drawable.Drawable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import me.splattim.tune.R
import me.splattim.tune.data.Album
import me.splattim.tune.data.Cardable
import me.splattim.tune.ui.theme.TuneTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpandableCard(
    cardable: Cardable,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    var focused by remember { mutableStateOf(false)}
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            cardable.image,
            contentDescription = null,
            modifier = Modifier.combinedClickable(
                onClick = onClick,
                onLongClick = {focused = true}
            )
        )
        if (focused)
            Text(cardable.name)
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableCardPreview() {
    TuneTheme() {
        ExpandableCard(Album(name = "Sample Text", image = painterResource(id = R.drawable.ic_launcher_background)))
    }
}