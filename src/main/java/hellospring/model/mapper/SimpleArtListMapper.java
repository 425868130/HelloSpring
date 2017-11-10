package hellospring.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import hellospring.model.SimpleArticle;

/*简单教程列表映射
 * */
public class SimpleArtListMapper implements RowMapper<List<SimpleArticle>> {

	@Override
	public List<SimpleArticle> mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<SimpleArticle> TempArtList = new ArrayList<>();
		do {
			SimpleArticle tempArt = new SimpleArticle();
			tempArt.setArticleID(rs.getInt("ArticleID"));
			tempArt.setTitle(rs.getString("ArtTitle"));
			tempArt.setSummary(rs.getString("Summary"));
			tempArt.setThemeID(rs.getInt("ThemeID"));
			tempArt.setThemeName(rs.getString("TName"));
			tempArt.setUpTime(rs.getTimestamp("UpTime"));
			tempArt.setPageView(rs.getInt("PageView"));
			TempArtList.add(tempArt);
		} while (rs.next());
		return TempArtList;
	}

}
