package com.haidong.SeirMeng.service.edu.controller;


import cn.hutool.crypto.SmUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.haidong.SeirMeng.service.base.result.R;
import com.haidong.SeirMeng.service.base.util.HttpUtils;
import com.haidong.SeirMeng.service.edu.entity.Guarantee;
import com.haidong.SeirMeng.service.edu.entity.Teacher;
import com.haidong.SeirMeng.service.edu.entity.Vo.TeacherVo;
import com.haidong.SeirMeng.service.edu.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.util.UUID;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2021-11-14
 */
@Slf4j
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Value("${guarantee.http.apply.baseUrl}")
    private String applyBaseUrl;

    @Value("${signature.appId}")
    private String appId;

    @Value("${signature.accessKeyId}")
    private String accessKeyId;

    @Value("${signature.keySecret}")
    private String keySecret;

    @Autowired
    private TeacherService teacherService;

    @PostMapping("insert")
    public R insert(@RequestBody Teacher teacher){
        boolean b = teacherService.save(teacher);
        return R.ok().data("b",b);
    }

    @PostMapping("one")
    public R testNoOne(@RequestBody Teacher teacher){
        boolean b = teacherService.saveOrUpdate(teacher);
        return R.ok().data("b",b);
    }

    @PostMapping("two")
    public R testNoTwo(@RequestBody Teacher teacher){
        String name = teacher.getName();
        Integer level = teacher.getLevel();
        UpdateWrapper<Teacher> teacherUpdateWrapper = new UpdateWrapper<>();
        teacherUpdateWrapper.eq("name",name);
        teacherUpdateWrapper.eq("level",level);
        boolean b = teacherService.saveOrUpdate(teacher, teacherUpdateWrapper);
        return R.ok().data("b",b);
    }

    @PostMapping("three")
    public R testNoThree(@RequestBody TeacherVo teacherVo) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherVo,teacher);
        log.info("我的Vo对象：{}",teacherVo);
        log.info("我的数据对象0011：{}",teacher);
        boolean b = teacherService.save(teacher);
        return R.ok().message("111");
    }

    @PostMapping("four")
//
    public R testNoFour(@RequestBody Guarantee guarantee) {
        guarantee.setAppId(appId);
        guarantee.setAccessKeyId(accessKeyId);
        guarantee.setKeySecret(keySecret);
        String timestamp = String.valueOf(System.currentTimeMillis());
        guarantee.setTimestamp(timestamp);
        String uuid = UUID.randomUUID().toString().trim().replace("-", "");
        guarantee.setUuid(uuid);
        String baseString = "accessKeyId="+accessKeyId+"&appId="+appId+"&timestamp="+timestamp+"&uuid="+uuid;
        String signature = SmUtil.sm3(keySecret + baseString);
        guarantee.setSignature(signature);
        log.info("signature:{}",signature);
        String response = HttpUtils.sendPost(applyBaseUrl, JSONObject.toJSONString(guarantee));
        log.info("response:{}",response);
        return R.ok().message("111");
    }
}

