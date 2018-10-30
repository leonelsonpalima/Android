package pe.area51.notepad.domain;

import android.support.annotation.NonNull;

import java.util.List;

public interface NotesRepository {
    @NonNull
    Note createNote(@NonNull final Note note);
    boolean deleteNote (@NonNull final Note note);
    boolean updateNote (@NonNull final Note note);

    @NonNull
    List<Note> getAllNotes();
}
