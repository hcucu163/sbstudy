Spring Boot 推荐的项目目录结构遵循 Maven 或 Gradle 的标准目录布局。这种结构有助于组织代码、资源和配置文件，使得项目更加清晰和易于维护。以下是一个典型的 Spring Boot 项目的目录结构：

    ```
    my-spring-boot-app/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── example/
    │   │   │           └── demo/
    │   │   │               ├── controller/
    │   │   │               │   └── HelloController.java
    │   │   │               ├── service/
    │   │   │               │   └── HelloService.java
    │   │   │               ├── repository/
    │   │   │               │   └── UserRepository.java
    │   │   │               ├── config/
    │   │   │               │   └── AppConfig.java
    │   │   │               ├── model/
    │   │   │               │   └── User.java
    │   │   │               └── DemoApplication.java
    │   │   ├── resources/
    │   │   │   ├── application.properties
    │   │   │   ├── static/
    │   │   │   │   ├── css/
    │   │   │   │   ├── js/
    │   │   │   │   └── images/
    │   │   │   └── templates/
    │   │   │       └── index.html
    │   └── test/
    │       └── java/
    │           └── com/
    │               └── example/
    │                   └── demo/
    │                       ├── HelloControllerTest.java
    │                       └── HelloServiceTest.java
    └── pom.xml (或 build.gradle)
    ```


### 目录结构说明
    
1. **src/main/java/**:
   - 存放所有的 Java 源代码。
   - `com.example.demo` 是包名，可以根据实际情况修改。
   - `controller/` 存放控制器类，处理 HTTP 请求。
   - `service/` 存放业务逻辑类。
   - `repository/` 存放数据访问层类，如 JPA Repository。
   - `config/` 存放配置类，如 Spring 配置类。
   - `model/` 存放实体类，如数据库表对应的实体。
   - `DemoApplication.java` 是主启动类，包含 `main` 方法，用于启动 Spring Boot 应用。

   2. **src/main/resources/**:
   - 存放资源文件，如配置文件、静态资源和模板文件。
   - `application.properties` 存放应用的配置属性。
   - `static/` 存放静态资源文件，如 CSS、JavaScript 和图像文件。
   - `templates/` 存放模板文件，如 Thymeleaf 模板。

   3. **src/test/java/**:
   - 存放测试代码。
   - `HelloControllerTest.java` 和 `HelloServiceTest.java` 是示例测试类。

   4. **pom.xml** (Maven) 或 **build.gradle** (Gradle):
   - 项目构建配置文件，定义依赖项、插件等。

### 示例代码

#### `DemoApplication.java`
```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```


#### `HelloController.java`
```java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello World!";
    }
}
```


#### `HelloService.java`
```java
package com.example.demo.service;

public class HelloService {

    public String getGreeting() {
        return "Hello from Service!";
    }
}
```


#### `application.properties`
```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

