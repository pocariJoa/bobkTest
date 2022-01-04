

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.book.bookDAO;

@WebServlet("/ds.do")
public class DeleteServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// 삭제하기
		
		request.setCharacterEncoding("utf-8");
		String bookIsbn = request.getParameter("bookIsbn");
		
		bookDAO dao = new bookDAO();
		int succ = dao.bookDelete(bookIsbn);
		
		response.setContentType("text/html; charset=utf-8"); //MIME Type
		PrintWriter out = response.getWriter();	//출력스트림
		if (succ > 0) {
			out.println("<script>alert('삭제 성공');</script>");
			out.println("<a href='bookMain.html'>메인화면</a>");
			out.println("<br><br>");
			out.println("<a href='gals.do'>전체회원목록</a>");
		} else {
			out.println("<script>alert('삭제 실패');</script>");
			out.println("<a href='bookMain.html'>메인화면</a>");
			out.println("<br><br>");
			out.println("<a href='gals.do'>전체회원목록</a>");
		}//if
		
	}

}
