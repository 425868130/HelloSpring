package hellospring.dao.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

import hellospring.dao.interfaces.ArtThemeDao;
import hellospring.model.ArtTheme;

@Component
public class ArtThemeDaoImpl implements ArtThemeDao {
	@Autowired
	JdbcOperations jdbcOperations;

	@Override
	public ArtTheme FindThemeByID(long ThemeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArtTheme> GetAllTheme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean DeleteTheme(long themesID) {
		String sql = "{call P$DeleteTheme(?)}";
		int rowNum = jdbcOperations.update(sql, String.valueOf(themesID));
		if (rowNum != 0)
			return true;
		return false;
	}

	@Override
	public boolean AddTheme(int CreaterID, String themeName) {
		String sql = "{call P$CreateTheme(?,?)}";
		System.out.println(themeName + "dao");
		try {
			if (jdbcOperations.update(sql, CreaterID, themeName) == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean UpdateTheme(int themeID, String themeName) {
		String sql = "{call P$EditTheme(?,?)}";
		try {
			if (jdbcOperations.update(sql, themeID, themeName) == 1)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
