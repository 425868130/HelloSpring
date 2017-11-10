package hellospring.dao.implement;

import java.util.List;

import org.springframework.stereotype.Component;

import hellospring.dao.interfaces.ArtachementDao;
import hellospring.model.Attachment;
@Component
public class ArtchementDaoImpl implements ArtachementDao {

	@Override
	public Attachment FindByID(long ArtachementID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attachment> GetArticleAttach(long ArticleID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean AddAttachment(Attachment... attachments) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteAttachment(long... AttachmentID) {
		// TODO Auto-generated method stub
		return false;
	}

}
