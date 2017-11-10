package hellospring.service.implement;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hellospring.dao.interfaces.UserDao;
import hellospring.model.User;
import hellospring.service.interfaces.UserService;

/**
 * 用户业务实现
 * 
 * @author Dream Sky
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	private final static String UserSession = "User";

	@Override
	public User findByCount(String UCount) {
		return userDao.FindByCount(UCount);
	}

	@Override
	public boolean Login(String UCount, String Pswd, HttpSession httpSession) {
		if (userDao.Login(UCount, Pswd)) {
			/* 登录成功设置Session */
			httpSession.setAttribute(UserSession, findByCount(UCount));
			return true;
		}
		return false;
	}

	@Override
	public void Logout(HttpSession httpSession) {
		// TODO Auto-generated method stub
		User loginUser = (User) httpSession.getAttribute("User");
		if (loginUser == null)
			return;
		userDao.Logout(loginUser.getUCount());
		httpSession.setAttribute("User", null);
		httpSession.invalidate();
	}

	@Override
	public boolean UserReg(String UConut, String Pswd, String Email) {
		return userDao.UserReg(UConut, Pswd, Email);
	}

	@Override
	public boolean UserInfoChange(String UserCount, String NickName, int USex, String Sign, String Email) {
		return userDao.UserInfoChange(UserCount, NickName, USex, Sign, Email);
	}

	@Override
	public boolean ChangePswd(String UCount, String NewPswd) {
		// TODO Auto-generated method stub
		/* 如果新旧密码相同拒绝修改 */
		if (findByCount(UCount).getUPswd().equals(NewPswd)) {
			return false;
		}
		return userDao.ChangePswd(UCount, NewPswd);
	}

	@Override
	public boolean DeleteUser(long UserID) {
		// TODO Auto-generated method stub
		return userDao.DeleteUser(UserID);
	}

	@Override
	public List<User> GetAllCommUser(int UserType) {
		// TODO Auto-generated method stub
		return userDao.GetAllCommUser(UserType);
	}

	@Override
	public boolean LevelUp(long UserID) {
		// TODO Auto-generated method stub
		return userDao.LevelUp(UserID);
	}

	@Override
	public boolean ChangeUserType(long UserID, int UserType) {
		// TODO Auto-generated method stub
		return userDao.ChangeUserType(UserID, UserType);
	}

	@Override
	public boolean UpdateUserImg(String Ucount, String ImgPath) {
		// TODO Auto-generated method stub
		return userDao.UpdateUserImg(Ucount, ImgPath);
	}

}
