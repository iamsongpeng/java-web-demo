## 过滤器的使用

* 应用1: 统一全站字符编码过滤器
* 应用2: 自动登陆过滤器
* 应用3: 完全解决get和post乱码的过滤器

### 主要知识点



### 分析

* Dbutils 工具类
* BeanUtils 工具类
* layDate 开源的日期控件与时间插件

### 代码

Servlet技术规范 描述三种技术 ： Servlet(服务器小程序) 、Filter（过滤器）、 Listener（监听器）
1. Filter简介
Filter也称之为过滤器，它是Servlet技术中最实用的技术，WEB开发人员通过Filter技术，对web服务器管理的所有web资源：例如Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，从而实现一些特殊的功能。例如实现URL级别的权限访问控制、过滤敏感词汇、解决get和post乱码等一些高级功能。
 
Servlet API中提供了一个Filter接口，开发web应用时，如果编写的Java类实现了这个接口，则把这个java类称之为过滤器Filter。通过Filter技术，开发人员可以实现用户在访问某个目标资源之前，对访问的请求和响应进行拦截，