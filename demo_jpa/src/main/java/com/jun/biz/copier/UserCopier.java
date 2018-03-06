package com.jun.biz.copier;

import com.jun.biz.utils.DataCopier;
import com.jun.data.entity.UserEntity;
import com.jun.design.pojo.UserInfo;
import org.springframework.beans.BeanUtils;

import javax.inject.Named;

/**
 * Created by Administrator on 2018-1-6.
 */
@Named
public class UserCopier implements DataCopier<UserInfo, UserEntity> {

    @Override
    public UserInfo newViewObject() {
        UserInfo info=new UserInfo();
        return info;
    }

    @Override
    public UserEntity newEntity() {
        UserEntity entity=new UserEntity();
        return entity;
    }

    @Override
    public void copyToEntityForInsert(UserInfo vo, UserEntity entity) {
        BeanUtils.copyProperties(vo,entity,"id");

    }

    @Override
    public void copyToEntityForUpdate(UserInfo vo, UserEntity entity) {
        BeanUtils.copyProperties(vo,entity,"id");
    }

    @Override
    public void copyToViewObject(UserEntity entity, UserInfo vo) {
        BeanUtils.copyProperties(entity,vo);
    }
}
