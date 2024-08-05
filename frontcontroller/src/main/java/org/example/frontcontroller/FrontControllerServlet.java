package org.example.frontcontroller;

import org.example.frontcontroller.command.Command;
import org.example.frontcontroller.controller.HomeController;
import org.example.frontcontroller.controller.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//경로 지정방법은 두가지가 있다 1)디렉토리 기반, 2)확장명 기반
//디렉터리 기반(/board), 확장명 기반 (*.do)
@WebServlet(name = "frontControllerServlet", value ="/")
public class FrontControllerServlet extends DispatcherServlet {

    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();

    @Override
    protected void createMap(Map<String, Command> map, Map<String, Command> postMap) {

        // "/" 경로로 HomeController의 getIndex 메소드를 찾을 수 있다 (메소드 참조)
        // put으로 Map에 아이템을 넣어준다

        getMap.put("/", homeController::getIndex);

        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getView);

        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }

}
