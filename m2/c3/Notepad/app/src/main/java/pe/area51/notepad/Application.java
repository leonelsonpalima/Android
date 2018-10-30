package pe.area51.notepad;

import pe.area51.notepad.data.fakedatabase.FakeDatabase;
import pe.area51.notepad.domain.NotesRepository;

public class Application extends android.app.Application {

    private NotesRepository notesRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        notesRepository = new FakeDatabase();
    }

    public NotesRepository getNotesRepository() {
        return notesRepository;
    }
}
