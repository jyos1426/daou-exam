package com.example.demo.mapper;

import com.example.demo.domain.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * 부서 DB Mapper
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Mapper
public interface DeptMapper {
    /**
     * 
     * 부서 Insert
     * 
     * @param dept
     */
    void insertDepartment(Department dept);

    /**
     * 부서 Update
     * 
     * @param dept
     */
    void updateDepartment(Department dept);
}
