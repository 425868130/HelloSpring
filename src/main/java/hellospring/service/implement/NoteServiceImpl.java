package hellospring.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import hellospring.model.Note;
import hellospring.service.interfaces.NoteService;
/**
 * 笔记业务实现
 * @author Dream Sky
 *
 */
@Service
public class NoteServiceImpl implements NoteService {

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteNote(String UserID, long... notesID) {
		// TODO Auto-generated method stub
		return false;
	}

}
