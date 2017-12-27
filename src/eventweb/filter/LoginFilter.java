package eventweb.filter;

import eventweb.model.User;
import eventweb.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest =(HttpServletRequest) req;
        if(httpServletRequest.getUserPrincipal()!=null && httpServletRequest.getSession().getAttribute("user")==null){
            saveUserInSession(httpServletRequest);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }
    private void saveUserInSession(HttpServletRequest request){
        UserService userService = new UserService();
        String username = request.getUserPrincipal().getName();
        User userByUsername = userService.getUserByUsername(username);
        request.getSession(true).setAttribute("user",userByUsername);
    }

}
