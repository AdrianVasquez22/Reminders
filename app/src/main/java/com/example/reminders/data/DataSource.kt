package com.example.reminders.data

import com.example.reminders.R
import com.example.reminders.model.Reminder

object DataSource {
    val Reminders = listOf(
        Reminder(R.string.day1, R.string.reminder1, R.drawable.medication),
        Reminder(R.string.day2, R.string.reminder2, R.drawable.exercise),
        Reminder(R.string.day3, R.string.reminder3, R.drawable.study),
        Reminder(R.string.day4, R.string.reminder4, R.drawable.meditate),
        Reminder(R.string.day5, R.string.reminder5, R.drawable.work),
        Reminder(R.string.day6, R.string.reminder6, R.drawable.sleep),
        Reminder(R.string.day7, R.string.reminder7, R.drawable.friends),
        Reminder(R.string.day8, R.string.reminder8, R.drawable.party)
    )
}