package com.waste.recycle.server.controller;

import com.waste.recycle.server.config.Page;
import com.waste.recycle.server.po.OrderInfo;
import com.waste.recycle.server.service.OrderInfoService;
import com.waste.recycle.server.util.ResultBean;
import com.waste.recycle.server.vo.OrderInfoVO;
import com.waste.recycle.server.vo.OrderRequestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Api(value="订单controller", tags={"订单接口"})
@RestController
@RequestMapping("/recycle/order")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation(value="新增订单信息",  notes="注意问题点")
    @PostMapping("/add")
    public ResultBean<Boolean> add(@RequestBody OrderInfoVO record){
        orderInfoService.add(record);
        return ResultBean.success(true);
    }

    @ApiOperation(value="修改订单",  notes="注意问题点")
    @PutMapping("/update")
    public ResultBean<OrderInfo> update(@RequestBody OrderInfoVO record){

        return ResultBean.success(null);
    }


    @ApiOperation(value="分页查询",  notes="注意问题点")
    @PostMapping("/getPageList")
    public ResultBean<Page<OrderInfoVO>> getPageList(@RequestBody OrderRequestVO record, @RequestParam("pageNum") long pageNum, @RequestParam("pageSize") long pageSize){
        Page<OrderInfoVO> page = orderInfoService.getPageList(record, pageNum, pageSize);
        return ResultBean.success(page);
    }


}
