package hellospring.model;

import java.sql.Timestamp;

/**
 * 消息实体
 * @author Dream Sky
 *
 */
public class Message {
	private long MsgID;
	private long SenderUID;
	private String SenderNick;
	private long ReceiverUID;
	private String ReceiverNick;
	private Timestamp MsgTime;
	private String MsgContent;
	private int MsgType;

	public Message() {
		super();
	}

	public long getMsgID() {
		return MsgID;
	}

	public void setMsgID(long msgID) {
		MsgID = msgID;
	}

	public long getSenderUID() {
		return SenderUID;
	}

	public void setSenderUID(long senderUID) {
		SenderUID = senderUID;
	}

	public long getReceiverUID() {
		return ReceiverUID;
	}

	public void setReceiverUID(long receiverUID) {
		ReceiverUID = receiverUID;
	}

	public Timestamp getMsgTime() {
		return MsgTime;
	}

	public void setMsgTime(Timestamp msgTime) {
		MsgTime = msgTime;
	}

	public String getMsgContent() {
		return MsgContent;
	}

	public void setMsgContent(String msgContent) {
		MsgContent = msgContent;
	}

	public int getMsgType() {
		return MsgType;
	}

	public void setMsgType(int msgType) {
		MsgType = msgType;
	}

	public String getSenderNick() {
		return SenderNick;
	}

	public void setSenderNick(String senderNick) {
		SenderNick = senderNick;
	}

	public String getReceiverNick() {
		return ReceiverNick;
	}

	public void setReceiverNick(String receiverNick) {
		ReceiverNick = receiverNick;
	}

}
