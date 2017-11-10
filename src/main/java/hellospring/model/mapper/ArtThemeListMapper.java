package hellospring.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import hellospring.model.ArtTheme;

/**
 * 教程主题列表映射
 * 
 * @author DreamSky
 *
 */
public class ArtThemeListMapper implements RowMapper<List<ArtTheme>> {

	@Override
	public List<ArtTheme> mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<ArtTheme> themeList = new ArrayList<>();
		do {
			ArtTheme TempTheme = new ArtTheme();
			TempTheme.setThemeID(rs.getInt("ThemeID"));
			TempTheme.setTName(rs.getString("TName"));
			TempTheme.setTimes(rs.getTimestamp("Createtime"));
			TempTheme.setUserID(rs.getInt("CreateUID"));
			themeList.add(TempTheme);
		} while (rs.next());
		return themeList;
	}

}
