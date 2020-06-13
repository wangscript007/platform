package cn.elvea.platform.commons;

import cn.elvea.platform.commons.sequence.IdWorker;
import cn.elvea.platform.commons.user.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Context
 *
 * @author elvea
 */
public class Context {

    private IdWorker idWorker;

    @Autowired
    public Context(IdWorker idWorker) {
        this.idWorker = idWorker;
    }

    /**
     * 生成唯一主键
     *
     * @return 主键
     */
    public Long generateNextId() {
        return this.idWorker.nextId();
    }

    /**
     * 生成唯一主键
     *
     * @return 主键
     */
    public User getCurrentUser() {
        return new User() {
            @Override
            public Long getId() {
                return 1L;
            }

            @Override
            public String getUsername() {
                return "admin";
            }
        };
    }

}
