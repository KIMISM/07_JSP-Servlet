package org.example.ex04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        속성 설정
        req.setAttribute("username","홍길동");
        req.setAttribute("useraddress","서울");

//      forward
//      reponse.jsp로 요청을 전달할 RequestDispatcher를 가져온다
        RequestDispatcher dis = req.getRequestDispatcher("/response.jsp");
//        request와 response를 포워딩시킨다.
        dis.forward(req,resp);
    }
}
