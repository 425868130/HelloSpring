package hellospring.dao.interfaces;

import java.util.List;
import hellospring.model.User;

/**
 * 用户数据访问接口
 * 
 * @author Dream Sky
 *
 */
public interface UserDao {
	/**
	 * 用户查找
	 * 
	 * @param UCount
	 *            用户账号
	 * @return 返回对应用户账号的用户实体
	 */
	User FindByCount(String UCount);

	/**
	 * 通过用户ID查找用户实体
	 * 
	 * @param UserID
	 *            用户ID
	 * @return
	 */
	User FindByUserID(long UserID);

	/**
	 * 用户登录
	 * 
	 * @param UCount
	 *            用户账号
	 * @param Pswd
	 *            用户密码
	 * @return 返回登录状态
	 */
	boolean Login(String UCount, String Pswd);

	/**
	 * 用户注销
	 * 
	 * @param UCount
	 *            用户账号
	 */
	void Logout(String UCount);

	/**
	 * 用户注册
	 * 
	 * @param UConut
	 *            用户账号
	 * @param Pswd
	 *            用户密码
	 * @param Email
	 *            用户邮箱
	 * @return 返回注册结果
	 */

	boolean UserReg(String UConut, String Pswd, String Email);

	/**
	 * 用户基本信息修改
	 * 
	 * @param UserCount
	 *            用户账号
	 * @param NickName
	 *            新昵称
	 * @param USex
	 *            新性别
	 * @param Sign
	 *            新签名
	 * @param Email
	 *            新Email
	 * @return 根据给定的新用户信息修改对应的用户数据
	 */
	boolean UserInfoChange(String UserCount, String NickName, int USex, String Sign, String Email);

	/**
	 * 密码修改
	 * 
	 * @param UCount
	 *            用户账户
	 * @param NewPswd
	 *            新密码
	 * @return
	 */
	boolean ChangePswd(String UCount, String NewPswd);

	/**
	 * 删除用户
	 * 
	 * @param UserID
	 *            用户ID
	 * @return 根据指定用户id删除用户记录
	 */
	boolean DeleteUser(long UserID);

	/**
	 * 获取全部指定类型用户
	 * 
	 * @param UserType
	 *            用户类型代号
	 * @return 返回用户实体列表
	 */
	List<User> GetAllCommUser(int UserType);

	/**
	 * 用户等级提升
	 * 
	 * @param UserID
	 * @return 将对应UserID的用户Level属性加1，返回操作结果
	 */
	boolean LevelUp(long UserID);

	/**
	 * 修改用户类型
	 * 
	 * @param UserID
	 *            用户ID
	 * @param UserType
	 *            用户类型
	 * @return 修改指定UserID的用户类型，返回操作结果
	 */
	boolean ChangeUserType(long UserID, int UserType);

	/**
	 * 修改用户头像
	 * 
	 * @param Ucount
	 *            用户账户
	 * @param ImgPath
	 *            头像路径
	 * @return
	 */
	boolean UpdateUserImg(String Ucount, String ImgPath);
}
