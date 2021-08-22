package com.waste.recycle.server.vo;

import lombok.Data;

@Data
public class OrderRequestVO {

    private String openid;

    private Integer orderState;

    private String province;

    private String city;

    private String country;

    private String town;
}
