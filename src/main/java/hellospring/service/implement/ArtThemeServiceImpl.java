package hellospring.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hellospring.dao.interfaces.ArtThemeDao;
import hellospring.model.ArtTheme;
import hellospring.service.interfaces.ArtThemeService;

/**
 * 教程主题管理业务层实现
 * 
 * @author Dream Sky
 *
 */
@Service
public class ArtThemeServiceImpl implements ArtThemeService {
	@Autowired
	ArtThemeDao artThemeDao;

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

		return artThemeDao.DeleteTheme(themesID);
	}

	@Override
	public boolean AddTheme(int CreaterID, String themeName) {
		// TODO Auto-generated method stub
		return artThemeDao.AddTheme(CreaterID, themeName);
	}

	@Override
	public boolean UpdateTheme(int themeID, String themeName) {
		// TODO Auto-generated method stub
		return artThemeDao.UpdateTheme(themeID, themeName);
	}

}
