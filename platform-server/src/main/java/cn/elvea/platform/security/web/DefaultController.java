package cn.elvea.platform.security.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DefaultController
 *
 * @author elvea
 */
@RestController
public class DefaultController {

    @RequestMapping("/api/version")
    public String version() {
        return "1.0.0";
    }

}
