package hellospring.model;

import org.springframework.stereotype.Component;

/**
 * 用户学习笔记实体
 * 
 * @author Dream Sky
 *
 */
@Component
public class Note {
	private long NOteID;
	private long UserID;
	private String NTime;
	private String NTitle;
	private String NContent;

	public Note() {
	}

	public long getNOteID() {
		return NOteID;
	}

	public void setNOteID(long nOteID) {
		NOteID = nOteID;
	}

	public long getUserID() {
		return UserID;
	}

	public void setUserID(long userID) {
		UserID = userID;
	}

	public String getNTime() {
		return NTime;
	}

	public void setNTime(String nTime) {
		NTime = nTime;
	}

	public String getNTitle() {
		return NTitle;
	}

	public void setNTitle(String nTitle) {
		NTitle = nTitle;
	}

	public String getNContent() {
		return NContent;
	}

	public void setNContent(String nContent) {
		NContent = nContent;
	}

}
