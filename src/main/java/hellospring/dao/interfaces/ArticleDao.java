package hellospring.dao.interfaces;

import java.util.List;

import hellospring.model.ArtTheme;
import hellospring.model.Article;
import hellospring.model.SimpleArticle;

/**
 * 教程文章数据访问对象接口
 * 
 * @author Dream Sky
 *
 */
public interface ArticleDao {
	/**
	 * 获取单个教程实体
	 * 
	 * @param articleID
	 *            教程ID
	 * @return 返回指定教程ID的教程实体
	 */
	Article FindByID(long articleID);

	/**
	 * 新建教程文章
	 * 
	 * @param UID
	 *            创建人ID
	 * @param ThemeID
	 *            教程所属主题ID
	 * @param ArtTitle
	 *            教程标题
	 * @param Summary
	 *            教程摘要
	 * @param Content
	 *            教程内容
	 * @return 返回创建操作结果
	 */
	boolean CreateArticle(int UID, int ThemeID, String ArtTitle, String Summary, String Content);

	/**
	 * 教程删除
	 * 
	 * @param articleID
	 *            教程ID
	 * @return 根据教程ID删除指定的教程记录，返回操作结果
	 */
	boolean DeleteArticle(long articleID);

	/**
	 * 获取教程列表
	 * 
	 * @param ThemeID
	 *            教程主题ID
	 * @param pageSize
	 *            每页教程数量
	 * @return 返回对应主题下的全部教程,若主题ID为0则返回全部教程
	 */
	List<Article> GetArticleList(int ThemeID, int PageIndex, int pageSize);

	/**
	 * 获取简单教程列表
	 * 
	 * @param ThemeID
	 *            教程主题ID
	 * @param PageIndex
	 *            要获取的页码
	 * @param pageSize
	 *            每页教程数量
	 * @return 返回按主题分类时对应页码的全部简单教程信息，若ThemeID为0则不分类
	 */
	List<SimpleArticle> GetSimpleArtList(int ThemeID, int PageIndex, int pageSize);

	/**
	 * 教程修改
	 * 
	 * @param ArticleID
	 *            教程ID
	 * @param ThemeID
	 *            教程所属主题ID
	 * @param ArtTitle
	 *            教程标题
	 * @param Summary
	 *            教程摘要
	 * @param Content
	 *            教程内容
	 * @return 返回创建操作结果
	 */
	boolean Articlemodify(int ArticleID, int ThemeID, String ArtTitle, String Summary, String Content);

	/**
	 * 返回主页教程 页码总数
	 * 
	 * @param pageSize
	 *            每页教程数目
	 * @return 返回教程页码总数
	 */
	int PageSumOfArticle(int pageSize);

	/**
	 * 按主题分页下的总页数
	 * 
	 * @param pageSize
	 *            每页教程数
	 * @param ThemeID
	 *            主体id
	 * @return 返回总页数
	 */
	int PageSumByTheme(int ThemeID, int pageSize);

	/**
	 * 获取教程主题列表
	 * 
	 * @return
	 */
	List<ArtTheme> ArtThemeList();
}
