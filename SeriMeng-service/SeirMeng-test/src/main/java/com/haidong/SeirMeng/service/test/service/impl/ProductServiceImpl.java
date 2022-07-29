package com.haidong.SeirMeng.service.test.service.impl;

import com.haidong.SeirMeng.service.test.entity.Product;
import com.haidong.SeirMeng.service.test.mapper.ProductMapper;
import com.haidong.SeirMeng.service.test.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品表 服务实现类
 * </p>
 *
 * @author xiehd
 * @since 2022-07-29
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
