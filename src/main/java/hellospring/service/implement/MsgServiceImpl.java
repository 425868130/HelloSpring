package hellospring.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import hellospring.model.Message;
import hellospring.service.interfaces.MsgService;
/**
 * 消息业务层实现
 * @author Dream Sky
 *
 */
@Service
public class MsgServiceImpl implements MsgService {

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
