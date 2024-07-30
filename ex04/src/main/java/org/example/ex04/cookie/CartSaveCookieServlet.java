package org.example.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_save_cookie")
public class CartSaveCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String product = req.getParameter("product");

        Cookie[] cookies = req.getCookies();
        Cookie c = null;
        if (cookies != null || cookies.length > 0) {
            c = new Cookie("product", product);
        }else{
            c = new Cookie("product" + (cookies.length+1), product);
        }
//        c.setMaxAge(60*60);
        resp.addCookie(c);

        out.print("<html><body>");
        out.print("Product 추가!!<br>");
        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_view_cookie'>장바구니 보기</a><br>");
        out.print("</body></html>");

    }
}
