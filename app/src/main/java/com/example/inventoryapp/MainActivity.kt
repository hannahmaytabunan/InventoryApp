package com.example.inventoryapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.inventoryapp.data.ItemsDatasource
import com.example.inventoryapp.models.Item
import com.example.inventoryapp.navigation.ItemNavigation
import com.example.inventoryapp.ui.theme.InventoryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                //    var list = ItemsDatasource().loadItems()

//                val list = remember {
//                    mutableStateListOf<Item>()
//                }
                ItemNavigation()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp(content: @Composable () -> Unit) {
    InventoryAppTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        //    var list = ItemsDatasource().loadItems()

//        val list = remember {
//            mutableStateListOf<Item>()
//        }
        ItemNavigation()
    }
}