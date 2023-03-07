package com.example.inventoryapp.components

import android.service.autofill.OnClickAction
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.inventoryapp.models.Item

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ItemInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = maxLine,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )
}

@Composable
fun ItemButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    backgroundColor: Color,
    contentColor: Color,
    elevation: ButtonElevation?
) {
    Button(onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        elevation = elevation
    ) {
       Text(text)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ItemInputNumber(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = maxLine,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )
}

@Composable
fun ItemRow(
    modifier: Modifier = Modifier,
    item: Item,
    onItemClicked: (Item) -> Unit,
    hideStock: Boolean = false
) {
    Card(
        modifier
//            .padding(bottom = 4.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                onItemClicked(item)
            }
    ) {
        Row(modifier = Modifier.bottomBorder(strokeWidth = 1.dp, color = Color.LightGray, leftSpace = 75.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(50.dp),
                elevation = 5.dp
            ) {
//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie image")

//                TODO
//                Image(
//                    painter = rememberAsyncImagePainter(item.image),
//                    contentDescription = "Item Image",
//                    modifier = Modifier.clip(CircleShape),
//                    contentScale = ContentScale.Crop,
//                )
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier
                    .padding(4.dp)
                    .width(200.dp)) {
                    Text(text = item.name,
                        style = MaterialTheme.typography.subtitle1
                    )

//                    Spacer(modifier = Modifier.width(5.dp))
                    if (hideStock) {
                        Text(text = "${item.stock} in stock",
                            style = MaterialTheme.typography.caption
                        )
                    }
                }

//            Spacer(modifier = Modifier.width(60.dp))
                Text(text = "$${item.price.toDouble()}",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(end = 6.dp)
                )
            }
        }
    }
}