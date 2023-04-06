package com.jotime.web.domainVo.print;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author luoYang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicTableParams {
    /**
     * 需要遍历的表格内容
     *
     * @date 19:51 2021/7/8
     */
    private List<List<String>> lists;
    /**
     * 需要展示的标题
     *
     * @date 19:51 2021/7/8
     */
    private String title;

    /**
     * 需要展示的表头上一层代码
     *
     * @date 19:51 2021/7/8
     */
    private String topHtmlCode;
    /**
     * 需要展示的表尾下一层代码
     *
     * @date 19:51 2021/7/8
     */
    private String bottomHtmlCode;
    /**
     * 需要分组的字段索引
     */
    private Integer groupIndex;

    /**
     * 是否横打
     */
    private Boolean beatUp;

    /**
     * 是否显示页脚
     */
    private Boolean showPage;

    /**
     * 控制公共表格字体大小
     */
    private String pageWidth;
    /**
     * 控制公共表格字体大小
     */
    private String pageHeight;
    /**
     * 控制公共表格字体大小
     */
    private String fontSize;

    /**
     * 控制与顶部元素的距离mm为单位
     */
    private String isTop;
    /**
     * 控制与左部元素的距离mm为单位
     */
    private String isLeft;
    /**
     * 控制与右部元素的距离mm为单位
     */
    private String isRight;

    /**
     * 控制与底部元素的距离mm为单位
     */
    private String isBottom;
    /**
     * 固定尺寸规格
     */
    private String paperSize;

    private List<String> widthList;

    public List<List<String>> getLists() {
        return lists;
    }

    public void setLists(List<List<String>> lists) {
        this.lists = lists;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopHtmlCode() {
        return topHtmlCode;
    }

    public void setTopHtmlCode(String topHtmlCode) {
        this.topHtmlCode = topHtmlCode;
    }

    public String getBottomHtmlCode() {
        return bottomHtmlCode;
    }

    public void setBottomHtmlCode(String bottomHtmlCode) {
        this.bottomHtmlCode = bottomHtmlCode;
    }

    public Integer getGroupIndex() {
        return groupIndex;
    }

    public void setGroupIndex(Integer groupIndex) {
        this.groupIndex = groupIndex;
    }

    public Boolean isBeatUp() {
        if (ObjectUtils.isEmpty(beatUp)) {
            return false;
        }
        return beatUp;
    }

    public void setBeatUp(Boolean beatUp) {
        this.beatUp = beatUp;
    }

    public Boolean isShowPage() {
        if (ObjectUtils.isEmpty(showPage)) {
            return true;
        }
        return showPage;
    }

    public void setShowPage(Boolean showPage) {
        this.showPage = showPage;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(String pageWidth) {
        this.pageWidth = pageWidth;
    }

    public String getPageHeight() {
        return pageHeight;
    }

    public void setPageHeight(String pageHeight) {
        this.pageHeight = pageHeight;
    }

    public String getIsTop() {
        return ObjectUtils.isEmpty(isTop) ? "" : isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getIsLeft() {
        return ObjectUtils.isEmpty(isLeft) ? "" : isLeft;
    }

    public void setIsLeft(String isLeft) {
        this.isLeft = isLeft;
    }

    public String getIsRight() {
        return ObjectUtils.isEmpty(isRight) ? "" : isRight;
    }

    public void setIsRight(String isRight) {
        this.isRight = isRight;
    }

    public String getIsBottom() {
        return ObjectUtils.isEmpty(isBottom) ? "" : isBottom;
    }

    public void setIsBottom(String isBottom) {
        this.isBottom = isBottom;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }

    public List<String> getWidthList() {
        return widthList;
    }

    public void setWidthList(List<String> widthList) {
        this.widthList = widthList;
    }
}
