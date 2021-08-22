package com.waste.recycle.server.mapper;

import com.waste.recycle.server.po.UserInfo;
import org.springframework.stereotype.Component;

@Component
public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}