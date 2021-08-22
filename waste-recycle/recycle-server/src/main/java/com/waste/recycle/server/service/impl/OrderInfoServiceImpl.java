package com.waste.recycle.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.waste.recycle.server.config.Page;
import com.waste.recycle.server.config.PageResultConverter;
import com.waste.recycle.server.convert.OrderConverter;
import com.waste.recycle.server.dao.OrderInfoDao;
import com.waste.recycle.server.po.OrderInfo;
import com.waste.recycle.server.service.OrderInfoService;
import com.waste.recycle.server.vo.OrderInfoVO;
import com.waste.recycle.server.vo.OrderRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;
    @Autowired
    private OrderConverter orderConverter;

    @Override
    public int add(OrderInfoVO record) {
        OrderInfo order = orderConverter.toPO(record);
        return orderInfoDao.insertSelective(order);
    }

    @Override
    public int update(OrderInfoVO record) {
        OrderInfo order = orderConverter.toPO(record);
        return orderInfoDao.updateByPrimaryKeySelective(order);
    }

    @Override
    public int delete(Long id) {
        return orderInfoDao.updateEnableByPrimaryKey(id);
    }

    @Override
    public List<OrderInfo> selectByOpenid(@NotBlank String openid, @NotNull Integer state) {

        return null;
    }

    @Override
    public List<OrderInfo> selectByArea(OrderRequestVO record) {
        orderInfoDao.selectByParam(record);
        return null;
    }

    @Override
    public int updateHandlerOrState(OrderInfoVO record) {
        OrderInfo po = orderConverter.toPO(record);
        return orderInfoDao.updateByPrimaryKeySelective(po);
    }


    @Override
    public Page<OrderInfoVO> getPageList(OrderRequestVO request, long pageNum, long pageSize) {
        IPage<OrderInfo> page = orderInfoDao.getPageList(request, pageNum, pageSize);
        Page rt = PageResultConverter.toPage(page, orderInfo -> orderConverter.toVO(orderInfo));
        return rt;
    }



}
