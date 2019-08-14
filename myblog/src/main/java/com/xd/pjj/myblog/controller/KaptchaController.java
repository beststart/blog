package com.xd.pjj.myblog.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class KaptchaController {

    @Autowired
    private Producer captchaProducer;

    @RequestMapping("kaptcha.jpg")
    public void kaptchaImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control",
                "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,
                capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.flush();
        out.close();
    }

    @RequestMapping("/verify")
    @ResponseBody
    public Result verify(String verify, HttpSession session){
        String verifyValue=session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
        if(verify.toUpperCase().equals(verifyValue.toUpperCase())){
            return new Result(true);
        }
        return new Result(false);
    }
}
