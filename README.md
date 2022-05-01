## 1. 개요

요구사항에 맞춰 조직도를 조회, 추가, 수정, 삭제할 수있는 API를 개발한다.

## 2. 프로젝트 환경

- Tool: Visual Studio Code
- build: Maven
- Language: JavA 8
- Springboot version: 2.6.7
- DB: Oracle / ojdbc8 / Mbatis 


## 3. 프로젝트 실행 및 테스트 방법

1. git project 를 clone 받습니다.
2. Oracle을 설치합니다.
3. 다음 sample.sql 내용으로 Table과 Data를 생성합니다.
- __[sample.sql](https://github.com/jyos1426/daou-exam/blob/master/sample.sql)__ - Oracle Samepl SQL
4. application.properties 파일의 Oracle 연동 설정과 포트를 변경해줍니다.
- 설정 예시
```
server.port=4000

# DB Setting (Oracle)
spring.datasource.driverClassName=oracle.jdbc.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@//127.0.0.1:1521/xe
spring.datasource.username=[username]
spring.datasource.password=[password]

# Show parameter binding
logging.level.org.hibernate.type.descriptor.sql=DEBUG

# Show sql
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true

# Set Mybatis mapper location
mybatis.mapper-locations=classpath:mybatis-mapper/*.xml

# Use vo aliases
mybatis.type-aliases-package=com.example.demo.vo

# For swagger error
spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER
```
5. Java 프로젝트를 실행합니다.
6. Swagger 페이지에 접속하여, api 문서를 확인하고 요청을 테스트 합니다.

- `http://localhost:{port}/swagger-ui/index.html`

## 4. API

- ## 조직도 조회 GET /org/organizations 
1. Parameters

| Key | Type | Example | required |  Comment |
| --- | --- | --- | --- | --- |
| deptCode | String | "A10000" | false | 최상위 부서 선택 |
| deptOnly | boolean | true | false |  부서만 검색 여부, 없을 시 default 최상위 부서 (회사) |
| searchType | String | "member" / "dept" | false  | 검색어 적용 대상 |
| searchKeyword | String | "플랫폼" | false  | 검색어 |

```js
/org/organizations?deptCode=A00000&deptOnly=true
```