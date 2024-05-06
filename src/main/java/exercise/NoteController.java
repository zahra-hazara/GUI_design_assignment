package exercise;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NoteController {
    @FXML
    private TextField titleField;
    @FXML
    private TextArea contentArea;
    @FXML
    private VBox notesContainer;

    private Notebook notebook;

    public NoteController() {
        notebook = new Notebook();
    }

    @FXML
    private void addNote() {
        String title = titleField.getText();
        String content = contentArea.getText();
        Note newNote = new Note(title, content);
        notebook.addNote(newNote);
        displayNotes();
        titleField.clear();
        contentArea.clear();
    }

    private void displayNotes() {
        notesContainer.getChildren().clear();
        for (Note note : notebook.getNotes()) {
            TextArea noteDisplay = new TextArea(note.getTitle() + "\n" + note.getContent());
            noteDisplay.setEditable(false);
            notesContainer.getChildren().add(noteDisplay);
        }
    }
}
