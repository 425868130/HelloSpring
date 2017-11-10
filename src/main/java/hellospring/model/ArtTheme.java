package hellospring.model;

import java.sql.Timestamp;

/**
 * 教程主题实体
 * 
 * @author Dream Sky
 *
 */
public class ArtTheme {
	private long ThemeID;
	private String TName;
	private Timestamp Times;
	private long UserID;

	public ArtTheme() {
		super();
	}

	public long getThemeID() {
		return ThemeID;
	}

	public void setThemeID(long themeID) {
		ThemeID = themeID;
	}

	public String getTName() {
		return TName;
	}

	public void setTName(String tName) {
		TName = tName;
	}

	public Timestamp getTimes() {
		return Times;
	}

	public void setTimes(Timestamp times) {
		Times = times;
	}

	public long getUserID() {
		return UserID;
	}

	public void setUserID(long userID) {
		UserID = userID;
	}

}
