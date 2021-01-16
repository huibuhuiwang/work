

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        //登录
        if("admin".equals(username) && "88888".equals(password)) {
          //密码正确
            req.setAttribute("username",username);
            req.getRequestDispatcher("/displayServlet").forward(req,resp);
        }
        else
        {
            //密码错误，跳回登录界面
            req.setAttribute("username",username);
            req.setAttribute("error","用户名或者密码错误，请重新输入！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
