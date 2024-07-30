package org.example.ex04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//경로 설정
@WebServlet("/response_redirect")
public class ResponseRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        요청이 달라졌기 때문에 해당 값들은 null이 나온다. 이전 서블릿의 속성은 세션으로 저장해줘야한다.
        String username = (String) req.getAttribute("username");
        String useraddress = (String) req.getAttribute("useraddress");

        req.setAttribute("username", username);
        req.setAttribute("useraddress", useraddress);

        RequestDispatcher dis = req.getRequestDispatcher("/redirect_response.jsp");
        dis.forward(req, resp);
    }
}
