package com.lijian.mapper;

import org.apache.ibatis.annotations.Insert;

/**
 * @Author lijia
 * @createTime 2023/5/20 17:03
 */
public interface UserMapper {
    @Insert("")
    public int insertUser();
}
