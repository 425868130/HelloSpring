package hellospring.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import hellospring.model.Attachment;
import hellospring.service.interfaces.AttachmentService;
/**
 * 附件管理业务层实现
 * @author Dream Sky
 *
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

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
