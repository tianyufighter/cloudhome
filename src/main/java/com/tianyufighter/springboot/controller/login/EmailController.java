package com.tianyufighter.springboot.controller.login;

import checkers.units.quals.C;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.User;
import com.tianyufighter.springboot.service.user.UserService;
import com.tianyufighter.springboot.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class EmailController {
    @Autowired
    private JavaMailSender javaMailSender;
    // 存储验证码
    private Map<String, Object> resultMap = new HashMap<>();
    @RequestMapping("/sendEmail")
    public CommonResult sendEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        String code = VerifyCode(6);//随机数生成6位验证码
        message.setFrom("3121402314@qq.com");
        message.setTo(email);
        message.setSubject("云客在线服务系统");// 标题
        message.setText("【云客在线服务系统】你的验证码为："+code+"，有效时间为5分钟(若不是本人操作，可忽略该条邮件)");//内容
        try {
            javaMailSender.send(message);
            saveCode(code);
            return new CommonResult(200, "success");
        } catch (MailSendException e) {
            return new CommonResult(444,"false");
        } catch (Exception e) {
            return new CommonResult(444, "failure");
        }
    }

    @Autowired
    public UserService userService;

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public CommonResult doRegister(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("verifyCode") String verifyCode) {
        System.out.println("新用户注册");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        // 将客户端传过来的hash加密
        String verifyHash = MD5Utils.code(verifyCode);
        // 判断验证码是否正确
        if(verifyHash != null && verifyHash.equals(resultMap.get("hash"))) {
            int res = userService.insertUser(user);
            if(res == 1) {
                return new CommonResult(200, "true");
            } else {
                return new CommonResult(444, "false");
            }
        } else {
            return new CommonResult(444, "failure");
        }
    }
    private String VerifyCode(int n){
        Random r = new Random();
        StringBuffer sb =new StringBuffer();
        for(int i = 0;i < n;i ++){
            int ran1 = r.nextInt(10);
            sb.append(String.valueOf(ran1));
        }
        return sb.toString();
    }
    //保存验证码和时间
    private void saveCode(String code){
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, 5);
        String currentTime = sf.format(c.getTime());// 生成5分钟后时间，用户校验是否过期

        String hash =  MD5Utils.code(code);//生成MD5值
        resultMap.put("hash", hash);
        resultMap.put("tamp", currentTime);
    }
}
