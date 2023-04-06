package com.jotime.common.utils.joTime;



import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;

/**
    入库阶段名称转换
* */
public enum StageName {

    FIRST("第一阶段", 1),SECOND("第二阶段入库待检", 2), THIRD("第三阶段质检", 3), FOURTH("第四阶段入库", 4)
    ,Five("第二阶段", 5),Sex("第三阶段", 6),Seven("第四阶段",7),
    Eight("第二阶段待检",8),;
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    StageName(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 获取阶段int值
    public static int getIndex(@NonNull String name) {
        if (StringUtils.hasText(name)){
            for (StageName c : StageName.values()) {
                if (c.getName().equals(name)) {
                    return c.index;
                }
            }
        }
        return 0;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

}
