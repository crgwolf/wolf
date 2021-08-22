package com.waste.recycle.server.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderInfoVO {
    private Long id;

    private Long userId;

    private Long prepareHeaderId;

    private Long actualHandlerId;

    private Integer orderState;

    private String orderType;

    private String weight;

    private String orderPerson;

    private String orderPhone;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String province;

    private String city;

    private String country;

    private String town;

    private String detailedAddress;

    private Date visitTime;

    private String message;

    private Date createdTime;

    private StaffInfoVO handler;

}
