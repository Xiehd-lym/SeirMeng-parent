package com.haidong.SeirMeng.service.test.controller;


import com.haidong.SeirMeng.service.base.result.R;
import com.haidong.SeirMeng.service.edu.entity.Teacher;
import com.haidong.SeirMeng.service.edu.entity.Vo.TeacherVo;
import com.haidong.SeirMeng.service.edu.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 投保申请表 前端控制器
 * </p>
 *
 * @author xiehd
 * @since 2022-07-29
 */
@RestController
@RequestMapping("/test/application")
@Slf4j
public class ApplicationController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("one")
    public R testNoThree(@RequestBody TeacherVo teacherVo) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherVo,teacher);
        log.info("我的Vo对象：{}",teacherVo);
        log.info("我的数据对象0011：{}",teacher);
        boolean b = teacherService.save(teacher);
        return R.ok().message("111");
    }
}

