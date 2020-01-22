package net.jhc.app_info_mng.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandling {
//    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String throwsException(Exception e, Model model) {
        model.addAttribute("exp", e.getMessage());
        return "error/error";
    }
}
