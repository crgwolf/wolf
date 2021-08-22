package com.waste.recycle.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.waste.recycle.server.config.Page;
import com.waste.recycle.server.config.PageResultConverter;
import com.waste.recycle.server.convert.StaffConverter;
import com.waste.recycle.server.dao.StaffInfoDao;
import com.waste.recycle.server.po.StaffInfo;
import com.waste.recycle.server.service.StaffInfoService;
import com.waste.recycle.server.vo.StaffInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffInfoServiceImpl implements StaffInfoService {

    @Autowired
    private StaffInfoDao staffInfoDao;

    @Autowired
    private StaffConverter staffConverter;

    @Override
    public int insertSelective(StaffInfoVO record) {
        StaffInfo po = staffConverter.toPO(record);
        return staffInfoDao.insertSelective(po);
    }

    @Override
    public int updateByPrimaryKeySelective(StaffInfoVO record) {
        StaffInfo po = staffConverter.toPO(record);
        return staffInfoDao.updateByPrimaryKeySelective(po);
    }

    @Override
    public List<StaffInfoVO> selectLikeName(String userName) {
        List<StaffInfo> staffs = staffInfoDao.selectLikeName(userName);
        return staffConverter.toVOList(staffs);
    }

    @Override
    public Page<StaffInfoVO> getPageList(StaffInfoVO record, long pageNum, long pageSize) {
        IPage<StaffInfo> page = staffInfoDao.getPageList(record, pageNum, pageSize);
        Page rt = PageResultConverter.toPage(page, orderInfo -> staffConverter.toVO(orderInfo));
        return rt;
    }

}
