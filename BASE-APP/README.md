#Privilege Auth Framework

1. 使用CAS SSO框架作为单点统一登录.
2. 权限管理模块
3. 与Shiro进行结合，主要针对按钮级权限控制.
 
安装配置:
1.编译源码:
	1). cd all-dependency-infrastructure 
		./compile.sh	
	2). 进行maven 编译.
	3). 需要安装 zookeeper 和 Duubo服务 (目前并没有开启，在使用时，请进行调整).
	将下列package类使用dubbo进行调用，该服务位于privilege-api-server中：
	./BASE-APP/java/privilege-server/src/main/java/com/base/privilege/biz/external 
	4).前端程序，需要nginx服务。
		在nginx中增加:
		========================================================================================
			server {
			        listen       8001;
			        server_name  localhost;
					location ~* \.(eot|otf|ttf|woff|svg)$ {
						add_header Access-Control-Allow-Origin *;
					}

			        #charset koi8-r;
			        #access_log  logs/host.access.log  main;
			        location / {
			            root   html;
			            index  index.html index.htm;
			        }
		========================================================================================
		
	5).运行:
		./build.sh
		mvn jetty:run -Djetty.port=10002
		http://localhost:10002/