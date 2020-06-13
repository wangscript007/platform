package cn.elvea.platform.commons.user;

import java.io.Serializable;

/**
 * User
 *
 * @author elvea
 */
public interface User extends Serializable {

    Long getId();

    String getUsername();

}
