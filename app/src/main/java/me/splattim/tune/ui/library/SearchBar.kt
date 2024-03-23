package me.splattim.tune.ui.library

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.splattim.tune.R
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = CircleShape,
        modifier = modifier
    ) {
        TextField(
            value = "",
            placeholder = {
                Text(stringResource(id = R.string.placeholder_search))
            },
            onValueChange = {},
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            modifier = Modifier
                .heightIn(min = 56.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    TuneTheme {
        SearchBar(Modifier.padding(8.dp))
    }
}