package com.jotime.web.utils.wkhtmltopdf.model;

import java.util.Map;

/**
 * 用于 wkHtmlToPdf 相关的实体类
 *
 * @param
 * @author LuoYang
 * @return
 * @date 2019/5/24 10:36
 */
public class PdfFileRequest {

    /**
     * 软件可执行文件的路径
     *
     * @param
     * @return
     * @author LuoYang
     * @date 2019/5/29 13:40
     */
    private String executableFile;
    /**
     * pdf名称
     *
     * @author LuoYang
     * @date 2019/5/24 17:37
     */
    private String fileName;
    /**
     * 转换成pdf的url源
     *
     * @author LuoYang
     * @date 2019/5/24 17:37
     */
    private String sourceHtmlUrl;
    /**
     * 请求头
     */
    private Map<String, String> requestHeaders;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSourceHtmlUrl() {
        return sourceHtmlUrl;
    }

    public void setSourceHtmlUrl(String sourceHtmlUrl) {
        this.sourceHtmlUrl = sourceHtmlUrl;
    }

    public String getExecutableFile() {
        return executableFile;
    }

    public void setExecutableFile(String executableFile) {
        this.executableFile = executableFile;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }
}
