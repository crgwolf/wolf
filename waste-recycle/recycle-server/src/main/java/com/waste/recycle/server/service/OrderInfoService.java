package com.waste.recycle.server.service;

import com.waste.recycle.server.config.Page;
import com.waste.recycle.server.po.OrderInfo;
import com.waste.recycle.server.vo.OrderInfoVO;
import com.waste.recycle.server.vo.OrderRequestVO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface OrderInfoService {

    /**
     * 新增订单
     * @param record
     * @return
     */
    int add(OrderInfoVO record);

    /**
     * 删除订单
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 通过openid查询
     * @param openid
     * @return
     */
    List<OrderInfo> selectByOpenid(@NotBlank String openid, @NotNull Integer state);

    /**
     * 根据区域查询
     * @param record
     * @return
     */
    List<OrderInfo> selectByArea(OrderRequestVO record);

    /**
     * 员工 更新订单处理人/状态
     * @param record
     * @return
     */
    int updateHandlerOrState(OrderInfoVO record);


    /**
     * 客户修改订单
     * @param record
     * @return
     */
    int update(OrderInfoVO record);


    Page<OrderInfoVO> getPageList(OrderRequestVO record, long pageNum, long pageSize);

}
