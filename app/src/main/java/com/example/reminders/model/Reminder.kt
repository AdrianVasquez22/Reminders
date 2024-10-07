package com.example.reminders.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Reminder(
    @StringRes val dayId: Int,
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
)
