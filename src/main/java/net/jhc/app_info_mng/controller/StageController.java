package net.jhc.app_info_mng.controller;

import net.jhc.app_info_mng.pojo.FruitInformation;
import net.jhc.app_info_mng.pojo.OrderInformation;
import net.jhc.app_info_mng.pojo.User;
import net.jhc.app_info_mng.server.FruitInformationServer;
import net.jhc.app_info_mng.server.OrderInformationServer;
import net.jhc.app_info_mng.server.UserServer;
import net.jhc.app_info_mng.utils.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/stg")
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
    public String adduser(Model model, User md) throws Exception {
        userServer.addUser(md);
        List<User> list = userServer.findUserList(null);
        model.addAttribute("userInfoList", list);
        return "developer/UserList";
    }

    @RequestMapping(value = "delUser")
    public String delUser(Model model, int uid) {
        try {
            userServer.deluser(uid);
            List<User> list = userServer.findUserList(null);
            model.addAttribute("userInfoList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/UserList";
    }

    @RequestMapping(value = "modifyUser")
    public String modifyUserget(Model model, int uid) throws Exception {
        User md = userServer.findUserbyId(uid);
        model.addAttribute("md", md);
        return "developer/UserModify";
    }

    @RequestMapping(value = "modifyUser", method = RequestMethod.POST)
    public String modifyUser(Model model, User md) {
        try {
            userServer.updateUser(md);
            List<User> list = userServer.findUserList(null);
            model.addAttribute("userInfoList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "developer/UserList";
    }

    @RequestMapping(value = "findUser")
    public String findUser(Model model, String uName) {
        try {
            List<User> list = userServer.findUserList(uName);
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

    @RequestMapping(value = "addFruits", method = RequestMethod.POST)
    public String addFruit(Model model,@RequestBody FruitInformation fruitInformation) throws Exception {
        System.out.println(fruitInformation.toString());
        fruitInformationServer.addFruit(fruitInformation);
//        List<FruitInformation> list = fruitInformationServer.findFruitList(null);
//        model.addAttribute("FruitList",list);
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

    @RequestMapping(value = "findAllFruit",method = RequestMethod.POST)
    public List<FruitInformation> findAllFruit(Model model, String fName) {
        return fruitInformationServer.findAll();
    }

    @RequestMapping(value = "/addOrder")
    public String addOrderget() {
        return "/developer/OrderAdd";
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
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

}
