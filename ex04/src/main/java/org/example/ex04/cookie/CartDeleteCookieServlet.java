package org.example.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_delete_cookie")
public class CartDeleteCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

//        기존 쿠키 얻기
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
//                쿠키의 유효기간을 1초로 설정해서 사라지게 만든다.
                c.setMaxAge(1);
                response.addCookie(c);
            }
        }
        out.println("장바구니 비었음<br>");
        out.println("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.println("</body></html>");
    }
}
