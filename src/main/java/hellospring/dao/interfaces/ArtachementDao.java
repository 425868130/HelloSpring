package hellospring.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import hellospring.model.Attachment;

/**
 * 附件数据访问对象接口
 * 
 * @author Dream Sky
 *
 */
@Component
public interface ArtachementDao {
	/**
	 * 查找附件
	 * 
	 * @param ArtachementID
	 *            附件ID
	 * @return 返回对应ID的附件实体
	 */
	Attachment FindByID(long ArtachementID);

	/**
	 * 获取指定教程的全部附件
	 * 
	 * @param ArticleID
	 *            教程ID
	 * @return 返回附件列表
	 */
	List<Attachment> GetArticleAttach(long ArticleID);
	/**
	 * 添加附件
	 * @param attachments附件实体列表
	 * @return 将附件实体列表中的所有附件添加到数据库，返回操作结果
	 */
	boolean AddAttachment(Attachment ...attachments);
	/**
	 * 删除指定的附件
	 * 
	 * @param AttachmentID
	 *            附件ID
	 * @return 返回操作结果
	 */
	boolean DeleteAttachment(long ...AttachmentID);

}
