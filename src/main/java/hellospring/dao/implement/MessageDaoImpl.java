package hellospring.dao.implement;

import java.util.List;

import org.springframework.stereotype.Component;

import hellospring.dao.interfaces.MessageDao;
import hellospring.model.Message;
@Component
public class MessageDaoImpl implements MessageDao {

	@Override
	public Message FindMsgByID(long MsgID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> GetUserMsgs(String UserID, int MsgType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CreateMsg(Message Msg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteMsg(long... msgsID) {
		// TODO Auto-generated method stub
		return false;
	}

}
