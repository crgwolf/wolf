package com.waste.recycle.server.convert;

import com.waste.recycle.server.po.OrderInfo;
import com.waste.recycle.server.vo.OrderInfoVO;
import com.waste.recycle.server.vo.OrderRequestVO;

public interface OrderConverter {

    OrderInfoVO toVO(OrderInfo po);

    OrderInfo toPO(OrderInfoVO vo);

//    OrderInfo requestToPO(OrderRequestVO request);

}
