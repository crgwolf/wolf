package com.waste.recycle.server.convert;

import com.waste.recycle.server.po.StaffInfo;
import com.waste.recycle.server.vo.StaffInfoVO;

import java.util.List;

public interface StaffConverter {

    StaffInfoVO toVO(StaffInfo record);

    StaffInfo toPO(StaffInfoVO record);

    List<StaffInfoVO> toVOList(List<StaffInfo> records);

}
