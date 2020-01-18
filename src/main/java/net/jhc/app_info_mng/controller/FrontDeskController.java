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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/fdc")
public class FrontDeskController {
    @Resource
    private UserServer userServer;
    @Resource
    private OrderInformationServer orderInformationServer;
    @Resource
    private FruitInformationServer fruitInformationServer;

    private Logger logger = LoggerFactory.getLogger(FrontDeskController.class);

    @RequestMapping(value = "/Frontlogout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute(Constants.USER_SESSION,null);
        return "frontDesk/Frontdl";
    }

    @RequestMapping(value = "/findOrder")
    public String findpwd(Model model, String oFruit, HttpServletRequest request) throws Exception {
        User md = null;
        if (request.getSession().getAttribute(Constants.USER_SESSION) ==null){
            return "frontDesk/Frontdl";
        }
        md=(User)request.getSession().getAttribute(Constants.USER_SESSION);
        List<OrderInformation> list = orderInformationServer.findOrderList(oFruit, md.getUName());
        model.addAttribute("OrderList", list);
        return "frontDesk/MyOrder";
    }


    @RequestMapping(value = "/del")
    public String del(Integer oid, Model model, HttpServletRequest request) {
        List<OrderInformation> list = null;
        User md = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        try {
            orderInformationServer.delOrder(oid);
            list = orderInformationServer.findOrderList(null, md.getUName());
            model.addAttribute("OrderList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "frontDesk/MyOrder";
    }

    @RequestMapping(value = "/useradd", method = RequestMethod.POST)
    public String add(Model model, User md) {
        boolean lg = false;
        try {
            lg = userServer.addUser(md);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("dellg", lg);
        return "/frontDesk/UserRegistration";
    }

    @RequestMapping(value = "/userinfoadd")
    public String userinfoadd() {
        return "/frontDesk/UserRegistration";
    }

    @RequestMapping(value = "/frontindex")
    public String FrontIndex() {
        return "/frontDesk/FrontIndex";
    }

    @RequestMapping(value = "/fruitselection")
    public String fruitselection() {
        return "frontDesk/FruitSelection";
    }

    @RequestMapping(value = "/findFruitInformation")
    public String findFruitInformation(Model model, Integer fid) throws Exception {
        FruitInformation information = fruitInformationServer.findFruitbyId(fid);
        model.addAttribute("fruitInformation", information);
        return "/frontDesk/ByFruit";
    }

    @RequestMapping(value = "/byFruit")
    public String byFruit(Model model, OrderInformation informationDto, HttpServletRequest request) throws Exception {
        User md = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        OrderInformation information=new OrderInformation();

//      计算总价
        information.setOName(md.getUName());
        int oPrice =informationDto.getOPrice() ;
        int oNumber = informationDto.getONumber();
        int sum = oNumber * oPrice;

        information.setOPrice(sum);
        information.setOAddress(informationDto.getOAddress());
        information.setOFruit(informationDto.getOFruit());
        information.setONumber(informationDto.getONumber());
        boolean b = orderInformationServer.addOrder(information);

        List<OrderInformation> list = orderInformationServer.findOrderList(null, md.getUName());
        model.addAttribute("OrderList", list);
        return "/frontDesk/MyOrder";
    }


    @ExceptionHandler
    public ModelAndView cwcl(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", e.toString());
        mv.setViewName("error");
        return mv;
    }
}
