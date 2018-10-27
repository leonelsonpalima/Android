package pe.area51.notepad.data.fakedatabase;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import pe.area51.notepad.domain.Note;
import pe.area51.notepad.domain.NotesRepository;

public class FakeDatabase implements NotesRepository {

    private final List<Note> notes;

    public FakeDatabase() {
        this.notes = new ArrayList<>();
    }

    @NonNull
    @Override
    public Note createNote(@NonNull Note note) {
        final int id = notes.size() + 1;
        final Note createdNote = new Note(
                String.valueOf(id),
                note.getTitle(),
                note.getContent(),
                note.getCreationTimestamp()
        );
        notes.add(createdNote);
        return createdNote;
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
        return notes;
    }
}
