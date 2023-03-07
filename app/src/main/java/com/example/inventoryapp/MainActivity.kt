package com.example.inventoryapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inventoryapp.navigation.ItemNavigation
import com.example.inventoryapp.screens.ItemViewModel
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
                val itemViewModel = viewModel<ItemViewModel>()
                InventoryApp(itemViewModel = itemViewModel)
            }
        }
    }
}

@Composable
fun InventoryApp(itemViewModel: ItemViewModel) {
    val itemsList = itemViewModel.itemList.collectAsState().value
    ItemNavigation(
        items = itemsList,
        onAddItem = {
            itemViewModel.addItem(it)
        },
        onUpdateItem = {
            itemViewModel.updateItem(it)
        },
        onRemoveItem = {
            itemViewModel.removeItem(it)
        }
    )
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
//        ItemNavigation()

        val itemViewModel = viewModel<ItemViewModel>()
        InventoryApp(itemViewModel = itemViewModel)
    }
}