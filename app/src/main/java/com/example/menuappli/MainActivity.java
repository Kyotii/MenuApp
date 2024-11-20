package com.example.menuappli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOptionsMenu = findViewById(R.id.button_options_menu);
        Button buttonContextMenu = findViewById(R.id.button_context_menu);
        Button buttonPopupMenu = findViewById(R.id.button_popup_menu);
        Button buttonDialogs = findViewById(R.id.button_dialogs);
        Button buttonPickers = findViewById(R.id.button_pickers);

        buttonOptionsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OptionsMenuActivity.class));
            }
        });

        buttonContextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContextMenuActivity.class));
            }
        });

        buttonPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PopupMenuActivity.class));
            }
        });

        buttonDialogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DialogsActivity.class));
            }
        });

        buttonPickers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PickersActivity.class));
            }
        });
    }
}
