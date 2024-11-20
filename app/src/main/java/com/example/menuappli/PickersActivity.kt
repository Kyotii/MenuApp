package com.example.menuappli

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class PickersActivity : AppCompatActivity() {
    private lateinit var buttonDatePicker: Button
    private lateinit var buttonTimePicker: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickers)

        // Initialize buttons using findViewById
        buttonDatePicker = findViewById(R.id.button_date_picker)
        buttonTimePicker = findViewById(R.id.button_time_picker)

        // Set listeners for the buttons
        buttonDatePicker.setOnClickListener { showDatePickerDialog() }
        buttonTimePicker.setOnClickListener { showTimePickerDialog() }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]

        val datePickerDialog = DatePickerDialog(
            this@PickersActivity,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate =
                    "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                Toast.makeText(
                    this@PickersActivity,
                    "Selected Date: $selectedDate", Toast.LENGTH_SHORT
                ).show()
            },
            year, month, dayOfMonth
        )

        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar[Calendar.HOUR_OF_DAY]
        val minute = calendar[Calendar.MINUTE]

        val timePickerDialog = TimePickerDialog(
            this@PickersActivity,
            { _, selectedHour, selectedMinute ->
                val selectedTime =
                    "$selectedHour:${if (selectedMinute < 10) "0$selectedMinute" else selectedMinute}"
                Toast.makeText(
                    this@PickersActivity,
                    "Selected Time: $selectedTime", Toast.LENGTH_SHORT
                ).show()
            },
            hour, minute, true
        )

        timePickerDialog.show()
    }
}
