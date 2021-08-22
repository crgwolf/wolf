package com.waste.recycle.server.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.waste.recycle.server.mapper.OrderInfoMapper;
import com.waste.recycle.server.po.OrderInfo;
import com.waste.recycle.server.vo.OrderRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class OrderInfoDao {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    public int insertSelective(OrderInfo record) {
        return orderInfoMapper.insertSelective(record);
    }

    public OrderInfo selectByPrimaryKey(@NotNull Long id) {
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateEnableByPrimaryKey(@NotNull Long id){
        return updateEnableByPrimaryKey(id);
    }

    public List<OrderInfo> selectByParam(OrderRequestVO record){
        return orderInfoMapper.selectByParam(record);
    }

    public IPage<OrderInfo> getPageList(OrderRequestVO request, long pageNum, long pageSize) {
        Page page = new Page(pageNum, pageSize);
        return orderInfoMapper.getPageList(page, request);
    }
}
