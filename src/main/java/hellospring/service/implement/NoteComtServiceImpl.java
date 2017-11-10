package hellospring.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import hellospring.model.NoteComment;
import hellospring.service.interfaces.NoteComtService;
/**
 * 笔记评论业务层实现
 * @author Dream Sky
 *
 */
@Service
public class NoteComtServiceImpl implements NoteComtService {

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
