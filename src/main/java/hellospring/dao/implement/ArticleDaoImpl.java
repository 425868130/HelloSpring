package hellospring.dao.implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;
import hellospring.dao.interfaces.ArticleDao;
import hellospring.model.ArtTheme;
import hellospring.model.Article;
import hellospring.model.SimpleArticle;
import hellospring.model.mapper.ArtThemeListMapper;
import hellospring.model.mapper.ArticleMapper;
import hellospring.model.mapper.SimpleArtListMapper;

@Component
public class ArticleDaoImpl implements ArticleDao {
	@Autowired
	JdbcOperations jdbcOperations;

	@Override
	public Article FindByID(long articleID) {
		String sql = "{call P$GetArticleByID(?)}";
		String[] args = new String[] { String.valueOf(articleID) };
		return jdbcOperations.queryForObject(sql, args, new ArticleMapper());
	}

	@Override
	public boolean CreateArticle(int UID, int ThemeID, String ArtTitle, String Summary, String Content) {
		String sql = "{call P$CreateArticle(?,?,?,?,?)}";
		int rowCount = jdbcOperations.update(sql, UID, ThemeID, ArtTitle, Content, Summary);
		if (rowCount == 0)
			return false;
		return true;
	}

	@Override
	public boolean DeleteArticle(long articleID) {
		String sql = "{call P$DeleteArticle(?)}";
		int rowCount = jdbcOperations.update(sql, articleID);
		if (rowCount == 1)
			return true;
		return false;
	}

	/**
	 * 暂时弃用
	 */
	@Override
	public List<Article> GetArticleList(int ThemeID, int PageIndex, int pageSize) {
		return null;
	}

	@Override
	public boolean Articlemodify(int ArticleID, int ThemeID, String ArtTitle, String Summary, String Content) {
		String sql = "{call P$EditArticle(?,?,?,?,?)}";
		int rowCount = jdbcOperations.update(sql, ArticleID, ThemeID, ArtTitle, Summary, Content);
		if (rowCount == 1) {
			return true;
		}
		return false;
	}

	@Override
	public int PageSumOfArticle(int pageSize) {
		String sql = "{call P$PageSumOfArt(?)}";
		String[] args = new String[] { String.valueOf(pageSize) };
		int SumPage = jdbcOperations.queryForObject(sql, args, java.lang.Integer.class);
		// System.out.println("总页数:" + SumPage);
		return SumPage;
	}

	@Override
	public int PageSumByTheme(int ThemeID, int pageSize) {
		String sql = "{call P$PageSumByTheme(?,?)}";
		String[] args = new String[] { String.valueOf(ThemeID), String.valueOf(pageSize) };
		int SumPage = 0;
		try {
			SumPage = jdbcOperations.queryForObject(sql, args, java.lang.Integer.class);
		} catch (Exception e) {
		}
		// System.out.println("总页数:" + SumPage);
		return SumPage;
	}

	@Override
	public List<ArtTheme> ArtThemeList() {
		String sql = "select * from arttheme";
		return jdbcOperations.queryForObject(sql, new ArtThemeListMapper());
	}

	@Override
	public List<SimpleArticle> GetSimpleArtList(int ThemeID, int PageIndex, int pageSize) {
		String sql1 = "{call P$SimpleArtList(?,?)}";
		String sql2 = "{call P$ArtListByTheme(?,?,?)}";
		List<SimpleArticle> articleList = null;
		if (ThemeID == 0) {
			String[] args = new String[] { String.valueOf(PageIndex), String.valueOf(pageSize) };
			try {
				articleList = jdbcOperations.queryForObject(sql1, args, new SimpleArtListMapper());
			} catch (Exception e) {
			}
		} else {
			String[] args = new String[] { String.valueOf(ThemeID), String.valueOf(PageIndex),
					String.valueOf(pageSize) };
			try {
				articleList = jdbcOperations.queryForObject(sql2, args, new SimpleArtListMapper());
			} catch (Exception e) {
			}
		}
		return articleList;
	}

}
