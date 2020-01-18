package net.jhc.app_info_mng.config;

import net.jhc.app_info_mng.pojo.SuperUser;
import net.jhc.app_info_mng.pojo.User;
import net.jhc.app_info_mng.utils.Constants;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class Filte implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        User md = (User) session.getAttribute(Constants.USER_SESSION);
        SuperUser superUser = (SuperUser) session.getAttribute(Constants.DEV_USER_SESSION);
        if (md == null) {
            request.getRequestDispatcher("/Frontdll");
            return true;
        }else if (superUser == null) {
            request.getRequestDispatcher("/dll");
            return true;
        }else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

}
