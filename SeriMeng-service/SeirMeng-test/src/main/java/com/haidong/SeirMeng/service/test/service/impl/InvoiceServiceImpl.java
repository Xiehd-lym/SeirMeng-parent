package com.haidong.SeirMeng.service.test.service.impl;

import com.haidong.SeirMeng.service.test.entity.Invoice;
import com.haidong.SeirMeng.service.test.mapper.InvoiceMapper;
import com.haidong.SeirMeng.service.test.service.InvoiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发票表 服务实现类
 * </p>
 *
 * @author xiehd
 * @since 2022-07-29
 */
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService {

}
