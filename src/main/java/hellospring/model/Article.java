package hellospring.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * 教程文章
 * 
 * @author Dream Sky
 *
 */
@Component
public class Article {
	private long ArticleID;
	private long AuthorID;
	private String AuthorNick;
	private String Title;
	private String Content;
	private String Summary;
	private long ThemeID;
	private String ThemeName;
	private String SavePath;
	private boolean HasAttachment;
	private Timestamp UpTime;
	private int PageView;

	public Article() {
		super();
	}

	public long getArticleID() {
		return ArticleID;
	}

	public void setArticleID(long articleID) {
		ArticleID = articleID;
	}

	public long getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(long authorID) {
		AuthorID = authorID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public long getThemeID() {
		return ThemeID;
	}

	public void setThemeID(long themeID) {
		ThemeID = themeID;
	}

	public String getSavePath() {
		return SavePath;
	}

	public void setSavePath(String savePath) {
		SavePath = savePath;
	}

	public boolean isHasAttachment() {
		return HasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		HasAttachment = hasAttachment;
	}

	public String getSummary() {
		return Summary;
	}

	public void setSummary(String summary) {
		Summary = summary;
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

	public String getThemeName() {
		return ThemeName;
	}

	public void setThemeName(String themeName) {
		ThemeName = themeName;
	}

	public String getAuthorNick() {
		return AuthorNick;
	}

	public void setAuthorNick(String authorNick) {
		AuthorNick = authorNick;
	}
}
