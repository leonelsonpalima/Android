package pe.area51.notepad;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

<<<<<<< HEAD
=======
import pe.area51.notepad.domain.Note;
import pe.area51.notepad.domain.NotesRepository;

>>>>>>> efcda075c2a4068226b8c41a8e27829667057a1f
public class FragmentList extends Fragment {

    public static final String TAG = "ListFragment";

    private FragmentListInterface onNoteSelectedListener;

    private ArrayAdapter<Note> notesArrayAdapter;

<<<<<<< HEAD
=======

    private NotesRepository notesRepository;

>>>>>>> efcda075c2a4068226b8c41a8e27829667057a1f
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onNoteSelectedListener = (FragmentListInterface) context;
<<<<<<< HEAD
=======
        final Application application = (Application) context.getApplicationContext();
        notesRepository = application.getNotesRepository();
>>>>>>> efcda075c2a4068226b8c41a8e27829667057a1f
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionCreateNote:
                createNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list, container, false);
        final ListView listViewElements = view.findViewById(R.id.listView);
        notesArrayAdapter = new NoteAdapter(getActivity());
<<<<<<< HEAD
=======
        notesArrayAdapter.addAll(notesRepository.getAllNotes());
>>>>>>> efcda075c2a4068226b8c41a8e27829667057a1f
        listViewElements.setAdapter(notesArrayAdapter);
        listViewElements.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Note note = notesArrayAdapter.getItem(i);
                onNoteSelectedListener.onNoteSelected(note);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.app_name);
    }

    private void createNote() {
        final Random random = new Random();
        final int randomInt = random.nextInt();
        final Note note = new Note(
                String.valueOf(randomInt),
                "Title " + randomInt,
                getString(R.string.lorem_ipsum),
                System.currentTimeMillis()
        );
<<<<<<< HEAD
        notesArrayAdapter.add(note);
=======
        final Note createdNote = notesRepository.createNote(note);
        notesArrayAdapter.add(createdNote);
>>>>>>> efcda075c2a4068226b8c41a8e27829667057a1f
    }

    public interface FragmentListInterface {

        void onNoteSelected(final Note note);

    }

    private static class NoteAdapter extends ArrayAdapter<Note> {

        private final LayoutInflater layoutInflater;

        public NoteAdapter(final Context context) {
            super(context, 0);
            layoutInflater = LayoutInflater.from(getContext());
        }

        private static class ViewHolder {
            TextView titleTextView;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.d(TAG, "Position: " + position + "; convertView " + (convertView == null ? "== null" : "!= null"));
            final Note note = getItem(position);
            final View view;
            final ViewHolder viewHolder;
            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.element_note, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.titleTextView = view.findViewById(R.id.textViewNoteTitle);
                view.setTag(viewHolder);
            } else {
                view = convertView;
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.titleTextView.setText(note.getTitle());
            return view;
        }
    }
}
