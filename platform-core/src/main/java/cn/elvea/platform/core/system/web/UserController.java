package cn.elvea.platform.core.system.web;

import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/api/user")
@Tag(name = "User", description = "用户控制器")
public class UserController {
}
