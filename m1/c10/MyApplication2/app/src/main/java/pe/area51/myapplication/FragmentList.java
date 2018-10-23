package pe.area51.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

public class FragmentList extends Fragment {

    private NotesAdapter notesAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(
                R.layout.fragment_list,
                container,
                false
        );
        final ListView listView = view.findViewById(R.id.listView);
        notesAdapter = new NotesAdapter(getContext());
        listView.setAdapter(notesAdapter);
        return view;

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionCreateNote) {
            createNote();
            return true;
        }
        return false;
    }

    public void createNote() {

        final Random random = new Random();
        final int randomInt = random.nextInt();
        final Note note = new Note(
                randomInt,
                "Note Title" + randomInt,
                getString(R.string.lorem_ipsum),
                System.currentTimeMillis()
        );
        notesAdapter.add(note);

    }

    private final static class NotesAdapter extends ArrayAdapter<Note> {

        private final LayoutInflater layoutInflater;

        public NotesAdapter(Context context) {
            super(context, 0);
            layoutInflater = LayoutInflater.from(context);
        }

        private static class NoteViewHolder {
            private TextView textViewNoteTitle;
        }

        @NonNull
        @Override
        public View getView(int position,
                            @Nullable View convertView,
                            @NonNull ViewGroup parent) {

            final View view;
            final NoteViewHolder noteViewHolder;
            if (convertView == null) {
                view = layoutInflater.inflate(
                        R.layout.element_note,
                        parent,
                        false
                );
                noteViewHolder = new NoteViewHolder();
                noteViewHolder.textViewNoteTitle = view.findViewById(R.id.textViewNoteTitle);
                view.setTag(noteViewHolder);
            } else {
                view = convertView;
                noteViewHolder = (NoteViewHolder) view.getTag();
            }
            final Note note = getItem(position);
            noteViewHolder.textViewNoteTitle.setText(note.getTitle());
            return view;
        }
    }

}