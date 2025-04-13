package com.mensinator.app.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mensinator.app.R
import com.mensinator.app.ui.theme.appBlack
import com.mensinator.app.ui.theme.appDRed
import com.mensinator.app.ui.theme.appWhite

@Composable
fun ArticleLayout(
    heading: String,
    content: String
) {
    val headingFont = FontFamily(
        Font(R.font.secfont) // use your actual file
    )
    val contentFont = FontFamily(
        Font(R.font.textfont) // use your actual file
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(appWhite)
            .padding(18.dp),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        item {
            Text(
                text = heading,
                fontFamily = headingFont,
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = appDRed,
                lineHeight = 64.sp,
                modifier = Modifier.padding(bottom = 8.dp, top = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = content,
                fontFamily = contentFont,
                fontSize = 24.sp,
                lineHeight = 30.sp,
                color = appBlack,

//                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Composable
fun ArticleScreen() {
    ArticleLayout(
        heading = ArticleOne.heading,
        content = ArticleOne.article
    )
}