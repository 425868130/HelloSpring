package hellospring.dao.interfaces;

import java.util.List;

import hellospring.model.Note;

/**
 * 用户学习笔记数据访问接口
 * 
 * @author Dream Sky
 */
public interface NoteDao {
	/**
	 * 获取单个笔记实体
	 * 
	 * @param NoteID
	 *            笔记ID
	 * @return 返回对应ID的笔记实体
	 */
	Note FindNoteByID(long NoteID);

	/**
	 * 获取用户的全部笔记
	 * 
	 * @param UserID
	 *            用户ID
	 * @return 返回指定用户ID的全部笔记
	 */
	List<Note> UserNotes(long UserID);

	/**
	 * 创建用户笔记
	 * 
	 * @param note
	 *            笔记实体
	 * @return 将对应的笔记实体添加进数据库
	 */
	boolean CreateNote(Note note);

	/**
	 * 删除笔记
	 * 
	 * @param notesID
	 *            笔记ID列表
	 * @return 删除数据库中对应ID列表的全部笔记
	 */
	boolean DeleteNote(long... notesID);

}
