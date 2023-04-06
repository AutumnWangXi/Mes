package com.jotime.web.utils.wkhtmltopdf.utils;

import com.jotime.common.pdf.exception.FreeMarkerException;
import com.jotime.common.utils.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

/**
 * 模板工具类
 *
 * @author luoYang
 */
public class FreeMarkerUtil {

    private static final Logger log = LoggerFactory.getLogger(FreeMarkerUtil.class);

    private static final String WINDOWS_SPLIT = "\\";

    private static final String UTF_8 = "UTF-8";


    /**
     * 获取模板
     *
     * @param
     * @return
     * @author LuoYang
     * @date 2019/5/20 11:05
     */
    public static Configuration getConfiguration() {
        //初始化一个模板对象
        Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        config.setDefaultEncoding(UTF_8);
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        config.setLogTemplateExceptions(false);
        //注入freeMaker加载在模板文件夹路径,采用类加载,防止在jar中不能加载成功
        config.setClassForTemplateLoading(FreeMarkerUtil.class, "/templates/");
        return config;

    }

    /**
     * @description 获取模板
     */
    public static String getContent(String fileName, Object data) {
        try {
            //获取加载模板的工具类
            Configuration configuration = getConfiguration();
            //根据模板名称去加载模板
            Template template = configuration.getTemplate(fileName);
            //获取输出流
            StringWriter writer = new StringWriter();

            Properties prop = System.getProperties();

            String os = prop.getProperty("os.name");
            String osName = "";
            String linux = "linux";

            if (os != null && os.toLowerCase().contains(linux)) {
                osName = linux;
            } else {
                osName = "window";
            }

            if (!ObjectUtils.isEmpty(data)) {
                Map<String, Object> data1 = (Map<String, Object>) data;
                data1.put("osName", osName);
                data = data1;
            }
            //将数据注入模板,生成之后写入输出流
            template.process(data, writer);
            //刷新输出流
            writer.flush();
            //返回输出流,并转为String
            return writer.toString();
        } catch (Exception ex) {
            log.error("FreeMarkerUtil process fail", ex);
            throw new FreeMarkerException("FreeMarkerUtil process fail", ex);
        }
    }


    private static String getTemplatePath(String templatePath) {
        if (StringUtils.isEmpty(templatePath)) {
            return "";
        }
        if (templatePath.contains(WINDOWS_SPLIT)) {
            return templatePath.substring(0, templatePath.lastIndexOf(WINDOWS_SPLIT));
        }
        return templatePath.substring(0, templatePath.lastIndexOf("/"));
    }

    private static String getTemplateName(String templatePath) {
        if (StringUtils.isEmpty(templatePath)) {
            return "";
        }
        if (templatePath.contains(WINDOWS_SPLIT)) {
            return templatePath.substring(templatePath.lastIndexOf(WINDOWS_SPLIT) + 1);
        }
        return templatePath.substring(templatePath.lastIndexOf("/") + 1);
    }

    /**
     * @param fileName PDF文件名    (hello.pdf)
     * @return 匹配到的模板名
     * @description 获取PDF的模板路径,
     * 默认按照PDF文件名匹对应模板
     */
    public static String getPdfTemplatePath(String fileName) {
        try {
            ClassPathResource resource = new ClassPathResource("templates/" + fileName);
            File file = resource.getFile();
            if (ObjectUtils.isEmpty(file)) {
                log.error("PDF模板文件不存在,请检查templates文件夹!");
                return null;
            }
            return file.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
