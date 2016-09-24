package com.anil.plainolnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.anil.plainolnotes.com.anil.plainoldnotes.data.NoteItem;
import com.anil.plainolnotes.com.anil.plainoldnotes.data.NotesDataSource;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private NotesDataSource dataSource;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        dataSource = new NotesDataSource(this); //current instance of the activity
        List<NoteItem> notes = dataSource.findAll(); //gets all notes
        NoteItem note = notes.get(0);
        note.setText("UPDATED!");

        dataSource.update(note);

        notes = dataSource.findAll();
        note = notes.get(0);

        Log.i("NOTES",note.getKey() + " : " + note.getText());
    }
}
