package com.jun.biz.biz;

import com.jun.biz.copier.UserCopier;
import com.jun.biz.utils.PageableListMaker;
import com.jun.data.entity.UserEntity;
import com.jun.data.repo.UserRepo;
import com.jun.design.design.User;
import com.jun.design.pojo.PageableList;
import com.jun.design.pojo.PageableQueryParam;
import com.jun.design.pojo.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserImpl implements User {
    @Inject
    private UserRepo repo;
    @Inject
    private UserCopier copier;
    @Inject
    private PageableListMaker<UserEntity,UserInfo> maker;

    @Override
    public UserInfo get(@PathVariable Long id) {
        UserEntity  entity=repo.findOne(id);
        UserInfo info=new UserInfo();
        copier.copyToViewObject(entity,info);
        return info;
    }

    @Override
    public PageableList<UserInfo> getAll(PageableQueryParam param) {
        PageRequest pageRequest=new PageRequest(param.getPageNo(), param.getPageSize(), Sort.Direction.DESC, "age");
        Page<UserEntity> entityPage=repo.findAll(pageRequest);
        return maker.get(entityPage,copier);
    }
}
