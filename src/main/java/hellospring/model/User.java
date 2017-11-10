package hellospring.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
/**
 * 用户实体
 * @author Dream Sky
 *
 */
@Component
public class User {
	private long UersID;
	private String UCount;
	private String UNickName;
	private boolean USex;
	private String UPswd;
	private String UImg;
	private String UEmail;
	private String USign;
	private int ULevel;
	private int UType;
	private boolean UIsOnline;
	private Timestamp URegTime;
	private Timestamp ULoginTime;
	
	public User() {
		super();
	}

	public long getUersID() {
		return UersID;
	}

	public void setUersID(long uersID) {
		UersID = uersID;
	}

	public String getUCount() {
		return UCount;
	}

	public void setUCount(String uCount) {
		UCount = uCount;
	}

	public String getUNickName() {
		return UNickName;
	}

	public void setUNickName(String uNickName) {
		UNickName = uNickName;
	}

	public boolean getUSex() {
		return USex;
	}

	public void setUSex(boolean uSex) {
		USex = uSex;
	}

	public String getUPswd() {
		return UPswd;
	}

	public void setUPswd(String uPswd) {
		UPswd = uPswd;
	}

	public String getUImg() {
		return UImg;
	}

	public void setUImg(String uImg) {
		UImg = uImg;
	}

	public String getUEmail() {
		return UEmail;
	}

	public void setUEmail(String uEmail) {
		UEmail = uEmail;
	}

	public String getUSign() {
		return USign;
	}

	public void setUSign(String uSign) {
		USign = uSign;
	}

	public int getULevel() {
		return ULevel;
	}

	public void setULevel(int uLevel) {
		ULevel = uLevel;
	}

	public int getUType() {
		return UType;
	}

	public void setUType(int uType) {
		UType = uType;
	}

	public boolean isUIsOnline() {
		return UIsOnline;
	}

	public void setUIsOnline(boolean uIsOnline) {
		UIsOnline = uIsOnline;
	}

	public Timestamp getURegTime() {
		return URegTime;
	}

	public void setURegTime(Timestamp timestamp) {
		URegTime = timestamp;
	}

	public Timestamp getULoginTime() {
		return ULoginTime;
	}

	public void setULoginTime(Timestamp uLoginTime) {
		ULoginTime = uLoginTime;
	}
	
	
}
