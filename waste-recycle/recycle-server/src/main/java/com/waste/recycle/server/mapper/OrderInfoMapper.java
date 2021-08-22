package com.waste.recycle.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.waste.recycle.server.po.OrderInfo;
import com.waste.recycle.server.vo.OrderRequestVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderInfoMapper {
//    int deleteByPrimaryKey(Long id);

//    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateEnableByPrimaryKey(Long id);

    List<OrderInfo> selectByParam(OrderRequestVO record);

    IPage<OrderInfo> getPageList(Page<OrderInfo> page, OrderRequestVO request);
}