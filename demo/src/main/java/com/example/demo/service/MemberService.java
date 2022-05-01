package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.Organization;
import com.example.demo.dto.MemberDto;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.mapper.OrgMapper;
import com.example.demo.error.ErrorCode;
import com.example.demo.error.exception.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 사원 Service 클래스
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Service
public class MemberService {
    static final String ORG_TYPE_MEMBER = "Member" ;

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    OrgMapper orgMapper;

    public MemberService(MemberMapper MemberMapper, OrgMapper orgMapper) {
        this.orgMapper = orgMapper;
        this.memberMapper = MemberMapper;
    }

    /**
     * 사원 추가 Service
     * 
     * @param member 추가할 사원 정보
     * @return 추가된 사원 정보
     */
    public MemberDto addMember(MemberDto member) {
        Organization orgInsertData = new Organization(ORG_TYPE_MEMBER, member.getParentOrgId());

        // Exception. 상위 부서 정보 예외처리
        List<Organization> parentOrgList = orgMapper.getOrgById(member.getParentOrgId());
        if (parentOrgList.size() == 0 || parentOrgList.get(0).getOrgType() == "Manager") {
            throw new CustomException(ErrorCode.BAD_REQUEST, "상위 부서가 정보가 올바르지 않습니다.");
        }

        // Organizaton Table Insert
        orgMapper.insertOrganization(orgInsertData);
        final int orgId = orgInsertData.getOrgId();

        // Member Table Insert
        member.setOrgId(orgId);
        Member memberEntity = new Member(member.getOrgId(), member.getName(), member.isManager());
        memberMapper.insertMember(memberEntity);

        return member;
    }

    /**
     * 사원 수정 Service
     * 
     * @param orgId 수정할 사원의 조직Id
     * @param member 수정할 사원 정보
     * @return 수정된 사원 정보
     */
    public MemberDto modifyMember(int orgId, MemberDto member) {
        // Exception. 사원 정보 예외처리
        List<Organization> orgDataList = orgMapper.getOrgById(orgId);
        if (orgDataList.isEmpty()) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "사원(" + orgId + ")이 존재하지 않습니다.");
        }

        Organization orgData = orgDataList.get(0);
        if (orgData.isMember()) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "코드(" + orgId + ")는 사원 데이터가 아닙니다.");
        }

        // Note. 팀 변경 시 조직도 테이블 함께 변경
        orgData = orgDataList.get(0);
        if (orgData.getParentOrgId() != member.getParentOrgId()) {
            Organization orgUpdateData = new Organization(member.getOrgId(), ORG_TYPE_MEMBER, member.getParentOrgId());
            orgMapper.updateOrganization(orgUpdateData);
        }

        // Member Table Update
        Member memberEntity = new Member(member.getOrgId(), member.getName(), member.isManager());
        memberMapper.updateMember(memberEntity);

        return member;
    }

    /**
     * 사원 삭제 Service
     * 
     * @param orgId 삭제할 사원의 조직 Id
     * @return 삭제된 사원 Id
     */
    public int deleteMember(int orgId) {
        // Exception. 사원 정보 예외처리
        List<Organization> orgDataList = orgMapper.getOrgById(orgId);
        if (orgDataList.isEmpty()) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "사원(" + orgId + ")이 존재하지 않습니다.");
        }

        Organization orgData = orgDataList.get(0);
        if (orgData.isMember()) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "코드(" + orgId + ")는 사원 데이터가 아닙니다.");
        }

        // Note. DELETE CASECADE 로 조직도 삭제 시 함께 DELETE
        orgMapper.deleteOrganization(orgId);
        return orgId;
    }
}
