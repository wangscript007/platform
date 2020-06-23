package cn.elvea.platform.core.system.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * UserMapper
 *
 * @author elvea
 */
@Mapper
public interface UserMapper {

    Date search();

}
