package com.haidong.SeirMeng.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.haidong.SeirMeng.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.haidong.SeirMeng.service.edu.entity.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author atguigu
 * @since 2021-11-14
 */
public interface TeacherService extends IService<Teacher> {
    /**
     * 功能描述
     * @author Xie.hd
     * @date 2021/12/26 0026
     * @param  page
     * @param limit
     * @param teacherQuery
     * @return selectPage
     */
    IPage<Teacher> selectPage(Long page, Long limit, TeacherQuery teacherQuery);
}
