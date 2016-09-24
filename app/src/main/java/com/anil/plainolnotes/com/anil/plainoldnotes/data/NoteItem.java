package com.anil.plainolnotes.com.anil.plainoldnotes.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by anil on 24/09/2016.
 */

public class NoteItem
{
    private String key;
    private String text;


    public String getText()
    {
        return text;
    }


    public void setText( String text )
    {
        this.text = text;
    }


    public String getKey()
    {
        return key;
    }


    public void setKey( String key )
    {
        this.key = key;
    }

    public static NoteItem getNew()
    {
        Locale locale = new Locale("en_US");
        Locale.setDefault(locale);

        String pattern = "yyyy-MM-dd HH:mm:ss Z";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String key = formatter.format(new Date());

        NoteItem note = new NoteItem();
        note.setKey(key);
        note.setText("");

        return note;
    }

    @Override
    public String toString() {
        return this.getText();
    }
}
