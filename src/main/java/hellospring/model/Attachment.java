package hellospring.model;

import org.springframework.stereotype.Component;

/**
 * 附件实体
 * 
 * @author Dream Sky
 *
 */
@Component
public class Attachment {
	private long AttID;
	private String AttPath;
	private String AttName;
	private int AttType;
	private String AttUpTime;
	private long AttArticleID;

	public Attachment() {
		super();
	}

	public long getAttID() {
		return AttID;
	}

	public void setAttID(long attID) {
		AttID = attID;
	}

	public String getAttPath() {
		return AttPath;
	}

	public void setAttPath(String attPath) {
		AttPath = attPath;
	}

	public String getAttName() {
		return AttName;
	}

	public void setAttName(String attName) {
		AttName = attName;
	}

	public int getAttType() {
		return AttType;
	}

	public void setAttType(int attType) {
		AttType = attType;
	}

	public String getAttUpTime() {
		return AttUpTime;
	}

	public void setAttUpTime(String attUpTime) {
		AttUpTime = attUpTime;
	}

	public long getAttArticleID() {
		return AttArticleID;
	}

	public void setAttArticleID(long attArticleID) {
		AttArticleID = attArticleID;
	}

}
