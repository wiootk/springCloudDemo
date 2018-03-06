package com.jun.biz.utils;

import com.jun.design.pojo.PageableList;
import org.springframework.data.domain.Page;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-1-6.
 */
@Named
public class PageableListMaker<E, V> {

    /**
     * 获取PageableList，并将实体转换成VO
     * @param page			分页查询结果
     * @param dataCopier	数据拷贝器
     * @return
     */
    public PageableList<V> get(Page<E> page, DataCopier<V, E> dataCopier) {
        PageableList<V> pl = get(page);
        List<V> list = pl.getRecords();
        if(dataCopier != null) {
            List<E> pList = page.getContent();
            for(E entity : pList) {
                V vo = dataCopier.newViewObject();
                dataCopier.copyToViewObject(entity, vo);
                list.add(vo);
            }
        }
        return pl;
    }

    /**
     * 获取PageableList，不进行VO转换
     * @param page	分页查询结果
     * @return
     */
    public PageableList<V> get(Page<E> page) {
        PageableList<V> pl = new PageableList<V>();
        pl.setPageNo(page.getNumber() + 1);
        pl.setPageSize(page.getSize());
        pl.setTotalPages(page.getTotalPages());
        pl.setTotalRecords(page.getTotalElements());
        List<V> list = new ArrayList<V>();
        pl.setRecords(list);
        return pl;
    }
}

