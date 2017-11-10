package hellospring.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import hellospring.model.ArticleComment;

/*教程留言映射*/
public class ArtCommtListMapper implements RowMapper<List<ArticleComment>> {
	JdbcOperations jdbcOperations;

	public ArtCommtListMapper(JdbcOperations jdbcOps) {
		jdbcOperations = jdbcOps;
	}

	@Override
	public List<ArticleComment> mapRow(ResultSet rs, int rowNum) throws SQLException {
		String sql = "{call P$findNickbyUID(?)}";
		List<ArticleComment> artCmmtList = new ArrayList<>();
		do {
			ArticleComment tempCommt = new ArticleComment();
			tempCommt.setAComtID(rs.getInt("ArtComtID"));
			tempCommt.setArticleID(rs.getInt("ArticleID"));
			tempCommt.setSenderUID(rs.getInt("Sender"));
			/* 获取留言用户昵称 */
			String args[] = new String[] { String.valueOf(rs.getInt("Sender")) };
			String Nick = jdbcOperations.queryForObject(sql, args, java.lang.String.class);
			tempCommt.setSenderNick(Nick);
			tempCommt.setMsgContent(rs.getString("MsgContent"));
			tempCommt.setMsgTime(rs.getTimestamp("MsgTime"));
			tempCommt.setMsgID(rs.getInt("MsgID"));
			tempCommt.setReceiverUID(rs.getInt("Recevier"));
			artCmmtList.add(tempCommt);
		} while (rs.next());
		return artCmmtList;
	}

}
