package com.example.menuappli

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContextMenuActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)

        listView = findViewById(R.id.listView)
        val items = arrayListOf("Context Option 1", "Context Option 2", "Context Option 3", "Context Option 4", "Context Option 5")
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = arrayAdapter

        // Register the ListView for a context menu
        registerForContextMenu(listView)

        // Set an item click listener to show a Toast when an item is clicked
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = items[position]
            Toast.makeText(this, "Clicked: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }

    // Create a context menu when a list item is long-clicked
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.contextual_action_bar_menu, menu)
    }

    // Handle context menu item clicks
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val selectedItem = listView.adapter.getItem(info.position) as String

        return when (item.itemId) {
            R.id.action_delete -> {
                Toast.makeText(this, "Deleted: $selectedItem", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_share -> {
                Toast.makeText(this, "Shared: $selectedItem", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}