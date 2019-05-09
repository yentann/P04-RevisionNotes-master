package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtnote;
    RadioGroup rg;
    Button btninsert;
    Button btnshowlist;

    ArrayList<Note> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnote = findViewById(R.id.editTextNote);
        rg = findViewById(R.id.radioGroupStars);
        btninsert = findViewById(R.id.buttonInsertNote);
        btnshowlist = findViewById(R.id.buttonShowList);


        //insert button
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);

                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                // db.insertNote(etNote.getText().toString(), Integer.parseInt(rb.getText()));
                db.close();

                Toast.makeText(MainActivity.this, "inserted", Toast.LENGTH_LONG).show();

            }
        });

        //show list button
        btnshowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Note> data = db.getAllNotes();
                db.close();


                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", data.get(i).getId() +". "+ data.get(i).getNoteContent() +". " + data.get(i).getStars());
//                    int theID = data.get(i).getId();
//                    String theNote = data.get(i).getNoteContent();
//                    int theStar = data.get(i).getStars();

                    //Intent intent = new Intent (getBaseContext(), SecondActivity.class);
//                    intent.putExtra("id", theID);
//                    intent.putExtra("note", theNote);
//                    intent.putExtra("star", theStar);
                    //startActivity(intent);
                }

                //pass to SecondActivity
                Intent intent = new Intent (getBaseContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}
