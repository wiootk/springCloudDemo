package com.jun.biz.utils;



public interface DataCopier<V, E> {
    /**
     * 创建呈现层对象的实例，带默认值
     * @return
     */
    V newViewObject();
    /**
     * 创建实体对象实例
     * @return
     */
    E newEntity();
    /**
     * 将呈现层对象的属性值拷贝到实体对象的对应属性中，以便新增实体时使用
     * @param vo		呈现层对象
     * @param entity	实体对象
     */
    void copyToEntityForInsert(V vo, E entity);
    /**
     * 将呈现层对象的属性值拷贝到实体对象的对应属性中，以便修改实体时使用
     * @param vo		呈现层对象
     * @param entity	实体对象
     */
    void copyToEntityForUpdate(V vo, E entity);
    /**
     * 将实体对象的属性拷贝到呈现层对象的对应属性中
     * @param entity	实体对象
     * @param vo		呈现层对象
     */
    void copyToViewObject(E entity, V vo);
}