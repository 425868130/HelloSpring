package hellospring.service.interfaces;

import java.util.List;
import hellospring.model.ArticleComment;

/**
 * 教程文章留言业务接口
 * 
 * @author Dream Sky
 *
 */
public interface ArtComtService {
	/**
	 * 查找留言
	 * 
	 * @param CommentID
	 *            留言ID
	 * @return 返回留言实体
	 */
	ArticleComment FindComtById(long CommentID);

	/**
	 * 创建教程留言
	 * 
	 * @param SenderID
	 *            发送人ID (默认为Session中登录用户的ID)
	 * @param ReceiverID
	 *            接收人ID (教程作者的ID)
	 * @param CommtText
	 *            留言内容
	 * @param articleID
	 *            教程ID
	 * @return
	 */
	boolean CreateComment(int SenderID, int ReceiverID, int articleID, String CommtText);

	/**
	 * 删除留言
	 * 
	 * @param commentsID
	 *            留言ID列表
	 * @return 删除对应留言ID的留言,返回操作结果
	 */
	boolean DeleteComment(long commentsID);

	/**
	 * 查找教程文章的全部留言
	 * 
	 * @param articleID
	 *            教程文章ID
	 * @return 返回对应文章ID的留言列表
	 */
	List<ArticleComment> GetAtticleComments(long articleID);

	/**
	 * 删除文章的全部留言
	 * 
	 * @param articleID
	 *            文章ID
	 * @return 删除对应文章ID的全部留言，返回操作结果
	 */
	boolean DeleteCommtByArticleID(long articleID);
}
