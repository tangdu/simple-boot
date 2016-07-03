#基础镜像：仓库是java，标签用8u66-jdk
FROM mysql/mysql-server
#当前镜像的维护者和联系方式
MAINTAINER tangdu tangdu0228@aliyun.com
#将打包好的spring程序拷贝到容器中的指定位置
ADD  simple-0.1.0.war  simple.war
#容器对外暴露8080端口
EXPOSE 8080
#容器启动后需要执行的命令
CMD java -jar simple.war
