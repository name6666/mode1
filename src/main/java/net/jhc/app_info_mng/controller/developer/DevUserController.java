package net.jhc.app_info_mng.controller.developer;

import net.jhc.app_info_mng.pojo.DevUser;
import net.jhc.app_info_mng.server.developer.DevUserService;
import net.jhc.app_info_mng.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/dev")
public class DevUserController {
	private Logger logger = Logger.getLogger(DevUserController.class);
	
	@Resource
	private DevUserService devUserService;
	
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("LoginController welcome AppInfoSystem develpor==================");
		return "devlogin";
	}
	
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public String doLogin(@RequestParam String devCode, @RequestParam String devPassword, HttpServletRequest request){
		logger.debug("doLogin====================================");
		//调用service方法，进行用户匹配
		DevUser user = null;
		try {
			user = devUserService.login(devCode,devPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null != user){//登录成功
			//放入session
			request.getSession().setAttribute(Constants.DEV_USER_SESSION, user);
			//页面跳转（main.jsp）
			return "redirect:/dev/flatfrom/main";
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "devlogin";
		}
	}
	@GetMapping("/flatfrom/main")
	public String todevIndex(){
		return "developer/main";
	}

	@RequestMapping(value="/flatform/main")
	public String main(HttpSession session){
		System.out.println("ccccccccccccccccccc");
		if(session.getAttribute(Constants.DEV_USER_SESSION) == null){
			System.out.println("ddddddddddddddddddddddddd");
			return "redirect:/dev/login";
		}
		return "main";
	}

	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		//清除session
		request.getSession().removeAttribute(Constants.DEV_USER_SESSION);
		return "redirect:/";
	}
}

