package hellospring.dao.implement;

import java.util.List;
import org.springframework.stereotype.Component;
import hellospring.dao.interfaces.NoteDao;
import hellospring.model.Note;

@Component
public class NoteDaoImpl implements NoteDao {

	@Override
	public Note FindNoteByID(long NoteID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> UserNotes(long UserID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CreateNote(Note note) {
		//String sql = "{call P$CreateNote(?,?,?)}";

		return false;
	}

	@Override
	public boolean DeleteNote(long... notesID) {
		// TODO Auto-generated method stub
		return false;
	}

}
