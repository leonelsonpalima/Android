package pe.area51.listcontent;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(
                R.layout.fragment_list,
                container,
                false);
        final NotesArrayAdapter noteArrayAdapter = new NotesArrayAdapter(
                getContext(),
                inflater
        );
        noteArrayAdapter.addAll(createTestNotes(100));
        listView = view.findViewById(R.id.listView);

        listView.setAdapter(noteArrayAdapter);

        return view;
    }

    private List<Note> createTestNotes(final int size) {
        final List<Note> notes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            final Note note = new Note(
                    "Title " + (i + 1),
                    "Content " + (i + 1)
            );
            notes.add(note);
        }
        return notes;
    }

    private static class NotesArrayAdapter extends ArrayAdapter<Note> {
        private final LayoutInflater layoutInflater;

        public NotesArrayAdapter(Context context, LayoutInflater layoutInflater) {
            super(context, 0);
            this.layoutInflater = layoutInflater;
        }

        @Override
        public View getView(int position,
                            @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            final Note note = getItem(position);
            final View view;
            if (convertView == null) {
                view = layoutInflater.inflate(
                        R.layout.element_note,
                        parent,
                        false
                );
            }else{
                view = convertView;
            }
            final TextView textViewNoteTitle = view.findViewById(R.id.textViewNoteTitle);
            textViewNoteTitle.setText(note.getTitle());
            return view;

        }
    }
}
