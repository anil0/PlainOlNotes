package com.anil.plainolnotes;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by anil on 24/09/2016.
 */

public class NoteEditorActivity extends Activity
{
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_note_editor_layout );
    }
}
