package com.waste.recycle.server.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.waste.recycle.server.mapper.StaffInfoMapper;
import com.waste.recycle.server.po.OrderInfo;
import com.waste.recycle.server.po.StaffInfo;
import com.waste.recycle.server.vo.StaffInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class StaffInfoDao {

    @Autowired
    private StaffInfoMapper mapper;

    public int insertSelective(StaffInfo record){
        return mapper.insertSelective(record);
    }

    public int updateByPrimaryKeySelective(StaffInfo record){
        return mapper.updateByPrimaryKeySelective(record);
    }

    public StaffInfo selectByPrimaryKey(@NotNull Long id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<StaffInfo> selectLikeName(@NotBlank String userName){
        return mapper.selectLikeName(userName);
    }

    public IPage<StaffInfo> getPageList(StaffInfoVO request, long pageNum, long pageSize) {
        Page page = new Page(pageNum, pageSize);
        return mapper.getPageList(page, request);
    }

}
