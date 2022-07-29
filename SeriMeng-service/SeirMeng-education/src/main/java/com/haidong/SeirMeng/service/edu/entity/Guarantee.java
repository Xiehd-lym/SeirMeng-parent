package com.haidong.SeirMeng.service.edu.entity;

import lombok.Data;

/**
 * @Author xiehd
 * @Date 2022 07 07
 **/
@Data
public class Guarantee {
    private String timestamp;
    private String uuid;
    private String signature;
    private String appId;
    private String accessKeyId;
    private String keySecret;
    private String productId;
    private String orderNo;
}
