package com.waste.recycle.server.convert.impl;

import com.waste.recycle.server.convert.StaffConverter;
import com.waste.recycle.server.po.StaffInfo;
import com.waste.recycle.server.vo.StaffInfoVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffConverterImpl implements StaffConverter {

    @Override
    public StaffInfoVO toVO(StaffInfo record) {
        StaffInfoVO vo = new StaffInfoVO();
        vo.setCard(record.getCard());
        vo.setId(record.getId());
        vo.setName(record.getName());
        vo.setOpenid(record.getOpenid());
        vo.setPhone(record.getPhone());
        vo.setSex(record.getSex());
        return vo;
    }

    @Override
    public StaffInfo toPO(StaffInfoVO record) {
        StaffInfo po = new StaffInfo();
        po.setCard(record.getCard());
        po.setId(record.getId());
        po.setName(record.getName());
        po.setOpenid(record.getOpenid());
        po.setPhone(record.getPhone());
        po.setSex(record.getSex());
        return po;
    }

    @Override
    public List<StaffInfoVO> toVOList(List<StaffInfo> records) {
        List<StaffInfoVO> list = records.stream().map(staffInfo -> toVO(staffInfo)).collect(Collectors.toList());
        return list;
    }
}
