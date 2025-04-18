package com.mensinator.app.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.mensinator.app.ui.theme.MensinatorTheme

@Composable
fun MensinatorTopBar(
    @StringRes titleStringId: Int,
    onTitleClick: (() -> Unit)? = null,
    textColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.onBackground,
    textStyle: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.headlineMedium,
    backgroundColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.background // <-- NEW PARAM
) {
    androidx.compose.foundation.layout.Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor) // <-- APPLY BACKGROUND
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 25.dp, vertical = 16.dp)
                .fillMaxWidth()
        ) {
            val modifier = onTitleClick?.let {
                Modifier
                    .clip(MaterialTheme.shapes.small)
                    .clickable { it() }
            } ?: Modifier

            Text(
                text = stringResource(titleStringId),
                modifier = modifier,
                style = textStyle,
                color = textColor,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

private class ScreenTitleProvider : PreviewParameterProvider<Int> {
    override val values: Sequence<Int>
        get() = Screen.entries.map { it.titleRes }.asSequence()
}

@Preview(showBackground = true)
@Composable
private fun MensinatorTopBarPreview(
    @PreviewParameter(ScreenTitleProvider::class) stringId: Int,
) {
    MensinatorTheme {
        MensinatorTopBar(stringId)
    }
}