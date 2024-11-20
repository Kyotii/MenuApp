package com.example.menuappli

import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu

class PopupMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_menu)

        val buttonShowPopup: Button = findViewById(R.id.button_show_popup)
        buttonShowPopup.setOnClickListener { view ->
            showPopupMenu(view) // Call the function when the button is clicked
        }
    }

    // Popup menu function
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view) // 'view' anchors the popup menu
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.popup_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.action_option_1 -> {
                    Toast.makeText(this, "Popup Menu 1", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_option_2 -> {
                    Toast.makeText(this, "Popup Menu 2", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_option_3 -> {
                    Toast.makeText(this, "Popup Menu 3", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }
}
