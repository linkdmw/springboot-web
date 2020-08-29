# Springboot-Web

自用学习，一个简单的使用springboot开发的简单WEB项目demo，实现了基本的登录退出以及一个模块的基本增删改查；

### 技术栈

-   SpringBoot 2.3.2
-   Thymeleaf+BootStrap
-   MySQL 8.0
-   Shiro
-   Swagger

### 日志

<u>2020.8.27</u>

```
检查项目
目前已完成登录+拦截器实现
使用hashmap伪造数据完成基本的增删改查
前端界面整合thymeleaf与bootstrap
登录界面国际化（i18n）
```
`后期目标`
-   [x] 整合druid数据源，连接mysql
-   [ ] 整合shiro完成授权与认证
-   [ ] 整合Swagger

<u>2020.8.29   8:13</u>
```
昨天完成了整合MySQL，新建了员工、部门、用户表；实现了按用户表登录，员工-部门的多对一查询；
考虑到开发顺序，因此决定先整合swagger再完善后面的增删改查项目
整合swagger之前使用log4j+slf2j失败，出现了兼容错误；因此改回sringboot默认的logback日志系统
今天目标：整合swagger，完成原有增删改查改用mybatis（原开发时使用hashmap伪造数据，没有实现dao层），整合shiro
```
