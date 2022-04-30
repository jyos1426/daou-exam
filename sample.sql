-- 조직 테이블 
DROP TABLE organization;
DELETE FROM organization;
CREATE TABLE organization(
    id	NUMBER(10) NOT NULL,
    code	VARCHAR2(8),
    name	VARCHAR2(30),
    TYPE	NUMBER(1),
    manager	NUMBER(1) DEFAULT 0,
    parent_id	NUMBER(10),
    CONSTRAINT	org_pk	PRIMARY KEY (id)
);

-- 부서 INSERT
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 1 , 'A00000', 'ABC회사', 0, 0, NULL );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 2 , 'A10000', '경영지원본부', 1, 0, 1 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 3 , 'A11000', '인사팀', 2, 0, 2 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 4 , 'A12000', '총무팀', 2, 0, 2 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 5 , 'A13000', '법무팀', 2, 0, 2 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 6 , 'A20000', 'SW개발본부', 1, 0, 1 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 7 , 'A21000', '플랫폼개발부', 2, 0, 6 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 8 , 'A21100', '비즈플랫폼팀', 2, 0, 7 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 9 , 'A21200', '비즈서비스팀', 2, 0, 7 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 10 , 'A21300', '그룹웨어개발팀', 2, 0, 7 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 11 , 'A22000', '비즈서비스개발부', 2, 0, 6 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 12 , 'A22100', '플랫폼서비스팀', 2, 0, 11 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 13 , 'A22200', '모바일개발팀', 2, 0, 11 );

-- 부서원 INSERT
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 14 , 'A00001', '사장1', 3, 1, 1 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 15 , 'A10001', '경영1', 3, 1, 2 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 16 , 'A11001', '인사1', 3, 1, 3 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 17 , 'A11002', '인사2', 3, 0, 3 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 18 , 'A11003', '인사3', 3, 0, 3 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 19 , 'A12001', '총무1', 3, 1, 4 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 20 , 'A12002', '총무2', 3, 0, 4 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 21 , 'A13001', '법무1', 3, 1, 5 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 22 , 'A13002', '법무2', 3, 0, 5 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 23 , 'A20001', 'SW1', 3, 1, 6 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 24 , 'A21001', '플랫폼1', 3, 0, 7 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 25 , 'A21101', '플랫폼1', 3, 0, 8 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 26 , 'A22001', '서비스1', 3, 1, 11 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 27 , 'A21102', '개발1', 3, 1, 8 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 28 , 'A21103', '개발2', 3, 0, 8 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 29 , 'A21201', '개발3', 3, 1, 9 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 30 , 'A21202', '개발4', 3, 0, 9 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 31 , 'A21301', '개발5', 3, 1, 10 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 32 , 'A21302', '개발6', 3, 0, 10 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 33 , 'A22101', '개발7', 3, 1, 12 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 34 , 'A22102', '개발8', 3, 0, 12 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 35 , 'A22201', '개발9', 3, 1, 13 );
INSERT INTO organization ( id, code, name, type, manager, parent_id ) VALUES( 36 , 'A22202', '개발10', 3, 0, 13 );