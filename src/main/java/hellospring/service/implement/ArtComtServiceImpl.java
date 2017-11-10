package hellospring.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hellospring.dao.interfaces.ArtCommentDao;
import hellospring.model.ArticleComment;
import hellospring.service.interfaces.ArtComtService;

/**
 * 教程留言业务层实现
 * 
 * @author Dream Sky
 *
 */
@Service
public class ArtComtServiceImpl implements ArtComtService {
	@Autowired
	ArtCommentDao artCommentDao;

	@Override
	public ArticleComment FindComtById(long CommentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CreateComment(int SenderID,int ReceiverID,int articleID,String CommtText) {
		return artCommentDao.CreateComment(SenderID, ReceiverID, articleID, CommtText);
	}

	@Override
	public boolean DeleteComment(long commentsID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ArticleComment> GetAtticleComments(long articleID) {
		return artCommentDao.GetAtticleComments(articleID);
	}

	@Override
	public boolean DeleteCommtByArticleID(long articleID) {
		// TODO Auto-generated method stub
		return false;
	}

}
