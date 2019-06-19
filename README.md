# monitor_tuning_Demo
Java性能监控与调优Demo，主要学习各种JDK监控工具以及jvm调优

# 二. Btrace监控工具
参考链接：http://calvin1978.blogcn.com/articles/btrace1.html
## 1. Btrace 入门测试
1. 演示代码为：BtraceController.arg1(@RequestParam("name")String name)
2. Btrace脚本为：PrintArgSimple
3. 启动脚本命令为：btrace 23120 PrintArgSimple.java ，也可以用JVisualVM启动 

---

## 2. Btrace 使用详解
### 2.1 拦截方法
1. 拦截构造函数
	- BtraceController.constructor(User user)
	- PrintConstructor脚本
	-   浏览器访问示例：localhost:8080/btrace/constructor?name=btrace&id=3

2. 拦截同名函数
	- BtraceController.same(@RequestParam("name")String name)、same(@RequestParam("name")String name,@RequestParam("id")int id)
	- 脚本：PrintSameMethod脚本，通过参数个数，和顺序进行匹配。
	-  浏览器访问示例：localhost:8080/btrace/same2?name=btrace&id=3
	


3. 拦截复杂参数
	- 演示代码为：BtraceController. arg2(User user)
	- 脚本：PrintArgComplex ，btrace是利用反射技术获取User字段
	- 执行命令格式（其中-cp 中为 User编译后的class文件所在绝对路径） ：btrace -cp "H:\java\资料\JVM\Java生产环境下性能监控与调优详解\project\o435au\target\classes" $pid PrintArgComplex.java'         
	
4. 正则表达式
 可以用表达式，批量定义需要监控的类与方法。正则表达式需要写在两个 "/" 中间。	
 	- 脚本：PrintRegex，拦截所有BtraceController中的方法

5. 按接口，父类，Annotation定位
比如我想匹配所有的Filter类，在接口或基类的名称前面，加个+ 就行
@OnMethod(clazz="+com.vip.demo.Filter", method="doFilter")
也可以按类或方法上的annotaiton匹配，前面加上@就行
@OnMethod(clazz="@javax.jws.WebService", method="@javax.jws.WebMethod")

---
	
### 2.3 拦截时机
1. 在方法入口处拦截：Kind.ENTRY （默认）
	-   演示代码为：BtraceController.arg1(@RequestParam("name")String name)
	- Btrace脚本为：PrintArgSimple
2. 在方法返回时拦截 Kind.RETURN
	-   演示代码为：BtraceController.arg1(@RequestParam("name")String name)
	- 脚本：PrintReturn
3. 在方法发生异常时拦截 Kind.THROW
	-   演示代码为：BtraceController.exception()
	- 脚本：PrintOnThrow （脚本来自oracle官方）
4. 方法某行是否执行或者方法中哪些行执行
	-   演示代码为：BtraceController.exception()
	- 脚本：PrintLine，其中，location=@Location(value=Kind.LINE, line=-1) 表示方法中打印所有执行行代码，line=36 表示第36行是否执行
	
## 3. 注意事项
1. btrace默认只能本地运行
2. 生产环境下可以使用btrace，但是被btrace注入的代码不会还原，当然，jvm重启是会还原的。

	
	
	
	
	
