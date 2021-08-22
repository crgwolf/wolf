package com.waste.recycle.server.controller;

import com.waste.recycle.server.config.Page;
import com.waste.recycle.server.service.StaffInfoService;
import com.waste.recycle.server.util.ResultBean;
import com.waste.recycle.server.vo.StaffInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "员工controller", tags = {"员工接口"})
@RestController
@RequestMapping("/recycle/staff")
public class StaffInfoController {

    @Autowired
    private StaffInfoService staffInfoService;

    @ApiOperation(value = "新增员工信息", notes = "注意问题点")
    @PostMapping("/add")
    public ResultBean<Boolean> add(@RequestBody StaffInfoVO record) {
        int state = staffInfoService.insertSelective(record);
        return ResultBean.success(state == 1);
    }

    @ApiOperation(value = "修改员工信息", notes = "注意问题点")
    @PutMapping("/update")
    public ResultBean<Boolean> update(@RequestBody StaffInfoVO record) {
        int state = staffInfoService.updateByPrimaryKeySelective(record);
        return ResultBean.success(state == 1);
    }

    @ApiOperation(value = "模糊查询员工信息", notes = "注意问题点")
    @GetMapping("/likeName/{name}")
    public ResultBean<List<StaffInfoVO>> like(@PathVariable String name) {
        List<StaffInfoVO> list = staffInfoService.selectLikeName(name);
        return ResultBean.success(list);
    }


    @ApiOperation(value = "分页查询", notes = "注意问题点")
    @PostMapping("/getPageList")
    public ResultBean<Page<StaffInfoVO>> getPageList(@RequestBody StaffInfoVO record, @RequestParam("pageNum") long pageNum, @RequestParam("pageSize") long pageSize) {
        Page<StaffInfoVO> page = staffInfoService.getPageList(record, pageNum, pageSize);
        return ResultBean.success(page);
    }


}
