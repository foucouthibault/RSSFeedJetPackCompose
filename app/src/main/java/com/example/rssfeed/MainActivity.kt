package com.example.rssfeed

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rssfeed.ui.newsdetails.NewsDetailsScreen
import com.example.rssfeed.ui.newslist.NewsListScreen
import com.example.rssfeed.ui.theme.RSSFeedTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSSFeedTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RssNavigator()
                }
            }
        }
    }
}

@HiltAndroidApp
class CoreApplication : Application()

@Composable
fun RssNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "news_list") {
        composable("news_list") {
            NewsListScreen { index ->
                navController.navigate("news_details/$index")
            }
        }
        composable(
            "news_details/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) { backStackEntry ->
            NewsDetailsScreen(backStackEntry.arguments?.getInt("index")) {
                navController.popBackStack()
            }
        }
    }
}
