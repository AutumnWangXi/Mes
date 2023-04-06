package com.jotime.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="chenkuo")
public class BootdoConfig {
	//上传路径
	private String uploadPath;

	private String imgUpldaPath;

	private String imgPath;

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getImgUpldaPath() {
		return imgUpldaPath;
	}

	public void setImgUpldaPath(String imgUpldaPath) {
		this.imgUpldaPath = imgUpldaPath;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}
