package pe.area51.notepad;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentContent extends Fragment {

    private final static String ARG_KEY_NOTE_TITLE = "noteTitle";
    private final static String ARG_KEY_NOTE_CONTENT = "noteContent";
    private final static String ARG_KEY_NOTE_CREATION_TIMESTAMP = "noteCreationTimestamp";


    private TextView textViewContent;

    private String noteTitle;
    private String notecontent;
    private long noteCreationTimestamp;

    public static FragmentContent newInstance(final Note note) {

        Bundle args = new Bundle();
        args.putString(ARG_KEY_NOTE_TITLE, note.getTitle());
        args.putString(ARG_KEY_NOTE_CONTENT, note.getContent());
        args.putLong(ARG_KEY_NOTE_CREATION_TIMESTAMP, note.getCreationTimestamp());
        FragmentContent fragment = new FragmentContent();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle arguments = getArguments();
        noteTitle = arguments.getString(ARG_KEY_NOTE_TITLE);
        notecontent = arguments.getString(ARG_KEY_NOTE_CONTENT);
        noteCreationTimestamp = arguments.getLong(ARG_KEY_NOTE_CREATION_TIMESTAMP);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(
                R.layout.fragment_content,
                container,
                false
        );
        textViewContent = view.findViewById(R.id.textViewContent);
        return view;


    }

    public void showNote(final Note note) {
        textViewContent.setText(note.getContent());
    }
}
