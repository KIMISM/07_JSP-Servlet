package org.example.ex04.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_save")
public class CartSaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter out = resp.getWriter();

        String product = req.getParameter("product");

//        현재 세션을 가져오기
        HttpSession session = req.getSession();
//        속성을 가져올땐 object로 가져오기 때문에 캐스팅 필요
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");

        if (list == null) {
//            리스트가 null일 경우 리스트를 새로 생성해서 세션에 저장
            list = new ArrayList<String>();
            session.setAttribute("product", list);
        }
//        리스트에 새로운 상품 추가
        list.add(product);

        out.print("<html><body>");
        out.print("Product 추가!!<br>");
        out.print("<a href='session_product.jsp'>상품선택 페이지</a><br>");
//        뒤에 확장자(.jsp)가 없으면 servlet
        out.print("<a href='cart_view'>장바구니 보기</a>");
        out.print("</body></html>");
    }
}
