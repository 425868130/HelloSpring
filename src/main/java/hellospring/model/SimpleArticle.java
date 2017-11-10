package hellospring.model;

import java.sql.Timestamp;

/**
 * 简单教程类，主要用于页面文章列表，除去了正文属性，提高网络传输效率
 * 
 * @author DreamSky
 *
 */
public class SimpleArticle {
	private long ArticleID;
	private String Title;
	private String Summary;
	private long ThemeID;
	private String ThemeName;
	private Timestamp UpTime;
	private int PageView;

	public SimpleArticle() {
		super();
	}

	public long getArticleID() {
		return ArticleID;
	}

	public void setArticleID(long articleID) {
		ArticleID = articleID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getSummary() {
		return Summary;
	}

	public void setSummary(String summary) {
		Summary = summary;
	}

	public long getThemeID() {
		return ThemeID;
	}

	public void setThemeID(long themeID) {
		ThemeID = themeID;
	}

	public String getThemeName() {
		return ThemeName;
	}

	public void setThemeName(String themeName) {
		ThemeName = themeName;
	}

	public Timestamp getUpTime() {
		return UpTime;
	}

	public void setUpTime(Timestamp upTime) {
		UpTime = upTime;
	}

	public int getPageView() {
		return PageView;
	}

	public void setPageView(int pageView) {
		PageView = pageView;
	}

}
