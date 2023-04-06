package com.jotime;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@MapperScan(basePackages = {"com.jotime.system.mapper",
        "com.jotime.quartz.mapper",
        "com.jotime.generator.mapper",
        "com.jotime.web.mapper"
})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy(exposeProxy = true)
public class CosMesApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(CosMesApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "       _ _            ____  _     _\n" +
                "     | (_) __ _  ___/ ___|| |__ (_)\n" +
                "  _  | | |/ _` |/ _ \\___ \\| '_ \\| |\n" +
                " | |_| | | (_| | (_) |__) | | | | |\n" +
                "  \\___/|_|\\__,_|\\___/____/|_| |_|_|\n ");
    }

}
