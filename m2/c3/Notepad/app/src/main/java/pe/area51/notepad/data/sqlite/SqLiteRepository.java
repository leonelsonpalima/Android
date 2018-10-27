package pe.area51.notepad.data.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import pe.area51.notepad.domain.Note;
import pe.area51.notepad.domain.NotesRepository;

public class SqLiteRepository implements NotesRepository {

    private final DatabaseManager databaseManager;

    public SqLiteRepository(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @NonNull
    @Override
    public Note createNote(@NonNull Note note) {
        final SQLiteDatabase sqLiteDatabase = databaseManager.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("title", note.getTitle());
        contentValues.put("content", note.getContent());
        contentValues.put("creationtimestamp", note.getCreationTimestamp());
        final long id = sqLiteDatabase.insert(
                "notes",
                null,
                contentValues

        );
        return new Note(
                String.valueOf(id),
                note.getTitle(),
                note.getContent(),
                note.getCreationTimestamp()
        );
    }

    @Override
    public boolean deleteNote(@NonNull Note note) {
        return false;
    }

    @Override
    public boolean updateNote(@NonNull Note note) {
        return false;
    }

    @NonNull
    @Override
    public List<Note> getAllNotes() {
        final SQLiteDatabase sqLiteDatabase = databaseManager.getReadableDatabase();
        final Cursor cursor = sqLiteDatabase.rawQuery("Select * from notes", null);
        final List<Note> notes = new ArrayList<>();
        while(cursor.moveToNext()){
            final long id = cursor.getLong(cursor.getColumnIndex("id"));
            final String title = cursor.getString(cursor.getColumnIndex("title"));
            final String content= cursor.getString(cursor.getColumnIndex("content"));
            final long creationtimestamp = cursor.getLong(cursor.getColumnIndex("creationtimestamp"));
            notes.add(new Note(String.valueOf(id), title, content, creationtimestamp));
        }
    }
}
