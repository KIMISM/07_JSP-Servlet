package org.example.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.example.ex05.dto.LoginDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        getParameter 내에 있는 이름은 input의 name과 같은지 확인할 것
        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");

        LoginDTO logindto = new LoginDTO(userid, passwd);

//        위에서 만들어진 변수 정보를 request내에 세팅한다
        request.setAttribute("userid", userid);
        request.setAttribute("passwd", passwd);
        request.setAttribute("login", logindto);

//        설정한 request를 login.jsp로 보내서 화면을 띄워준다
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}