package hellospring.service.interfaces;

import java.util.List;

import hellospring.model.NoteComment;

/**
 * 笔记评论业务层
 * @author Dream Sky
 *
 */
public interface NoteComtService {
	/**
	 * 查找评论
	 * 
	 * @param CommentID
	 *            评论ID
	 * @return 返回评论实体
	 */
	NoteComment FindComtById(long CommentID);

	/**
	 * 创建笔记评论
	 * 
	 * @param comment
	 *            评论实体
	 * @return
	 */
	boolean CreateComment(NoteComment comment);

	/**
	 * 删除留言
	 * 
	 * @param commentsID
	 *            评论ID列表
	 * @return 删除对应笔记ID的评论,返回操作结果
	 */
	boolean DeleteComment(long commentsID);

	/**
	 * 查找笔记的全部评论
	 * 
	 * @param noteID
	 *            笔记ID
	 * @return 返回对应笔记ID的评论列表
	 */
	List<NoteComment> GetNoteComments(long noteID);

	/**
	 * 删除笔记的全部评论
	 * 
	 * @param noteID
	 *            笔记ID
	 * @return 删除对应笔记ID的全部评论，返回操作结果
	 */
	boolean DeleteCommtByNoteID(long noteID);
}
