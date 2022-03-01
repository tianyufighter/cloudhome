package com.tianyufighter.springboot.controller.Lostgood;

import checkers.units.quals.C;
import com.tianyufighter.springboot.domain.CommonResult;
import com.tianyufighter.springboot.domain.Lostgood;
import com.tianyufighter.springboot.service.lostgood.LostgoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class queryLostGood {
    @Autowired
    private LostgoodService lostgoodService;

    @RequestMapping("/queryInfo")
    public CommonResult<List<Lostgood>> queryInfo(HttpServletRequest request) {
        int num = Integer.parseInt(request.getParameter("num"));
        List<Lostgood> list = lostgoodService.queryLostgood(num);
        if(list != null) {
            return new CommonResult<>(200, "数据查询成功", list);
        } else {
            return new CommonResult<>(444, "数据未查询成功");
        }
    }
}
