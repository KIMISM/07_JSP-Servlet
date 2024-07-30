package org.example.ex04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request_redirect")
public class RequestRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        해당 요청은 내부에서 쓰이지 않으므로 무의미하다.
        req.setAttribute("username","홍길동");
        req.setAttribute("useraddress","서울");

//        response_redirect URL로 리다이렉트시킨다.
        resp.sendRedirect("response_redirect");
    }
}
