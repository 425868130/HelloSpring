package hellospring.service.implement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import hellospring.service.interfaces.FileService;

/**
 * 文件处理实现类
 * 
 * @author DreamSky
 *
 */
@Service
public class FileServiceImpl implements FileService {
	public final static String ContextPath = "/HelloSpring";

	/**
	 * 上传数据及保存文件
	 */
	@Override
	public List<String> fileUpload(HttpServletRequest request, String FilePath) {
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = request.getServletContext().getRealPath(FilePath);
		File file = new File(savePath);
		if (!file.exists() && !file.isDirectory()) {
			//System.out.println("目录或文件不存在！" + file.getAbsolutePath());
			/*目录不存在则创建目录*/
			file.mkdirs();
		}
		// 返回的文件相对路径
		List<String> filesUrls = new ArrayList<>();
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// 2、创建一个文件上传解析器
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			// 解决上传文件名的中文乱码
			fileUpload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				return null;
			}
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = fileUpload.parseRequest(request);
			for (FileItem item : list) {
				// 如果fileitem中封装的是普通输入项的数据
				if (item.isFormField()) {
					String name = item.getFieldName();
					// 解决普通输入项的数据的中文乱码问题
					String value = item.getString("UTF-8");
					String value1 = new String(name.getBytes("iso8859-1"), "UTF-8");
					System.out.println(name + "  " + value);
					System.out.println(name + "  " + value1);
				} else {
					// 如果fileitem中封装的是上传文件，得到上传的文件名称，
					String fileName = item.getName();
					System.out.println(fileName);
					if (fileName == null || fileName.trim().equals("")) {
						continue;
					}
					// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
					// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
					// 获取item中的上传文件的输入流
					InputStream is = item.getInputStream();
					// 创建一个文件输出流
					FileOutputStream fos = new FileOutputStream(savePath + File.separator + fileName);
					// 创建一个缓冲区
					byte buffer[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int length = 0;
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while ((length = is.read(buffer)) > 0) {
						// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\"
						// + filename)当中
						fos.write(buffer, 0, length);
					}
					/* 构造相对路径 */
					filesUrls.add(ContextPath + FilePath + fileName);
					// 关闭输入流
					is.close();
					// 关闭输出流
					fos.close();
					// 删除处理文件上传时生成的临时文件
					item.delete();
				}
			}
		} catch (org.apache.commons.fileupload.FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filesUrls;
	}

	@Override
	public void fileDelete(String filePath) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
