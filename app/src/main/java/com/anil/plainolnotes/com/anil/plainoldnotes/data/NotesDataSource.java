package com.anil.plainolnotes.com.anil.plainoldnotes.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by anil on 24/09/2016.
 * This dataSource class will hide all the implementation of the Shared Preferences
 */

public class NotesDataSource {
    private static final String PREFKEY = "notes"; //key for initialising sharedpref
    private SharedPreferences notePrefs; //shared pref object

    public NotesDataSource(Context context) {
        notePrefs = context.getSharedPreferences(PREFKEY, Context.MODE_PRIVATE); //recommended to use MODE_PRIVATE
    }

    //return a list of notes
    public List<NoteItem> findAll() {
        //retrieving data from the shared preferences object
        Map<String, ?> notesMap = notePrefs.getAll(); //retrieve all values from the preference

        SortedSet<String> keys = new TreeSet<>(notesMap.keySet());
        //keyset() returns all the keys in all the notes in the preferences listing
        //The treeset sorts that data and returns it into a sorted set (oldest - newest sort)

        List<NoteItem> noteList = new ArrayList<>();
        for (String key : keys) {
            NoteItem note = new NoteItem();
            note.setKey(key);
            note.setText((String) notesMap.get(key));
            noteList.add(note);
        }

//        NoteItem note = NoteItem.getNew(); //was for earlier testing
//        noteList.add(note);

        return noteList;
    }

    public boolean update(NoteItem note) {
        SharedPreferences.Editor editor = notePrefs.edit(); //give me an editor that knows how to modify data in the current shared preferences object
        editor.putString(note.getKey(), note.getText());
        editor.commit(); //commit the changes

        //when a note is passed in, that key and value will be saved automatically.
        // If it didn't exist yet it will be created and if it did it will be overwritten

        return true;
    }

    public boolean remove(NoteItem note) {
        if (notePrefs.contains(note.getKey())) //if the note already exists
        {
            SharedPreferences.Editor editor = notePrefs.edit(); //give me an editor that knows how to modify data in the current shared preferences object
            editor.remove(note.getKey());
            editor.commit(); //commit the changes
        }

        return true;
    }

}
