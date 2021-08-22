package com.waste.recycle.server.dao;

import com.waste.recycle.server.mapper.UserInfoMapper;
import com.waste.recycle.server.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoDao {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public int insertSelective(UserInfo record){
        return userInfoMapper.insertSelective(record);
    }

    public UserInfo selectByPrimaryKey(Long id){
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(UserInfo record){
        return updateByPrimaryKeySelective(record);
    }

}
