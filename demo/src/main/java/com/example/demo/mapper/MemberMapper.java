package com.example.demo.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Member;

/**
 * 사원 DB Mapper
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Mapper
public interface MemberMapper {
    /**
     * 사원 Insert
     * @param member
     */
    void insertMember(Member member);

    /**
     * 사원 Update
     * @param member
     */
    void updateMember(Member member);
}
