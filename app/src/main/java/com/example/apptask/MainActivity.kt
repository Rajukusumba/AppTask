package com.example.apptask

import android.annotation.SuppressLint
import android.app.ActivityManager.AppTask
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.applaunchwork.ui.theme.AppLaunchWorkTheme
import com.example.applaunchwork.ui.theme.AppNavigation
import com.example.applaunchwork.ui.theme.Graph
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLaunchWorkTheme {

                Graph.provide(this)

AppNavigation()
            }


        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    AppTaskTheme {
//        Greeting("Android")
//    }
//}
//
//@Composable
//fun AppTaskTheme(content: @Composable () -> Unit) {
//
//}
