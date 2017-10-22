package localThread.servlet;

import com.model.entity.Student;
import localThread.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SaveServlet", urlPatterns = "/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//=============================================
		//User user1 = new User();
		//user1.setName("tom");
		//
		//User user2 = new User();
		//user1.setName("jack");
		Student student1 = new Student();
		student1.setName("rose");
		Student student2 = new Student();
		student2.setName("mike");
		new UserService().ServiceSave(student1,student2);
	}

}
