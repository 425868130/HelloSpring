package hellospring.service.interfaces;

/**
 * 文件处理接口
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface FileService {
	/**
	 * 文件上传
	 * 
	 * @param request
	 * @param response
	 * @return 返回上传文件相对路径
	 * @throws ServletException
	 * @throws IOException
	 */
	List<String> fileUpload(HttpServletRequest request, String FilePath);

	/**
	 * 文件删除
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	void fileDelete(String filePath) throws ServletException, IOException;
}
