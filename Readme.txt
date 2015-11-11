项目介绍：

1.使用CAS与Shiro结合进行权限认证与授权的SSO 权限管理与认证框架：

BASE-APP: 权限管理与权限服务提供商. 
CAS-SHIRO-CLIENT-JAR: 子系统需要引入的权限jar.
CAS-SHIRO-CLIENT-JAR-DEMO : 引入了权限jar后的子系统的 example.
CAS-SHIRO-CLIENT-DEMO: Client端开发阶段的Demo.
CAS-SHIRO-SERVER-DEMO: CAS Server端开发项目 (需要单独部署).


2.需要根据各个应用系统的框架不同，进行一定的调整。（目前由于框架海没有定，与前端处理机制还没有确定）
3.依赖Zookeeper与dubbo (目前开发阶段并没有调整).
4.正式上线时，考虑Ecache换成其他的Cache. 
5.Mysql数据库