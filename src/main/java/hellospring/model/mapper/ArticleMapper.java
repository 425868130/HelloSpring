package hellospring.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hellospring.model.Article;

/**
 * 教程映射
 * 
 * @author DreamSky
 *
 */
public class ArticleMapper implements RowMapper<Article> {
	@Override
	public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
		Article tempArt = new Article();
		tempArt.setArticleID(rs.getInt("ArticleID"));
		tempArt.setAuthorID(rs.getInt("AuthorID"));
		tempArt.setTitle(rs.getString("ArtTitle"));
		tempArt.setContent(rs.getString("Content"));
		tempArt.setSummary(rs.getString("Summary"));
		tempArt.setThemeID(rs.getInt("ThemeID"));
		tempArt.setThemeName(rs.getString("TName"));
		tempArt.setSavePath(rs.getString("SavePath"));
		tempArt.setHasAttachment(rs.getBoolean("HasAttachment"));
		tempArt.setUpTime(rs.getTimestamp("UpTime"));
		tempArt.setPageView(rs.getInt("PageView"));
		return tempArt;
	}

}
