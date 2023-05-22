package com.lijian.mapper;

import com.lijian.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author lijia
 * @createTime 2023/5/20 17:03
 */
public interface UserMapper {
    @Insert("")
    public int insertUser();

    @Select("select * from user where id = #{id}")
    public User selectById(@Param("id") Integer id);
}
