package com.tianyufighter.springboot.controller.card;

import com.tianyufighter.springboot.domain.Card;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.User;
import com.tianyufighter.springboot.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
public class InsertCardController {
    @Autowired
    private CardService cardService;
    @RequestMapping(value = "/insertCard", method = RequestMethod.POST)
    @Transactional
    public CommonResult insertCard(HttpServletRequest request) {
        // 获取上传的文件
        MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
        MultipartFile multipartFile = multipartRequest.getFile("image");
        // 文件名
        String fileName = multipartFile.getOriginalFilename();
        // 文件保存路径
        String filePath = "/opt/cloudhouse/cloudhouseImage/img/";
        // 判断文件夹是否存在，不存在则创建
        File file = new File(filePath);
        if(!file.exists()) {
            file.mkdirs();
        }
        String newFileName = UUID.randomUUID() + fileName;
        String newFilePath = filePath + newFileName;
        try {
            multipartFile.transferTo(new File(newFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Card card = new Card();
        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        card.setUsername(user.getUsername());
        card.setUsername(request.getParameter("username"));
        card.setImgPath("cloudhouseImage/img/" + newFileName);
        card.setContent(request.getParameter("text"));
        card.setTitle(request.getParameter("title"));
        card.setCommentCount(0);
        card.setFavoriteCount(0);
        if("true".equals(request.getParameter("gongkai"))) {
            card.setOutgoing(true);
        } else {
            card.setOutgoing(false);
        }
        card.setNote(request.getParameter("beizhu"));
        card.setReleaseTime(new Date());
        card.setCardType(request.getParameter("leixing"));
        System.out.println(card);
        int res = cardService.insertCard(card);
        if(res == 1) {
            System.out.println("存储成功");
            return new CommonResult(200, "true");
        } else {
            System.out.println("存储失败");
            return new CommonResult(444, "false");
        }
    }
}
