## 1. 개요

요구사항에 맞춰 조직도를 조회, 추가, 수정, 삭제할 수있는 API를 개발한다.

## 2. 프로젝트 환경

- Too: Visual Studio Code
- build: Maven
- Language: JavA 8
- Springboot version: 2.6.7
- DB: Oracle / ojdbc8 / Mbatis   

## 3. 프로젝트 실행 방법



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
- ### 부서 등록 POST /org/

1. Request Body

| Key | Type | Example | required |  Comment |
| --- | --- | --- | --- | --- |
| name | String | "A10000" | true | 사원명 |
| parentOrgId | int | 10 | true | 상위 조직(부서) Id |
| manager | boolean | "플랫폼" | true | 관리자 여부 |

<details><summary>example (클릭)
</summary>

```json
{
    "name": "김다우",
    "parentOrgId": 4,
    "manager": false
}
```
</details>


2. Response
```json
{
    "orgId": 44,
    "parentOrgId": 4,
    "name": "김다우1",
    "type": "Member",
    "manager": false
}
```
- ### 부서 등록 PUT /org/
- ### 부서 등록 DELETE /org/
- ### 사원 등록 POST /org/
- ### 사원 등록 PUT /org/
- ### 사원 등록 DELETE /org/


