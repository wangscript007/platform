package cn.elvea.platform.core.system.web;

import cn.elvea.platform.commons.constants.SystemConstants;
import cn.elvea.platform.commons.web.WebResponse;
import com.google.common.collect.Maps;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * DefaultController
 *
 * @author elvea
 */
@RestController
@Tag(name = "Default", description = "默认控制器")
public class DefaultController {

    /**
     * 获取当前应用版本
     *
     * @return 应用版本号
     */
    @Operation(summary = "默认控制器")
    @ApiResponse(description = "当前应用版本号")
    @GetMapping("/api/version")
    public WebResponse<?> version() {
        Map<String, Object> data = Maps.newLinkedHashMap();
        data.put("version", SystemConstants.VERSION);
        data.put("now", LocalDateTime.now());
        return WebResponse.success(data);
    }

}
