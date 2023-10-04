package com.example.intentdeepdive

import android.content.Intent
import android.net.Uri
import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputFun() {
    val context = LocalContext.current
    var text by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        TextField(
            value = text,
            onValueChange = {text = it},
            placeholder = {Text("Enter you name")}
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(

            onClick = {

            val intent = Intent(context,SecondActivity::class.java)
                intent.putExtra("message_key",text.text)
            context.startActivity(intent)
        },
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Text("Click me !")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val intent = context.packageManager.getLaunchIntentForPackage("com.google.android.youtube")
                if(intent != null) {
                    context.startActivity(intent)
                } else {
                    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"))
                    context.startActivity(webIntent)
                }
            },
            modifier = Modifier
                .align(CenterHorizontally)
        ) {
            Text("Open Youtube")
        }
    }
}

@Composable
fun displayFun(text : String) {

    Text("Hi, $text")
}