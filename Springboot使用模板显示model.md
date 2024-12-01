在 Spring Boot 中，使用 Controller 将 Model 数据传递给 View 并显示的步骤通常包括以下几个部分：

1. **配置视图解析器（View Resolver）**：确保 Spring Boot 能够找到并解析视图文件。
2. **创建 Controller**：定义处理请求的控制器方法。
3. **创建 Model**：定义数据模型。
4. **创建 View**：定义视图文件，通常使用 Thymeleaf、JSP 或其他模板引擎。
5. **将 Model 传递给 View**：在 Controller 中将数据添加到 Model 中，并返回视图名称。

下面是一个详细的步骤说明，以 Thymeleaf 为例：

### 1. 配置视图解析器（View Resolver）

首先，确保在项目的依赖中包含 Thymeleaf。如果你使用的是 Maven，可以在 `pom.xml` 中添加以下依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```


Spring Boot 会自动配置 Thymeleaf 视图解析器，因此不需要额外的配置。

### 2. 创建 Controller

定义一个 Controller 类来处理请求，并将数据传递给视图。例如：

```java
package com.blackmyth.learning.sbstudy.controller;

import com.blackmyth.learning.sbstudy.model.User;
import com.blackmyth.learning.sbstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public String findUserById(@PathVariable Integer id, Model model) {
        User user = userService.getUserById(id).orElse(null);
        model.addAttribute("user", user);
        return "user"; // 返回视图名称
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users"; // 返回视图名称
    }
}
```


### 3. 创建 Model

定义数据模型类。例如：

```java
package com.blackmyth.learning.sbstudy.model;

public class User {
    private Integer id;
    private String name;
    private String password;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
```


### 4. 创建 View

创建 Thymeleaf 模板文件来显示数据。假设视图文件位于 `src/main/resources/templates` 目录下。

#### `user.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User Details</title>
</head>
<body>
    <h1>User Details</h1>
    <div th:if="${user != null}">
        <p>ID: <span th:text="${user.id}"></span></p>
        <p>Name: <span th:text="${user.name}"></span></p>
        <p>Password: <span th:text="${user.password}"></span></p>
    </div>
    <div th:if="${user == null}">
        <p>User not found.</p>
    </div>
</body>
</html>
```


#### `users.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>All Users</title>
</head>
<body>
    <h1>All Users</h1>
    <ul>
        <li th:each="user : ${users}">
            ID: <span th:text="${user.id}"></span>, 
            Name: <span th:text="${user.name}"></span>, 
            Password: <span th:text="${user.password}"></span>
        </li>
    </ul>
</body>
</html>
```


### 5. 将 Model 传递给 View

在 Controller 中，使用 `Model` 对象将数据传递给视图。例如：

```java
@GetMapping("/user/{id}")
public String findUserById(@PathVariable Integer id, Model model) {
    User user = userService.getUserById(id).orElse(null);
    model.addAttribute("user", user);
    return "user"; // 返回视图名称
}

@GetMapping("/users")
public String getAllUsers(Model model) {
    List<User> users = userService.getAllUsers();
    model.addAttribute("users", users);
    return "users"; // 返回视图名称
}
```


### 总结

1. **配置视图解析器**：确保项目中包含 Thymeleaf 依赖。
2. **创建 Controller**：定义处理请求的方法，并将数据添加到 `Model` 中。
3. **创建 Model**：定义数据模型类。
4. **创建 View**：创建 Thymeleaf 模板文件。
5. **传递数据**：在 Controller 中使用 `Model` 对象将数据传递给视图。

通过这些步骤，你可以在 Spring Boot 中使用 Controller 将 Model 数据传递给 View 并显示出来。