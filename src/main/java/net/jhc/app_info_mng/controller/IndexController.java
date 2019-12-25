package net.jhc.app_info_mng.controller;

import net.jhc.app_info_mng.pojo.Md;
import net.jhc.app_info_mng.pojo.OrderInformation;
import net.jhc.app_info_mng.pojo.SuperUser;
import net.jhc.app_info_mng.server.OrderInformationServer;
import net.jhc.app_info_mng.server.SuperUserServer;
import net.jhc.app_info_mng.server.UserServer;
import net.jhc.app_info_mng.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class IndexController {

    @Resource
    private SuperUserServer superUserServer;
    @Resource
    private UserServer userServer;
    @Resource
    private OrderInformationServer orderInformationServer;

//    @GetMapping(value = "Frontdl")
//    public String idx() {
//        return "frontDesk/Frontdl";
//    }

    @RequestMapping(value = "/Frontdl", method = RequestMethod.POST)
    public String findpwd1(Model model, Md m, HttpSession session) throws Exception {
        Md md = null;
        List<OrderInformation> list = null;
        md = userServer.findUserPwdbyUname(m.getUName(), m.getUPassWord());
        session.setAttribute(Constants.USER_SESSION, md);
        session.setAttribute("lg", "lg");
        if (md != null) {
            list = orderInformationServer.findOrderList(md.getUName(), null);
            model.addAttribute("OrderList", list);
            model.addAttribute("lg","lg");
            return "frontDesk/FrontIndex";
        } else {
            model.addAttribute("lg", "错误");
            return "frontDesk/Frontdl";
        }
    }

//    @GetMapping(value = "dl")
//    public String idxd() {
//        return "dl";
//    }

    @RequestMapping(value = "/dl", method = RequestMethod.POST)
    public String findpwd(Model model, SuperUser superUser, HttpSession session) throws Exception {
        SuperUser superUser1 = null;
        superUser1 = superUserServer.findUserPwdbyUname(superUser.getSName(), superUser.getSPassword());
        if (superUser1 != null) {
            List<Md> list = userServer.findUserList(null);
            model.addAttribute("userInfoList", list);
            session.setAttribute(Constants.DEV_USER_SESSION, superUser1);
            return "developer/UserList";
        } else {
            model.addAttribute("lg", "错误");
            return "dl";
        }
    }

    @ExceptionHandler
    public ModelAndView cwcl(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", e.toString());
        mv.setViewName("error");
        return mv;
    }
}
