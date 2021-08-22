package com.waste.recycle.server.po;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderInfo {
    private Long id;

    @NotBlank
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

    private Date updatedTime;

    private Integer isEnable;

}