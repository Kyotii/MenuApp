package com.example.menuappli

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class DialogsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogs)

        val buttonAlertDialog = findViewById<Button>(R.id.button_alert_dialog)

        buttonAlertDialog.setOnClickListener {
            val builder =
                AlertDialog.Builder(this@DialogsActivity)
            builder.setMessage("Click OK to continue or Cancel to stop.")
                .setCancelable(false)
                .setPositiveButton(
                    "OK"
                ) { dialog, id ->

                }
                .setNegativeButton(
                    "Cancel"
                ) { dialog, id ->

                }

            val alert = builder.create()
            alert.show()
        }
    }
}