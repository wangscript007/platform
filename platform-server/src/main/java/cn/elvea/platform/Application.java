package cn.elvea.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Application
 *
 * @author elvea
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "cn.elvea.platform.config",
        "cn.elvea.platform.commons",
        "cn.elvea.platform.core",
        "cn.elvea.platform.security",
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
