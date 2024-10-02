package com.example.apptask.ui.theme.customlayout

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.SpanStyle

@Composable
fun AppLaunchText() {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)) {
            append("A")
        }
        append("PP")
        withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)) {
            append("L")
        }
        append("AUNCH")
    }

    Text(
        text = annotatedString,
        fontSize = 24.sp,
        textAlign = TextAlign.Center
    )
}
