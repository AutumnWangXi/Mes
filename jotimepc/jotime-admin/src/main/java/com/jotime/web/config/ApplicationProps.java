package com.jotime.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luoYang
 */
@Component
@ConfigurationProperties
public class ApplicationProps {


    private String wkhtmltopdfDir;
    private String errtxtaddress;
    private String errexcleaddress;

    public String getWkhtmltopdfDir() {
        return wkhtmltopdfDir;
    }

    public void setWkhtmltopdfDir(String wkhtmltopdfDir) {
        this.wkhtmltopdfDir = wkhtmltopdfDir;
    }

    public String getErrtxtaddress() {
        return errtxtaddress;
    }

    public void setErrtxtaddress(String errtxtaddress) {
        this.errtxtaddress = errtxtaddress;
    }

    public String getErrexcleaddress() {
        return errexcleaddress;
    }

    public void setErrexcleaddress(String errexcleaddress) {
        this.errexcleaddress = errexcleaddress;
    }
}

