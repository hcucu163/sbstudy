FROM openjdk:17
LABEL authors="hcucu"

# 设置工作目录
WORKDIR /app

# 将打包好的 JAR 文件复制到镜像中
COPY target/sbstudy-0.0.1-SNAPSHOT.jar /app/sbstudy.jar

# 暴露应用的端口
EXPOSE 8080

# 定义启动命令
ENTRYPOINT ["java", "-jar", "sbstudy.jar"]
