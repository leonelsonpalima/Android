package pe.area51.notepad.data.room;

import android.support.annotation.NonNull;

import java.util.List;

import pe.area51.notepad.domain.Note;
import pe.area51.notepad.domain.NotesRepository;

public class RoomNoteRepository implements NotesRepository {


    private final RoomDatabase roomDatabase;

    public RoomNoteRepository(RoomDatabase roomDatabase) {
        this.roomDatabase = roomDatabase;
    }

    @NonNull
    @Override
    public List<Note> getAllNotes() {
        return null;
    }

    @Override
    public boolean updateNote(@NonNull Note note) {

        roomDatabase.getNoteDao(
                new pe.area51.notepad.data.room.Note()
        );
        return false;
    }

    @Override
    public boolean deleteNote(@NonNull String noteId) {
        return roomDatabase.getNoteDao().deleteNote(
                new pe.area51.notepad.data.room.Note(
                        Long.valueOf(noteId)
        )) != 0;
    }

    @NonNull
    @Override
    public Note createNote(@NonNull Note note) {

        roomDatabase.getNoteDao().insertNote(
                new pe.area51.notepad.data.room.Note(
                        note.getTitle(),
                        note.getContent(),
                        note.getCreationTimestamp()
                )
        );
        return new Note(
                String.valueOf(id),
                note.getTitle(),
                note.getContent(),
                note.getCreationTimestamp()
        );
    }
}
