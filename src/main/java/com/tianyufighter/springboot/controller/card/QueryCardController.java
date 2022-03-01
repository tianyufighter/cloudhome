package com.tianyufighter.springboot.controller.card;

import com.tianyufighter.springboot.domain.Card;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QueryCardController {
    @Autowired
    private CardService cardService;
    @GetMapping("/queryCard")
    @ResponseBody
    public CommonResult<List<Card>> queryCardByNum(@RequestParam(value = "num") int num, HttpServletRequest request) {
        List<Card> list = new ArrayList<>();
        list = cardService.queryCardByNum(num);
        CommonResult<List<Card>> commonResult;
        if(list != null) {
            commonResult = new CommonResult<>(200, "查询数据库成功", list);
        } else {
            commonResult = new CommonResult(444, "查询出错了");
            System.out.println("查询数据失败");
        }
        return commonResult;
    }
}
