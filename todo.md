- [ ] 理解springboot的启动流程
- [ ] IDEA直接配置docker
- [ ] 使用一个模板库，bootrap, antdesign
- [ ] 使用内置验证器验证表单数据
- [x] 数据库增删改查
- [ ] 数据查询分页
- [ ] 数据查询排序
- [ ] 关系映射，一对多，多对多
- [ ] Spring Security
  - [ ] Shiro
- [ ] Spring Cache - RedisTemplate
- [ ] RabbitMQ
- [ ] 使用JPQL
- [x] 添加路由
- [ ] 单元测试
- [ ] 构建一个CI/CD工作流，自动将改动的代码部署到远程测试服务器(docker)
- [ ] [Springboot打包成微服务并部署在docker](Springboot打包成微服务并部署在docker.md)
  - [x] 创建 Dockerfile：编写 Dockerfile 来定义如何构建 Docker 镜像。
  - [ ] 构建 Docker 镜像：docker build -t sbstudy:latest .
  - [ ] 运行 Docker 容器：docker run -d -p 8080:8080 --name sbstudy-container sbstudy:latest
  - [ ] 验证部署：检查应用是否正常运行。curl http://localhost:8080
  - [ ] 推送镜像到 Docker Hub（可选）：将镜像推送到 Docker Hub。
    - [ ] docker login
    - [ ] docker tag sbstudy:latest your-dockerhub-username/sbstudy:latest
    - [ ] docker push your-dockerhub-username/sbstudy:latest
  - [ ] 在远程服务器上部署（可选）：在远程服务器上拉取Docker Hub的镜像并运行容器。
    - [ ] ssh your-remote-server
    - [ ] docker pull your-dockerhub-username/sbstudy:latest
    - [ ] docker run -d -p 8080:8080 --name sbstudy-container sbstudy:latest



- [x] [使用JPA作数据库增删改查](Springboot使用JPA步骤.md)
  - [x] 在pom.xml中添加JPA和mysql的依赖
  - [x] 在application.properties中添加数据库连接信息
  - [x] 创建一个实体，使用@entity, @table, @column注解
  - [x] 创建一个repository，使用@repository注解
  - [x] 创建一个service，使用@service注解
  - [x] 创建一个controller，使用@controller注解
  - [ ] 创建一个测试类，使用@runWith(SpringRunner.class)和@SpringBootTest注解
- [x] 编写一个service
- [x] @Autowired 做了什么？
- [x] [使用页面模板显示model](Springboot使用模板显示model.md)
  - [x] 添加Thymeleaf依赖
  - [x] 创建一个模板文件
    - [x] 创建.html作为模板文件，放在src/main/resources/templates下
    - [x] 加入 <html xmlns:th="http://www.thymeleaf.org">
    - [x] 使用 thymeleaf的th:text等标签，将model的值显示在页面上 <span th:text="${user.id}"></span>
  - [x] 用@Controller注解创建一个控制器 (不是使用@RestController)
    - [x] 在controller中设置model的值，返回模板文件
    - [x] controller定义中加入Model对象: getAllUsers(Model modelUsers) => users
    - [x] Model.addAttribute("users", users)
    - [x] return "allusers"  (模板文件名: allusers.html)
- [x] [Springboot推荐目录结构.md](Springboot推荐目录结构.md)
- [x] intelliJ idea的ssh插件
  已自带，tools -> start ssh session
- [x] 安装一个数据库服务到docker容器中
  - [x] 找到mysql的docker hub地址: https://hub.docker.com/
  - [x] linux -> docker pull mysql
    - [x] 启动mysql ->       docker run --name mysql-container -v /path/on/host:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=your_password -p 3306:3306 --restart unless-stopped -d mysql
      * --name mysql-container 是给容器指定一个名称
      * -e MYSQL_ROOT_PASSWORD=your_password 是设置 MySQL 的 root 密码
      * -p 3306:3306 是将容器的 3306 端口映射到主机的 3306 端口
      * -d 表示以后台模式运行容器。
      * --restart 自启动
      * -v /path/on/host:/var/lib/mysql 将主机上的 /path/on/host 目录挂载到容器的 /var/lib/mysql 目录
  - [x] 设置mysql为自启动服务 -> systemctl enable docker -> 启动docker时加--restart unless-stopped
  - [x] 配置mysql的本地存储
  - [x] 配置mysql的用户名，密码
  - [x] 配置mysql的端口
  - [x] 在idea中添加mysql服务 -> 使用database标签

