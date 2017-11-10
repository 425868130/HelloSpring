package hellospring.service.implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hellospring.dao.interfaces.ArticleDao;
import hellospring.model.ArtTheme;
import hellospring.model.Article;
import hellospring.model.SimpleArticle;
import hellospring.service.interfaces.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	/* 教程分页大小 */
	private final static int PageSize = 8;

	@Override
	public Article FindByID(long articleID) {
		return articleDao.FindByID(articleID);
	}

	@Override
	public boolean CreateArticle(int UID, int ThemeID, String ArtTitle, String Summary, String Content) {
		return articleDao.CreateArticle(UID, ThemeID, ArtTitle, Summary, Content);
	}

	@Override
	public boolean DeleteArticle(long articleID) {
		// TODO Auto-generated method stub
		return articleDao.DeleteArticle(articleID);
	}

	@Override
	public List<Article> GetArticleList(int ThemeID, int PageIndex) {
		return articleDao.GetArticleList(ThemeID, PageIndex, PageSize);
	}

	@Override
	public boolean Articlemodify(int ArticleID, int ThemeID, String ArtTitle, String Summary, String Content) {
		// TODO Auto-generated method stub

		return articleDao.Articlemodify(ArticleID, ThemeID, ArtTitle, Summary, Content);
	}

	@Override
	public int PageSumOfArticle() {

		return articleDao.PageSumOfArticle(PageSize);
	}

	@Override
	public int PageSumByTheme(int ThemeID) {
		return articleDao.PageSumByTheme(ThemeID, PageSize);
	}

	@Override
	public List<ArtTheme> ArtThemeList() {
		return articleDao.ArtThemeList();
	}

	@Override
	public List<SimpleArticle> GetSimpleArtList(int ThemeID, int PageIndex) {
		return articleDao.GetSimpleArtList(ThemeID, PageIndex, PageSize);
	}

}
