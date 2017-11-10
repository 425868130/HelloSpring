package hellospring.dao.interfaces;

import java.util.List;

import hellospring.model.Message;

/**
 * 消息数据访问接口
 * 
 * @author Dream Sky
 *
 */
public interface MessageDao {
	/**
	 * 获取单个消息实体
	 * 
	 * @param MsgID
	 *            消息ID
	 * @return 返回消息实体
	 */
	Message FindMsgByID(long MsgID);

	/**
	 * 获取指定用户的全部消息
	 * 
	 * @param UserID
	 *            用户ID
	 * @param MsgType
	 *            消息类型
	 * @return 返回指定用户的指定类型的消息列表，若MsgType为0则返回所有类型的消息
	 */
	List<Message> GetUserMsgs(String UserID, int MsgType);

	/**
	 * 创建一条消息
	 * 
	 * @param Msg
	 *            消息实体
	 * @return 返回操作结果
	 */
	boolean CreateMsg(Message Msg);

	/**
	 * 删除消息
	 * 
	 * @param msgsID
	 *            消息ID列表
	 * @return 删除给定消息ID列表的消息，返回操作结果
	 */
	boolean DeleteMsg(long... msgsID);
}
