package com.waste.recycle.server.config;

import com.waste.recycle.server.dao.UserInfoDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;

@Component
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "insert", args = {MappedStatement.class, Object.class, RowBounds.class, BoundSql.class})
})
public class MyBatisInterceptor implements Interceptor {

    @Autowired
    UserInfoDao userInfoDao;

    /**
     * Mybatis全局公共参数变量名
     */
//    private static final String COMMON_CREATED_BY = "createdBy";
//    private static final String COMMON_UPDATED_BY = "updatedBy";
    private static final String COMMON_CREATED_TIME = "createdTime";
    private static final String COMMON_UPDATED_TIME = "updatedTime";

    @Override
    public Object intercept(final Invocation invocation) throws Exception {
        if (invocation.getTarget() instanceof Executor && invocation.getArgs().length == 2) {
            final Executor executor = (Executor) invocation.getTarget();
            // 获取第一个参数
            final MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
            final Object paramObj = invocation.getArgs()[1];
            if (ms.getSqlCommandType() == SqlCommandType.INSERT) {
                return this.executeInsert(executor, ms, paramObj);
            } else if (ms.getSqlCommandType() == SqlCommandType.UPDATE) {
                return this.executeUpdate(executor, ms, paramObj);
            } else if (ms.getSqlCommandType() == SqlCommandType.DELETE) {
                return this.executeDelete(executor, ms, paramObj);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(final Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(final Properties properties) {

    }

    /**
     * 更新操作
     *
     * @param executor executor
     * @param ms       ms
     * @param paramObj 参数
     * @return 返回执行结果
     */
    private Object executeInsert(final Executor executor, final MappedStatement ms, final Object paramObj) throws Exception {
        final Field[] fields = paramObj.getClass().getDeclaredFields();
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
//            if (COMMON_CREATED_BY.equals(fieldName)) {
//                String createdBy = (String) field.get(COMMON_CREATED_BY);
//                if (StringUtils.isEmpty(createdBy)) {
//                    field.set(paramObj, "crg10001");
//                }
//            }
//            if (COMMON_UPDATED_BY.equals(fieldName)) {
//                String updatedBy = (String) field.get(COMMON_UPDATED_BY);
//                if (StringUtils.isEmpty(updatedBy)) {
//                    field.set(paramObj, "crg10001");
//                }
//            }
            if (COMMON_CREATED_TIME.equals(fieldName)) {
                Date createdTime = (Date) field.get(COMMON_CREATED_TIME);
                if (createdTime == null) {
                    field.set(paramObj, new Date());
                }
            }
            if (COMMON_UPDATED_TIME.equals(fieldName)) {
                Date updatedTime = (Date) field.get(COMMON_UPDATED_TIME);
                if (updatedTime == null) {
                    field.set(paramObj, new Date());
                }
            }
        }
        return executor.update(ms, paramObj);
    }

    /**
     * 新增操作
     *
     * @param executor executor
     * @param ms       ms
     * @param paramObj 参数
     * @return 返回执行结果
     */
    private Object executeUpdate(final Executor executor, final MappedStatement ms, final Object paramObj) throws Exception {
        final Field[] fields = paramObj.getClass().getDeclaredFields();
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();

//            if (COMMON_CREATED_BY.equals(fieldName)) {
//                String createdBy = (String) field.get(COMMON_CREATED_BY);
//                if (StringUtils.isEmpty(createdBy)) {
//                    field.set(paramObj, "crg10001");
//                }
//            }
//            if (COMMON_UPDATED_BY.equals(fieldName)) {
//                String updatedBy = (String) field.get(COMMON_UPDATED_BY);
//                if (StringUtils.isEmpty(updatedBy)) {
//                    field.set(paramObj, "crg10001");
//                }
//            }
            if (COMMON_CREATED_TIME.equals(fieldName)) {
                Date createdTime = (Date) field.get(COMMON_CREATED_TIME);
                if (createdTime == null) {
                    field.set(paramObj, new Date());
                }
            }
            if (COMMON_UPDATED_TIME.equals(fieldName)) {
                Date updatedTime = (Date) field.get(COMMON_UPDATED_TIME);
                if (updatedTime == null) {
                    field.set(paramObj, new Date());
                }
            }
        }
        return executor.update(ms, paramObj);
    }

    /**
     * 新增操作
     *
     * @param executor executor
     * @param ms       ms
     * @param paramObj 参数
     * @return 返回执行结果
     */
    private Object executeDelete(final Executor executor, final MappedStatement ms, final Object paramObj) throws Exception {
        final Field[] fields = paramObj.getClass().getDeclaredFields();
        for (final Field field : fields) {
            field.setAccessible(true);
            final String fieldName = field.getName();
//            if (COMMON_UPDATED_BY.equals(fieldName)) {
//                String updatedBy = (String) field.get(COMMON_UPDATED_BY);
//                if (StringUtils.isEmpty(updatedBy)) {
//                    field.set(paramObj, "crg10001");
//                }
//            }
            if (COMMON_UPDATED_TIME.equals(fieldName)) {
                Date updatedTime = (Date) field.get(COMMON_UPDATED_TIME);
                if (updatedTime == null) {
                    field.set(paramObj, new Date());
                }
            }
        }
        return executor.update(ms, paramObj);
    }


}
