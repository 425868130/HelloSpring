package hellospring.dao.implement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;
import hellospring.dao.interfaces.UserDao;
import hellospring.model.User;

@Component
public class UserDaoImpl implements UserDao {
	/*
	 * 自动注入JdbcTemplate接口
	 */
	@Autowired
	private JdbcOperations jdbcOperations;

	@Override
	public User FindByCount(String UCount) {
		String sql = "{call P$findUserByCount(?)}";
		User findUser = null;
		try {
			findUser = jdbcOperations.queryForObject(sql, (rs, rowNum) -> {
				User user = new User();
				user.setUersID(rs.getInt("UID"));
				user.setUCount(UCount);
				user.setUNickName(rs.getString("UNickName"));
				user.setUSex(rs.getBoolean("USex"));
				user.setUImg(rs.getString("UImg"));
				user.setUEmail(rs.getString("UEmail"));
				user.setUSign(rs.getString("USigin"));
				user.setULevel(rs.getInt("ULevel"));
				user.setUType(rs.getInt("UType"));
				user.setUIsOnline(rs.getBoolean("UIsOnline"));
				user.setURegTime(rs.getTimestamp("URegTime"));
				user.setULoginTime(rs.getTimestamp("ULastloginTime"));
				return user;
			}, UCount);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return findUser;
	}

	@Override
	public User FindByUserID(long UserID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Logout(String UCount) {
		String sql = "call P$userLogout(?)";
		jdbcOperations.update(sql, UCount);
	}

	@Override
	public boolean UserReg(String UConut, String Pswd, String Email) {
		String sql = "{call P$userReg(?,?,?)}";
		int rowCount = 0;
		try {
			rowCount = jdbcOperations.update(sql, UConut, Pswd, Email);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (rowCount == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean Login(String UCount, String Pswd) {
		String sql = "{call P$loginCheck(?,?)}";
		String[] args = new String[] { UCount, Pswd };
		/* 调用存储过程,并获取一个返回值,第三个参数标识返回值的类型 */
		int res = jdbcOperations.queryForObject(sql, args, java.lang.Integer.class);
		if (res == 1)
			return true;
		return false;
	}

	@Override
	public boolean UserInfoChange(String UserCount, String NickName, int USex, String Sign, String Email) {
		String sql = "{call P$UpdateUserInfo(?,?,?,?,?)}";
		int rowCount = 0;
		try {
			rowCount = jdbcOperations.update(sql, UserCount, USex, NickName, Sign, Email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rowCount == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean ChangePswd(String UCount, String NewPswd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteUser(long UserID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> GetAllCommUser(int UserType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean LevelUp(long UserID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ChangeUserType(long UserID, int UserType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateUserImg(String Ucount, String ImgPath) {
		String sql = "{call P$UpdateUserImg(?,?)}";
		int rowCount = 0;
		try {
			rowCount = jdbcOperations.update(sql, Ucount, ImgPath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (rowCount == 1) {
			return true;
		}
		return false;
	}

}
