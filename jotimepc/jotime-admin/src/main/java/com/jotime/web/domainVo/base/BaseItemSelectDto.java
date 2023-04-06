package com.jotime.web.domainVo.base;

import java.util.List;

public class BaseItemSelectDto {

    /**
     * 类型
     */
    private List<Integer> itemType;
    private Integer limit;

    public List<Integer> getItemType() {
        return itemType;
    }

    public void setItemType(List<Integer> itemType) {
        this.itemType = itemType;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
