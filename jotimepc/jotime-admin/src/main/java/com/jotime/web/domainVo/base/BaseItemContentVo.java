package com.jotime.web.domainVo.base;

import com.jotime.common.annotation.Excel;
import com.jotime.web.domain.base.BaseItemContent;

/**
 * @Classname BaseItemContentVo
 * @Description
 * @Date 2022/7/12 10:58
 * @Created by 14812
 */
public class BaseItemContentVo extends BaseItemContent {
    /**
     * ID
     */
    private static final long serialVersionUID = 1L;

    /** 成分安全分 */
    @Excel(name = "成分安全分")
    private String safetyScore;

    /** 致痘风险 */
    @Excel(name = "致痘风险")
    private String acneRisk;

    public String getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(String safetyScore) {
        this.safetyScore = safetyScore;
    }

    public String getAcneRisk() {
        return acneRisk;
    }

    public void setAcneRisk(String acneRisk) {
        this.acneRisk = acneRisk;
    }
}
