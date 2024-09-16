package LogIn;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class LogInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("Abhi".equals(username) && "@123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            out.println("<h2>Welcome " + username + "!</h2>");
            out.println("<a href='LogOutServlet'>Log out</a>");
        } else {
        	out.println("<h2>Login</h2>");
            out.println("<form action='LogInServlet' method='post'>");
            out.println("Username: <input type='text' name='username'><br>");
            out.println("Password: <input type='password' name='password'><br>");
            out.println("<input type='submit' value='Login'>");
            out.println("<input type='reset' value='Clear'>");
            out.println("</form>");
            out.println("<p style='color:red;'>Invalid Username or Password</p>");
         
//        	response.sendRedirect("LogInServlet1.html"); // assuming login.html is your login page
        }
    }
}
