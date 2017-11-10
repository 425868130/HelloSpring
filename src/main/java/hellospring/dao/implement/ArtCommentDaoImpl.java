package hellospring.dao.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

import hellospring.dao.interfaces.ArtCommentDao;
import hellospring.model.ArticleComment;
import hellospring.model.mapper.ArtCommtListMapper;

@Component
public class ArtCommentDaoImpl implements ArtCommentDao {
	@Autowired
	JdbcOperations jdbcOperations;

	@Override
	public ArticleComment FindComtById(long CommentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CreateComment(int SenderID, int ReceiverID, int articleID, String CommtText) {
		String sql = "{call P$CreateArtCmmt(?,?,?,?)}";
		int row = jdbcOperations.update(sql, String.valueOf(SenderID), String.valueOf(ReceiverID),
				String.valueOf(articleID), CommtText);
		if (row == 1)
			return true;
		return false;
	}

	@Override
	public boolean DeleteComment(long commentsID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ArticleComment> GetAtticleComments(long articleID) {
		String sql = "{call P$ArticleCmmts(?)}";

		String args[] = new String[] { String.valueOf(articleID) };
		List<ArticleComment> artCmmtList = null;
		try {
			artCmmtList = jdbcOperations.queryForObject(sql, args, new ArtCommtListMapper(jdbcOperations));
		} catch (Exception e) {
			// TODO: handle exception
		}

		return artCmmtList;
	}

	@Override
	public boolean DeleteCommtByArticleID(long articleID) {
		// TODO Auto-generated method stub
		return false;
	}

}
