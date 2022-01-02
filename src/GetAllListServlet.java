

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.book.bookDAO;
import com.hanul.book.bookDTO;

@WebServlet("/gals.do")
public class GetAllListServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// 도서 목록보기
		
		bookDAO dao = new bookDAO();
		ArrayList<bookDTO> list = dao.bookSearchAll();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<body>");
		out.println("<div align = 'center'> ");
		out.println("<h3>[전체 도서 보기]</h3>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>도서명</th>");
		out.println("<th>저자</th>");
		out.println("<th>ISBN</th>");
		out.println("<th>출판사</th>");
		out.println("<th>단가</th>");
		out.println("<th>수량</th>");
		out.println("<th>가격</th>");
		out.println("<th>삭제</th>");
		out.println("<th>삭제</th>");
		out.println("</tr>");
		
		if(list.size() == 0) {
			out.println("<tr align = 'center'>");
			out.println("<td colspan='8'>등록된 도서가 없습니다</td>");
			out.println("</tr>");
		}else {
			for (bookDTO dto : list) {
				out.println("<tr align = 'center'>");
				out.println("<td>" + dto.getBooktitle()+"</td>");
				out.println("<td>" + dto.getBookwriter()+"</td>");
				out.println("<td>" + dto.getBookisbn()+"</td>");
				out.println("<td>" + dto.getBookcompany()+"</td>");
				out.println("<td>" + dto.getBookcost()+"</td>");
				out.println("<td>" + dto.getBookqty()+"</td>");
				out.println("<td>" + dto.getBookprice()+"</td>");
				out.println("<td><a href='ds.do?bookIsbn="+dto.getBookisbn()+"'>삭제</a></td>");
				out.println("<td>");
				out.println("<input type='button' value='삭제' onclick='location.href=\"ds.do?bookIsbn=" + dto.getBookisbn() + "\"' />");
				out.println("</td>");
				out.println("</tr>");
			}
		}
		
		out.println("<tr align = 'center'>");
		out.println("<td colspan='8'>");
		out.println("<a href='bokMain.html'>메인화면</a>");
		out.println("&nbsp;&nbsp;&nbsp;");
		out.println("<input type='button' value='메인화면' onclick='location.href=\"bookMain.html\"'/>" );
		out.println("</td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		
	}

}
