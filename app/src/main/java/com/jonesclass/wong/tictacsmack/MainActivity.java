package com.jonesclass.wong.tictacsmack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    Button selectButton;
    String teamChoice;
    AlertDialog.Builder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton TWO_PLAYERS_RADIO_BUTTON = findViewById(R.id.radioButton_twoPlayers);


        RadioGroup playersRadioGroup = findViewById(R.id.radioGroup_players);
        playersRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radioButton_twoPlayers) {
                    startButton.setVisibility(View.VISIBLE);
                    selectButton.setVisibility(View.GONE);
                } else {
                    startButton.setVisibility(View.GONE);
                    selectButton.setVisibility(View.VISIBLE);
                }
            }
        });

        startButton = findViewById(R.id.button_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(startIntent);
            }
        });

        selectButton = findViewById(R.id.button_selectTeam);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTeamDialog();
            }
        });


    }

    private void selectTeamDialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        final String[] TEAM_CHOICES = {"Musk", "Bezos"};
        dialogBuilder.setTitle("Choose Your Team");
        dialogBuilder.setSingleChoiceItems(TEAM_CHOICES, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                teamChoice = TEAM_CHOICES[which];
                if (teamChoice.equals("Musk")) {
                    Toast.makeText(MainActivity.this, "SpaceX Blasts Off", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(MainActivity.this, "Blue Origin Blasts Off", Toast.LENGTH_SHORT);
                }
                startButton.setVisibility(View.VISIBLE);
                dialog.dismiss();
            }
        });

        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "No Team Selected", Toast.LENGTH_SHORT);
            }
        });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }
}