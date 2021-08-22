package com.waste.recycle.server.config;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public final class PageResultConverter {
    private PageResultConverter() {

    }

    public static <T> Page<T> toPage(IPage<T> page) {
        Page<T> pageResultBean = new Page<>();
        pageResultBean.setCurrent(page.getCurrent());
        pageResultBean.setSize(page.getSize());
        pageResultBean.setTotalCount(page.getTotal());

        return pageResultBean;
    }

    public static <S, T> Page<T> toPage(IPage<S> page, Function<S, T> converter) {
        Page<T> pageResultBean = new Page<>();
        pageResultBean.setCurrent(page.getCurrent());
        if (CollectionUtils.isEmpty(page.getRecords())) {
            pageResultBean.setData(Collections.emptyList());
        } else {
            List<T> targets = new ArrayList<>();
            for (S s : page.getRecords()) {
                targets.add(converter.apply(s));
            }
            pageResultBean.setData(targets);
        }
        pageResultBean.setSize(page.getSize());
        pageResultBean.setTotalCount(page.getTotal());
        return pageResultBean;
    }

}
