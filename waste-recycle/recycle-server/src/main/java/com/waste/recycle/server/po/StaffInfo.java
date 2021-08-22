package com.waste.recycle.server.po;

import lombok.Data;

import java.util.Date;

@Data
public class StaffInfo {
    private Long id;

    private String name;

    private String openid;

    private String sex;

    private String phone;

    private String card;

    private Date createdTime;

    private Date updatedTime;

    private Integer isEnable;

}