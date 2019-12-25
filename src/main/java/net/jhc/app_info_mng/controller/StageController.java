package net.jhc.app_info_mng.controller;

import net.jhc.app_info_mng.pojo.FruitInformation;
import net.jhc.app_info_mng.pojo.Md;
import net.jhc.app_info_mng.pojo.OrderInformation;
import net.jhc.app_info_mng.server.FruitInformationServer;
import net.jhc.app_info_mng.server.OrderInformationServer;
import net.jhc.app_info_mng.server.UserServer;
import net.jhc.app_info_mng.utils.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "stg")
public class StageController {
    @Resource
    private UserServer userServer;
//    @Resource
//    private SuperUserServer superUserServer;
    @Resource
    private FruitInformationServer fruitInformationServer;
    @Resource
    private OrderInformationServer orderInformationServer;

    private Logger logger= LoggerFactory.getLogger(StageController.class);

//    @RequestMapping(value = "dl", method = RequestMethod.GET)
//    public String idx() {
//        return "dl";
//    }
//
//    @RequestMapping(value = "dl", method = RequestMethod.POST)
//    public String findpwd(Model model, SuperUser superUser, HttpServletRequest request) throws Exception {
//        SuperUser superUser1 = null;
//        superUser1 = superUserServer.findUserPwdbyUname(superUser.getSName(), superUser.getSPassword());
//
//        if (superUser1 != null) {
//            List<Md> list = zs.findUserList(null);
//            model.addAttribute("userInfoList", list);
//            HttpSession session=request.getSession();
//            session.setAttribute(Constants.DEV_USER_SESSION,superUser1);
//            return "developer/UserList";
//        } else {
//            model.addAttribute("lg", "错误");
//            return "dl";
//        }
//    }

    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute(Constants.USER_SESSION,null);
        return "dl";
    }

    @RequestMapping(value = "adduser")
    public String adduserget() {
        return "developer/UserAdd";
    }

    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    public String adduser(Model model, Md md) throws Exception {
        userServer.addUser(md);
        List<Md> list = userServer.findUserList(null);
        model.addAttribute("userInfoList", list);
        return "developer/UserList";
    }

    @RequestMapping(value = "delUser")
    public String delUser(Model model, int uid) {
        try {
            userServer.deluser(uid);
            List<Md> list = userServer.findUserList(null);
            model.addAttribute("userInfoList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/UserList";
    }

    @RequestMapping(value = "modifyUser")
    public String modifyUserget(Model model, int uid) throws Exception {
        Md md = userServer.findUserbyId(uid);
        model.addAttribute("md", md);
        return "developer/UserModify";
    }

    @RequestMapping(value = "modifyUser", method = RequestMethod.POST)
    public String modifyUser(Model model, Md md) {
        try {
            userServer.updateUser(md);
            List<Md> list = userServer.findUserList(null);
            model.addAttribute("userInfoList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/UserList";
    }

    @RequestMapping(value = "findUser")
    public String findUser(Model model, String uName) {
        try {
            List<Md> list = userServer.findUserList(uName);
            model.addAttribute("userInfoList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/UserList";
    }

    @RequestMapping(value = "addFruit")
    public String addFruitget() {
        return "/developer/FruitAdd";
    }

    @RequestMapping(value = "addFruit", method = RequestMethod.POST)
    public String addFruit(Model model, FruitInformation fruitInformation) throws Exception {
        fruitInformationServer.addFruit(fruitInformation);
        List<FruitInformation> list = fruitInformationServer.findFruitList(null);
        model.addAttribute("FruitList",list);
        return "/developer/FruitList";
    }

    @RequestMapping(value = "delFruit")
    public String delFruit(Model model, int fid) {
        try {
            fruitInformationServer.delFruit(fid);
            List<FruitInformation> list = fruitInformationServer.findFruitList(null);
            model.addAttribute("FruitList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/developer/FruitList";
    }

    @RequestMapping(value = "modifyFruit")
    public String modifyFruitget(Model model, int fid) throws Exception {
        FruitInformation fruitInformation = fruitInformationServer.findFruitbyId(fid);
        model.addAttribute("fruit", fruitInformation);
        return "/developer/FruitModify";
    }

    @RequestMapping(value = "modifyFruit", method = RequestMethod.POST)
    public String modifyFruit(Model model, FruitInformation fruitInformation) {
        try {
            fruitInformationServer.updateFruit(fruitInformation);
            List<FruitInformation> list = fruitInformationServer.findFruitList(null);
            model.addAttribute("FruitList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/developer/FruitList";
    }

    @RequestMapping(value = "findFruit")
    public String findFruit(Model model, String fName) {
        try {
            List<FruitInformation> list = fruitInformationServer.findFruitList(fName);
            model.addAttribute("FruitList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/developer/FruitList";
    }

    @RequestMapping(value = "addOrder")
    public String addOrderget() {
        return "/developer/OrderAdd";
    }

    @RequestMapping(value = "addOrder", method = RequestMethod.POST)
    public String addOrder(Model model, OrderInformation orderInformation) throws Exception {
        orderInformationServer.addOrder(orderInformation);
        List<OrderInformation> list = orderInformationServer.findOrderList(null,null);
        model.addAttribute("orderList", list);
        return "/developer/OrderList";
    }

    @RequestMapping(value = "delOrder")
    public String delOrder(Model model, int oid) {
        try {orderInformationServer.delOrder(oid);
            List<OrderInformation> list = orderInformationServer.findOrderList(null,null);
            model.addAttribute("orderList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/developer/OrderList";
    }

    @RequestMapping(value = "modifyOrder")
    public String modifyOrderget(Model model, int oid) throws Exception {
        OrderInformation orderInformation = orderInformationServer.findOrderNamebyId(oid);
        model.addAttribute("order", orderInformation);
        return "/developer/OrderModify";
    }

    @RequestMapping(value = "modifyOrder", method = RequestMethod.POST)
    public String modifyOrder(Model model, OrderInformation orderInformation) {
        try {
            logger.info(orderInformation.toString());
            orderInformationServer.updateOrder(orderInformation);
            List<OrderInformation> list = orderInformationServer.findOrderList(null,null);
            model.addAttribute("orderList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/developer/OrderList";
    }

    @RequestMapping(value = "findOrder")
    public String findOrder(Model model, String oName) {
        try {
            List<OrderInformation> list = orderInformationServer.findOrderList(null,oName);
            model.addAttribute("orderList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/developer/OrderList";
    }

    @ExceptionHandler
    public ModelAndView cwcl(Exception e){
        ModelAndView mv=new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error");
        return mv;
    }
}
