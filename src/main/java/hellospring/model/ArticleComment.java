package hellospring.model;

import org.springframework.stereotype.Component;

/**
 * 文章留言实体
 * 
 * @author Dream Sky
 *
 */
@Component
public class ArticleComment extends Message {
	private long AComtID;
	private long ArticleID;

	public ArticleComment() {
		super();
	}

	public long getAComtID() {
		return AComtID;
	}

	public void setAComtID(long aComtID) {
		AComtID = aComtID;
	}

	public long getArticleID() {
		return ArticleID;
	}

	public void setArticleID(long articleID) {
		ArticleID = articleID;
	}
}
