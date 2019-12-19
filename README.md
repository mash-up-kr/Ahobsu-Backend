<h1 align="center">Welcome to ahobsu 👋</h1>
<p>
  <img src="https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000" />
</p>

# MashUp Spring Kotlin Project

## 매일매일 미션을 수행하며 카드를 수집해 보자

### 주요 기능

- 로그인 회원가입
  - 구글 로그인
  - 애플 로그인
- 매일 새로운 미션 제공
- 주별로 새로운 카드 세트 제공
- 미션 재발급 기능(제한적으로 제공)

### 폴더 구조

### Quick Start

- src/resources/application.yml 추가

```yml
spring:
  datasource:
    url: <URL>
    username: <USERNAME>
    password: <PASSWORD>
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    database-platform: org.hibernate.dialect.MySQL5Dialect
    show-sql: true
    generate-ddl: true
    open-in-view: false
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        format_sql: true
```

### TEST

- 추가 필요

### 써드파티 패키지

| 모듈 | 역할 | 사용한 부분 |
| ---- | ---- | ----------- |


## Author

👤 **YuChocopie**

<img src="https://avatars2.githubusercontent.com/u/18034145?s=460&v=4" width=80/>

Github: [@YuChocopie](https://github.com/YuChocopie)

👤 **Yuni-Q**

<img src="https://avatars0.githubusercontent.com/u/18049757?s=460&v=4" width=80/>

Github: [@Yuni-Q](https://github.com/Yuni-Q)

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page](https://github.com/mash-up-kr/Ahobsu-Backend/issues).

## Show your support

Give a ⭐️ if this project helped you!

---

_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
