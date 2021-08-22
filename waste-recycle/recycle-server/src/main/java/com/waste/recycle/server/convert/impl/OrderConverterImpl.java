package com.waste.recycle.server.convert.impl;

import com.waste.recycle.server.convert.OrderConverter;
import com.waste.recycle.server.convert.StaffConverter;
import com.waste.recycle.server.dao.StaffInfoDao;
import com.waste.recycle.server.po.OrderInfo;

import com.waste.recycle.server.po.StaffInfo;
import com.waste.recycle.server.vo.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderConverterImpl implements OrderConverter {

    @Autowired
    private StaffInfoDao staffInfoDao;

    @Autowired
    private StaffConverter staffConverter;

    @Override
    public OrderInfoVO toVO(OrderInfo po) {
        OrderInfoVO vo = new OrderInfoVO();

        //订单处理人
        Integer orderState = po.getOrderState();
        StaffInfo staffInfo= null;
        Long prepareHandlerId = po.getPrepareHeaderId();
        Long actualHandlerId = po.getActualHandlerId();
        vo.setPrepareHeaderId(prepareHandlerId);
        vo.setActualHandlerId(actualHandlerId);
        if (Objects.equals(orderState, 0L)) {
            staffInfo = staffInfoDao.selectByPrimaryKey(prepareHandlerId);
        }else if (Objects.equals(orderState, 1L)){
            staffInfo = staffInfoDao.selectByPrimaryKey(actualHandlerId);
        }

        vo.setCity(po.getCity());
        vo.setCountry(po.getCountry());
        vo.setCreatedTime(po.getCreatedTime());
        vo.setDetailedAddress(po.getDetailedAddress());
        vo.setId(po.getId());
        vo.setLatitude(po.getLatitude());
        vo.setLongitude(po.getLongitude());
        vo.setMessage(po.getMessage());
        vo.setOrderPerson(po.getOrderPerson());
        vo.setOrderPhone(po.getOrderPhone());
        vo.setOrderState(po.getOrderState());
        vo.setOrderType(po.getOrderType());
        vo.setProvince(vo.getProvince());
        vo.setTown(po.getTown());
        vo.setUserId(po.getUserId());
        vo.setVisitTime(po.getVisitTime());
        vo.setWeight(po.getWeight());
        if (!Objects.equals(staffInfo, null)){
            vo.setHandler(staffConverter.toVO(staffInfo));
        }

        return vo;
    }

    @Override
    public OrderInfo toPO(OrderInfoVO vo) {
        OrderInfo po = new OrderInfo();

        return null;
    }

}
