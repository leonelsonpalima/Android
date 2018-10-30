package pe.area51.notepad.data.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("Select * from notes")
    List<Note> getAll();

    long insertNote(final Note note);

    @Delete
    int deleteNote(final Note note);

    @Query("Select * from notes where id = :id")
    Note getNoteById(final String id);

    @Update
    int updateNote(final Note note);

}
