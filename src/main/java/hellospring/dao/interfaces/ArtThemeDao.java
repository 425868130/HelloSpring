package hellospring.dao.interfaces;

import java.util.List;

import hellospring.model.ArtTheme;

/**
 * 教程主题数据访问接口
 * 
 * @author Dream Sky
 *
 */
public interface ArtThemeDao {
	/**
	 * 查找主题实体
	 * 
	 * @param ThemeID
	 *            主题ID
	 * @return 返回对应主题ID的主题实体
	 */
	ArtTheme FindThemeByID(long ThemeID);

	/**
	 * 获取全部主题列表
	 * 
	 * @return 返回全部主题列表
	 */
	List<ArtTheme> GetAllTheme();

	/**
	 * 创建主题
	 * 
	 * @param CreaterID
	 *            创建人ID
	 * @param themeName
	 *            主题名称
	 * @return
	 */
	boolean AddTheme(int CreaterID, String themeName);

	/**
	 * 修改主题
	 * 
	 * @param themeID
	 *            要修改的主题ID
	 * @param themeName
	 *            主题名称
	 * @return
	 */
	boolean UpdateTheme(int themeID, String themeName);

	/**
	 * 删除主题
	 * 
	 * @param themesID
	 *            主题ID列表
	 * @return 删除所有主题ID对应的主题记录，返回操作结果
	 */
	boolean DeleteTheme(long themesID);
}
