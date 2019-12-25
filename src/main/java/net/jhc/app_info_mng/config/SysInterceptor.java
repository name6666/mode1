package net.jhc.app_info_mng.config;

import net.jhc.app_info_mng.pojo.Md;
import net.jhc.app_info_mng.pojo.SuperUser;
import net.jhc.app_info_mng.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SysInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(SysInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		logger.debug("SysInterceptor preHandle ======================");
		HttpSession session = request.getSession();
		
		Md md = (Md) session.getAttribute(Constants.USER_SESSION);
		SuperUser superUser = (SuperUser) session.getAttribute(Constants.DEV_USER_SESSION);
		
		if(null != superUser){ //dev SUCCESS
			return true;
		}else if(null != md){ //backend SUCCESS
			return true;
		}else{
			request.getRequestDispatcher("/").forward(request,response);
			return false;
		}
	}
}
