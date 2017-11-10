package hellospring.model;

import org.springframework.stereotype.Component;

/**
 * 学习笔记评论
 * 
 * @author Dream Sky
 *
 */
@Component
public class NoteComment extends Message {
	private long NComtID;
	private long NoteID;

	public NoteComment() {
		super();
	}

	public long getNComtID() {
		return NComtID;
	}

	public void setNComtID(long nComtID) {
		NComtID = nComtID;
	}

	public long getNoteID() {
		return NoteID;
	}

	public void setNoteID(long noteID) {
		NoteID = noteID;
	}

}
