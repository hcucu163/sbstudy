   - [ ] 创建 Dockerfile：编写 Dockerfile 来定义如何构建 Docker 镜像。
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



在 IntelliJ IDEA 中将 Spring Boot 项目打包成微服务并部署到 Docker 中涉及几个步骤。以下是详细的步骤指南：

### 1. 打包 Spring Boot 项目

首先，你需要将 Spring Boot 项目打包成一个可执行的 JAR 文件。

#### 使用 Maven 打包

1. **打开终端**：在 IntelliJ IDEA 中打开终端（Terminal）。
2. **运行 Maven 打包命令**：

   ```bash
   mvn clean package
   ```


这将会清理项目、编译源代码、运行测试并打包成一个 JAR 文件。打包后的 JAR 文件通常位于 `target` 目录下。

### 2. 创建 Dockerfile

在项目的根目录下创建一个名为 `Dockerfile` 的文件，并添加以下内容：

```Dockerfile
# 使用官方的 OpenJDK 镜像作为基础镜像
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 将打包好的 JAR 文件复制到镜像中
COPY target/sbstudy-0.0.1-SNAPSHOT.jar /app/sbstudy.jar

# 暴露应用的端口
EXPOSE 8080

# 定义启动命令
ENTRYPOINT ["java", "-jar", "sbstudy.jar"]
```


### 3. 构建 Docker 镜像

在 IntelliJ IDEA 的终端中，导航到包含 `Dockerfile` 的项目根目录，然后运行以下命令来构建 Docker 镜像：
-t是--tag的缩写

```bash
docker build -t sbstudy:latest .
```


这将会根据 `Dockerfile` 中的指令构建一个名为 `sbstudy` 的 Docker 镜像，标签为 `latest`。

### 4. 运行 Docker 容器

构建完成后，你可以使用以下命令来运行 Docker 容器：

```bash
docker run -d -p 8080:8080 --name sbstudy-container sbstudy:latest
```


这将会在后台运行一个名为 `sbstudy-container` 的容器，并将容器的 8080 端口映射到主机的 8080 端口。

### 5. 验证部署

你可以通过浏览器或 `curl` 命令来验证应用是否正常运行。例如：

```bash
curl http://localhost:8080
```


或者在浏览器中访问 `http://localhost:8080`。

### 6. 推送镜像到 Docker Hub（可选）

如果你希望将 Docker 镜像推送到 Docker Hub，可以按照以下步骤操作：

1. **登录 Docker Hub**：

   ```bash
   docker login
   ```


2. **标记镜像**：

   ```bash
   docker tag sbstudy:latest your-dockerhub-username/sbstudy:latest
   ```


3. **推送镜像**：

   ```bash
   docker push your-dockerhub-username/sbstudy:latest
   ```


### 7. 在远程服务器上部署（可选）

如果你希望在远程服务器上部署 Docker 容器，可以按照以下步骤操作：

1. **登录到远程服务器**：

   ```bash
   ssh your-remote-server
   ```


2. **拉取镜像**：

   ```bash
   docker pull your-dockerhub-username/sbstudy:latest
   ```


3. **运行容器**：

   ```bash
   docker run -d -p 8080:8080 --name sbstudy-container your-dockerhub-username/sbstudy:latest
   ```


### 总结

1. **打包 Spring Boot 项目**：使用 Maven 打包成 JAR 文件。
2. **创建 Dockerfile**：编写 Dockerfile 来定义如何构建 Docker 镜像。
3. **构建 Docker 镜像**：使用 `docker build` 命令构建镜像。
4. **运行 Docker 容器**：使用 `docker run` 命令运行容器。
5. **验证部署**：检查应用是否正常运行。
6. **推送镜像到 Docker Hub**（可选）：将镜像推送到 Docker Hub。
7. **在远程服务器上部署**（可选）：在远程服务器上拉取Docker Hub的镜像并运行容器。

通过以上步骤，你可以在 IntelliJ IDEA 中将 Spring Boot 项目打包成微服务并部署到 Docker 中。