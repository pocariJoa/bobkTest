

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.book.bookDAO;
import com.hanul.book.bookDTO;

@WebServlet("/is.do")
public class InsertServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		//삽입하기
		
		request.setCharacterEncoding("utf-8");
		bookDTO dto = new bookDTO();
		dto.setBooktitle(request.getParameter("bookTitle"));//제목
		dto.setBookwriter(request.getParameter("bookWriter"));//저자
		dto.setBookisbn(request.getParameter("bookIsbn"));//isbn
		dto.setBookcompany(request.getParameter("bookCompany"));
		dto.setBookcost(Integer.parseInt(request.getParameter("bookCost")));
		dto.setBookqty(Integer.parseInt(request.getParameter("bookQty")));
		dto.setBookprice(Integer.parseInt(request.getParameter("bookCost"))*Integer.parseInt(request.getParameter("bookQty")));
		
		bookDAO dao = new bookDAO();
		int succ = dao.bookInsert(dto);
		
		response.setContentType("text/html; charset=utf-8"); //MIME Type
		PrintWriter out = response.getWriter();	//출력스트림
		
		if(succ > 0) {
			out.println("<script>alert('도서 등록 성공');</script>");
			out.println("<a href='bookMain.html'>도서 등록 화면으로 이동</a>");
			out.println("<br><br>");
			out.println("<a href='gals.do'>전체 도서 목록 보기</a>");
		}else {
			out.println("<script>alert('도서 등록 실패');</script>");
			out.println("<a href='bookMain.html'>도서 등록 화면으로 이동</a>");
			out.println("<br><br>");
			out.println("<a href='gals.do'>전체 도서 목록 보기</a>");
		}
	}

}
