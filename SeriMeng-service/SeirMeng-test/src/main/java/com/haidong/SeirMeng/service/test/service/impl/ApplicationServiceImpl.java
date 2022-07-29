package com.haidong.SeirMeng.service.test.service.impl;

import com.haidong.SeirMeng.service.test.entity.Application;
import com.haidong.SeirMeng.service.test.mapper.ApplicationMapper;
import com.haidong.SeirMeng.service.test.service.ApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 投保申请表 服务实现类
 * </p>
 *
 * @author xiehd
 * @since 2022-07-29
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

}
