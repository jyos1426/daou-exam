-- 초기 테이블 전체 삭제
DROP TABLE member;
DROP TABLE department;
DROP TABLE organization;
DROP SEQUENCE org_id_seq;

-- 조직 테이블
CREATE TABLE organization (    
    org_id NUMBER(5) PRIMARY KEY,
    org_type VARCHAR2(8),
    parent_org_id NUMBER
);
CREATE SEQUENCE org_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 10000 CYCLE NOCACHE;

-- 부서 테이블
CREATE TABLE department(
    org_id NUMBER(5) PRIMARY KEY,
    dept_code	VARCHAR2(8),
    dept_name	VARCHAR2(30),
    dept_type	VARCHAR2(15),

    CONSTRAINT dep_id_fk FOREIGN KEY(org_id)
         REFERENCES organization(org_id) ON DELETE CASCADE
);

-- 사원 테이블
CREATE TABLE member(
    org_id NUMBER(5) PRIMARY KEY,
    mem_name	VARCHAR2(30),
    manager	NUMBER(1) DEFAULT 0,

    CONSTRAINT mem_id_fk FOREIGN KEY(org_id)
         REFERENCES organization(org_id) ON DELETE CASCADE
);

-- 조직데이터 생성 
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Company', -1 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Division', 1 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Division', 2 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Division', 2 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Division', 2 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Division', 1 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Division', 6 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Team', 7 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Team', 7 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Team', 7 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Team', 6 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Team', 11 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Team', 11 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 1 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 2 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 3 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 3 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 3 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 4 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 4 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 5 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 5 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 6 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 7 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 8 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 11 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 8 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 8 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 9 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 9 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 10 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 10 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 12 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 12 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 13 );
INSERT INTO organization ( org_id, org_type, parent_org_id ) VALUES( org_id_seq.NEXTVAL, 'Member', 13 );

-- 부서 데이터 생성
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 1, 'Company', 'A00000', 'ABC회사' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 2, 'Division', 'A10000', '경영지원본부' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 3, 'Division', 'A11000', '인사팀' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 4, 'Division', 'A12000', '총무팀' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 5, 'Division', 'A13000', '법무팀' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 6, 'Division', 'A20000', 'SW개발본부' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 7, 'Division', 'A21000', '플랫폼개발부' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 8, 'Team', 'A21100', '비즈플랫폼팀' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 9, 'Team', 'A21200', '비즈서비스팀' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 10, 'Team', 'A21300', '그룹웨어개발팀' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 11, 'Team', 'A22000', '비즈서비스개발부' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 12, 'Team', 'A22100', '플랫폼서비스팀' );
INSERT INTO department (org_id, dept_type, dept_code, dept_name) VALUES( 13, 'Team', 'A22200', '모바일개발팀' );

-- 사원 데이터
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 14 , '사장1', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 15 , '경영1', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 16 , '인사1', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 17 , '인사2', 0);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 18 , '인사3', 0);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 19 , '총무1', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 20 , '총무2', 0);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 21 , '법무1', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 22 , '법무2', 0);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 23 , 'SW1', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 24 , '플랫폼1', 0);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 25 , '플랫폼1', 0);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 26 , '서비스1',  1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 27 , '개발1', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 28 , '개발2', 0);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 29 , '개발3', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 30 , '개발4', 0);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 31 , '개발5', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 32 , '개발6', 0);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 33 , '개발7', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 34 , '개발8', 0);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 35 , '개발9', 1);
INSERT INTO member ( org_id, mem_name, manager ) VALUES( 36 , '개발10', 0);
