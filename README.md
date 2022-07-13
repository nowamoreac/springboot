# 一个简单的前后端分离的管理系统
### 项目介绍
拥有最基本的注册，登录，数据管理。可以使用excle来进行数据的导入和导出。
### 项目展示
登录界面
![图片](https://user-images.githubusercontent.com/76742505/175867033-c34205f8-6c0a-40b3-8c5d-5742809b4660.png)
注册
![图片](https://user-images.githubusercontent.com/76742505/175867258-5b77652d-2011-49b3-894f-4b157554e760.png)

后台
![图片](https://user-images.githubusercontent.com/76742505/175867122-d90a24ef-c5d8-4e64-9d59-18308c1d85ad.png)
数据管理
![图片](https://user-images.githubusercontent.com/76742505/175867183-5608754e-338d-4a05-993b-260e70e1ac82.png)


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
    ├── common
    ├── config
    ├── controller
    ├── entity
    ├── mapper
    ├── Exception
    ├── service
    ├── utils
    └── SpringbootApplication
├── resources
    ├── mapper
    ├── META-INF
    ├── static
    ├── template
    └── application.yml
    
```

### 开发时遇到的错误
1. mybatis-plus出现Not Found TableInfoCache | https://blog.csdn.net/m0_52532885/article/details/124124332?spm=1001.2014.3001.5501
2. mapperscan相关问题 | 尽量还是打上mapper 
<!-- 3. （不要靠近mapperscan，会变得不幸😅） -->


<a target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=G3dyYnpxbnUqKSooI1tqajV4dHY" style="text-decoration:none;"><img src="http://rescdn.qqmail.com/zh_CN/htmledition/images/function/qm_open/ico_mailme_12.png"/></a>
