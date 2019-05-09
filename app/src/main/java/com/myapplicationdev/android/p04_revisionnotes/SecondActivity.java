package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	TextView NotesResult;
	ArrayAdapter aa;
	ArrayList<Note> note;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView

		lv = findViewById(R.id.lv);
		NotesResult = findViewById(R.id.textViewNote);

		note = new ArrayList<Note>();

		DBHelper db = new DBHelper(SecondActivity.this);



		// Insert a task
		ArrayList<Note> data = db.getAllNotes();
		db.close();


		String txt = "";
		for (int i = 0; i < data.size(); i++) {
			//Debug using Logcat
			Log.d("Database Content", i +". "+data.get(i));
			txt += i + ". " + data.get(i).getNoteContent() + data.get(i).getStars() + "\n";
		}
		NotesResult.setText(txt);




	}


	}

