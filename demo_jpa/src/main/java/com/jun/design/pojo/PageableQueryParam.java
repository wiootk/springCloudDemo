package com.jun.design.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class PageableQueryParam implements Serializable {
    private static final long serialVersionUID = -3633225672081343653L;
    private int pageNo = 0, pageSize = 10;
    @ApiModelProperty(value = "页码", hidden = false, notes = "页码", required = true, dataType = "int")
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    @ApiModelProperty(value = "每页多少条", hidden = false, notes = "每页多少条", required = true, dataType = "int")
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

