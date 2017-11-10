package hellospring.dao.implement;

import java.util.List;

import org.springframework.stereotype.Component;

import hellospring.dao.interfaces.NoteCommentDao;
import hellospring.model.NoteComment;
@Component
public class NoteCommentDaoImpl implements NoteCommentDao {

	@Override
	public NoteComment FindComtById(long CommentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CreateComment(NoteComment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteComment(long commentsID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NoteComment> GetNoteComments(long noteID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean DeleteCommtByNoteID(long noteID) {
		// TODO Auto-generated method stub
		return false;
	}

}
