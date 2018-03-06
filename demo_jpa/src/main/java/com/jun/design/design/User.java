package com.jun.design.design;

import com.jun.design.pojo.PageableList;
import com.jun.design.pojo.PageableQueryParam;
import com.jun.design.pojo.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "API - UserController")
public interface User {
    @ApiOperation(value = "获取User信息", notes = "根据id获取User信息")// 描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "User表ID", required = true, dataType = "Long", paramType = "path")
    })//描述方法参数信息，paramType值path
    @GetMapping("/get/{id}")
    UserInfo get(@PathVariable Long id);

    @ApiOperation(value = "所有user列表", notes = "根据分页信息获取User列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "{\r\"pageNo\":第几页,\r\"pageSize\":每页多少条\r}", required = true, dataType = "PageableQueryParam", paramType = "body")
    })//描述方法参数信息，paramType值path
    @PostMapping("/find/all")
    PageableList<UserInfo> getAll(PageableQueryParam param);
}



