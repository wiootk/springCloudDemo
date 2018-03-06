package com.jun.design.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageableList<T> implements Serializable {
    private static final long serialVersionUID = 768859725396601724L;
    private int pageNo=1, totalPages, pageSize=10;
    private long totalRecords;
    private List<T> records = new ArrayList<T>();
    @ApiModelProperty(value = "页码", hidden = false, notes = "页码", required = true, dataType = "int")
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    @ApiModelProperty(value = "总页数", hidden = false, notes = "总页数", required = true, dataType = "int")
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    @ApiModelProperty(value = "每页多少条", hidden = false, notes = "每页多少条", required = true, dataType = "int")
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    @ApiModelProperty(value = "总条数", hidden = false, notes = "总条数", required = true, dataType = "int")
    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }
    @ApiModelProperty(value = "数据列表", hidden = false, notes = "数据列表", required = true, dataType = "List")
    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
