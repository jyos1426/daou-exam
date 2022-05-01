package com.example.demo.mapper;

import com.example.demo.domain.Member;
import org.apache.ibatis.annotations.Mapper;

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
     * 
     * @param member
     */
    void insertMember(Member member);

    /**
     * 사원 Update
     * 
     * @param member
     */
    void updateMember(Member member);
}
