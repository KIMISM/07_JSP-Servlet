package org.example.ex05.domain;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;

//    설정에 있는 application scope를 sc에 할당해서 초기화 해준다
    @Override
    public void init(ServletConfig config) throws ServletException {
       sc = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       application scope에 속성 설정
        sc.setAttribute("scopeName", "alpplicationScope 값");

//        현재 세션을 가져오거나 존재하지 않으면 새로 생성
        HttpSession session = req.getSession();
//      session scope에 속성 설정
        session.setAttribute("scopeName", "sessionScope 값");

//        request scope에 속성 설정
        req.setAttribute("scopeName", "requestScope 값");
        Member member =  new Member("홍길동","hong");
        req.setAttribute("member",member);

//        scope.jsp 화면 포워딩
        req.getRequestDispatcher("scope.jsp").forward(req,resp);
    }
}
