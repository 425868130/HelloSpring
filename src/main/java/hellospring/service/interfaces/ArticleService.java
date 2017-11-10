package hellospring.service.interfaces;

import java.util.List;
import hellospring.model.ArtTheme;
import hellospring.model.Article;
import hellospring.model.SimpleArticle;

/**
 * 教程文章业务层接口
 * 
 * @author Dream Sky
 *
 */
public interface ArticleService {
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
	 * @return 返回操作结果
	 */
	boolean DeleteArticle(long articleID);

	/**
	 * 获取完整教程列表
	 * 
	 * @param ThemeID
	 *            教程主题ID
	 * @param PageIndex
	 *            页码
	 * @return 返回对应主题下的页码为PageIndex的全部教程,若主题ID为0则返回全部教程
	 */
	List<Article> GetArticleList(int ThemeID, int PageIndex);

	/**
	 * 获取简单教程列表
	 * 
	 * @param ThemeID
	 *            教程主题ID
	 * @param PageIndex
	 *            要获取的页码
	 * @return 返回按主题分类时对应页码的全部简单教程信息，若ThemeID为0则不分类
	 */
	List<SimpleArticle> GetSimpleArtList(int ThemeID, int PageIndex);

	/**
	 * 首页教程总页码
	 * 
	 * @return 返回总页码
	 */
	int PageSumOfArticle();

	/**
	 * 按主题分页下的总页数
	 * 
	 * @param ThemeID
	 *            主体id
	 * @return 返回总页数
	 */
	int PageSumByTheme(int ThemeID);

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
	 * 获取教程主题列表
	 * 
	 * @return
	 */
	List<ArtTheme> ArtThemeList();
}
