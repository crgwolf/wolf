package com.waste.recycle.server.service;

import com.waste.recycle.server.config.Page;
import com.waste.recycle.server.vo.StaffInfoVO;

import java.util.List;

public interface StaffInfoService {

    int insertSelective(StaffInfoVO record);

    int updateByPrimaryKeySelective(StaffInfoVO record);

    List<StaffInfoVO> selectLikeName(String userName);


    Page<StaffInfoVO> getPageList(StaffInfoVO record, long pageNum, long pageSize);
}
