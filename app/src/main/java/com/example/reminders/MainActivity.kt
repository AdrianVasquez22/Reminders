package com.example.reminders

import android.os.Bundle
import android.provider.CalendarContract.Reminders
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reminders.data.DataSource
import com.example.reminders.model.Reminder
import com.example.reminders.ui.theme.RemindersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RemindersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReminderApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun ReminderApp() {
    ReminderList(DataSource.Reminders)
}

@Composable
fun ReminderList(reminderList: List<Reminder>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(reminderList) {reminder ->
            ReminderCard(
                reminder = reminder,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ReminderCard(reminder: Reminder, modifier: Modifier = Modifier) {
    Card(modifier = modifier
            .padding(8.dp)) {
        Column {
            Text(
                text = stringResource(id = reminder.dayId),
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Image(
                painter = painterResource(id = reminder.imageResourceId),
                contentDescription = stringResource(id = reminder.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = reminder.stringResourceId),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun ReminderCardPreview() {
    ReminderCard(reminder = DataSource.Reminders[0])
}