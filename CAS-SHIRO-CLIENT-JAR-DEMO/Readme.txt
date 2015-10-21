当前版本需要修改的地方如下：
1.将com.cfilmcloud.auth.base.privilege.extrenal.service 下的所有类换成使用Dubbo接口进行调用。
2.获取该用户信息有两种方式,目前后端使用Session机制获取用户信息，
  (可以创建Session共享服务器，
   修改com.cfilmcloud.auth.base.cas.HashMapBackedSessionMappingStorage即可)