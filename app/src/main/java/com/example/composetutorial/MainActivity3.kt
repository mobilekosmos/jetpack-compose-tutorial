package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

/**
 * Configure your layout
Your message layout has the right structure but its elements aren't well spaced and the image is too big!
To decorate or configure a composable, Compose uses modifiers. They allow you to change the composable's size,
layout, appearance or add high-level interactions, such as making an element clickable.
You can chain them to create richer composables. You'll use some of them to improve the layout.
 */
class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard3(Message3("Android", "Jetpack Compose"))
        }
    }
}

data class Message3(val author: String, val message: String)

@Composable
fun MessageCard3(msg: Message3) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.message)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard3() {
    MessageCard3(Message3("Colleague", "Hey, take a look at Jetpack Compose, it's great!"))
}