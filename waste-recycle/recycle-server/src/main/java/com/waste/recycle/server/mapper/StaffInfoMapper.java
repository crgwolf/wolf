package com.waste.recycle.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.waste.recycle.server.po.StaffInfo;
import com.waste.recycle.server.vo.StaffInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StaffInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    StaffInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);

    List<StaffInfo> selectLikeName(@Param("userName") String userName);

    IPage<StaffInfo> getPageList(Page<StaffInfo> page, StaffInfoVO request);
}