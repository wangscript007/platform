package cn.elvea.platform.core.system.web;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author elvea
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "User", tags = "用户")
public class UserController {
}
