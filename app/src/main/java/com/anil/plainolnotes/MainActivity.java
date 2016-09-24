package com.anil.plainolnotes;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.anil.plainolnotes.com.anil.plainoldnotes.data.NoteItem;
import com.anil.plainolnotes.com.anil.plainoldnotes.data.NotesDataSource;

import java.util.List;

public class MainActivity extends ListActivity {
    private NotesDataSource dataSource;
    List<NoteItem> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new NotesDataSource(this); //current instance of the activity
        refreshDisplay();

    }

    private void refreshDisplay() {
        notesList = dataSource.findAll();
        //how the data should be displayed and what data it should use
        ArrayAdapter<NoteItem> adapter = new ArrayAdapter<NoteItem>(this, R.layout.list_item_layout, notesList);
        setListAdapter(adapter);
    }

}
