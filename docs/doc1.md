

* 在 springboot 项目中使用 mybatis 时，需要引入 2 个基础依赖：

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter-test</artifactId>
    <version>3.0.4</version>
    <scope>test</scope>
</dependency>
```

* 配置文件 application.yml 中配置驱动名 `driver-class-name`，和连接地址 `url` 等信息：

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/gradu_pro?serverTimezone=GMT%2b9
    username: root
    password: 123456
```

* 创建和数据表对应的实体类，例如 src/main/java/com/suhy/graduation1/entity/SysUserEntity.java
* 创建对应的 mapper，也就是接口对象
* 给 mapper 类加上 @Mapper 注解，并新增一个 findById 查询方法：

```java
/// src/main/java/com/suhy/graduation1/mapper/SysUserMapper.java
@Mapper
public interface SysUserMapper {

    @Select("select * from sys_user")
    List<SysUserEntity> findAll();

    @Select("select * from sys_user where id = #{id}")
    SysUserEntity findById(Long id);
}
```

* 后续只需将该 SysUserMapper 对象利用 @Autowired 注解，将对象注入到 service 对象中： 

```java
@Autowired
private SysUserMapper sysUserMapper;
```

* 此时，可以直接在 service 的方法中进行调用：

```java
/// src/main/java/com/suhy/graduation1/service/SysUserService.java
// 基于 mapper 对象查询数据
public SysUserEntity findById(Long id) {
    return sysUserMapper.findById(id);
}
```
