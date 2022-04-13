# 一个简单的前后端分离的管理系统

## 前端技术

| 技术 | 版本 | 官网 |
| :-----| ----: | :----: |
| Vue | 2.6.11 | https://vuejs.org/ |
| Vue-router | 3.2.0 |  	https://router.vuejs.org/ |
| Element | 2.15.6 | https://element.eleme.io |
| Axios | 0.26.1 | https://github.com/axios/axios |
| core-js | 3.6.5 | https://opencollective.com/core-js |


## 前端结构
```
vue
├── src
    ├── assets
    ├── components
    ├── router
    ├── utils
    ├── views
    ├── App.vue
    └── main.js
```
## 后端技术

| 技术 |      版本 | 官网 |
| :-----|--------:| :----: |
| SpringBoot |   2.6.6 |  	https://spring.io/projects/spring-boot |
| swagger |   3.0.0 |  	https://github.com/swagger-api |
| mybatis-plus |   3.5.1 | https://baomidou.com/ |
| mybatis-plus-generator |  0.26.1 | https://github.com/axios/axios |
| lombok | 1.18.22 | https://projectlombok.org/ |
| velocity |   1.7.0 | https://gitee.com/apache/velocity?hmsr=aladdin1e6 |
| hutool |  5.7.20 | https://www.hutool.cn/ |

## 后端结构

```
main
├── springboot
    ├── config
    ├── controller
    ├── entity
    ├── mapper
    ├── service
    ├── utils
    └── SpringbootApplication
├── sources
    ├── mapper
    ├── META-INF
    ├── static
    ├── template
    └── application.yml
    
```

### 开发时遇到的错误
1. mybatis-plus出现Not Found TableInfoCache | https://blog.csdn.net/m0_52532885/article/details/124124332?spm=1001.2014.3001.5501
2. mapperscan相关问题 | 尽量还是打上mapper （不要靠近mapperscan，会变得不幸😅）
