package cn.elvea.platform.security.web;

import cn.elvea.platform.commons.constants.SecurityConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * ConfirmAccessController
 *
 * @author elvea
 */
@Controller
@SessionAttributes("authorizationRequest")
public class ConfirmAccessController {

    /**
     * 自定义确认授权页面
     */
    @RequestMapping(SecurityConstants.AUTH_CONFIRM_ACCESS_PATH)
    public String getAccessConfirmation() {
        return "confirm_access";
    }

    /**
     * 自定义授权错误页面
     */
    @RequestMapping(SecurityConstants.AUTH_ERROR_PATH)
    public String getError() {
        return "error";
    }

}
