package net.jhc.app_info_mng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class UploadController {

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/native")
    public String nativeUpload(@RequestParam("file") MultipartFile file) throws Exception {
//        String path = request.getSession().getServletContext().getRealPath("images");
//        String filePath = path+"/" + file.getOriginalFilename();
//        System.out.println(filePath);

        String path = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(path);
        String filePath = path  + "static\\images";
        System.out.println(filePath);
        String lg=filePath.substring(1,filePath.length())+"/"+file.getOriginalFilename();
        System.out.println(lg);

        File desFile = new File(lg);
        if (!desFile.getParentFile().exists()) {
            desFile.mkdirs();
        }
        try {
            file.transferTo(desFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("path:---" + filePath);
        return "http://localhost:8080/sj/images/" + file.getOriginalFilename();
    }

}
