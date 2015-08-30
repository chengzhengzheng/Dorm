将系统的功能分为：
common(goLogin,quit,passwordupdate)
TeacherManager()
StudentManager();
DomitoryManager();
BuildingManager();


学生管理：(StudentManager)
	1、添加学生  
	2、修改学生、
	3、列出学生
	 4、删除学生 
 	5、查询学生(入住、姓名、学号、班级) 虽然没有列出宿舍ID、但是根据数据库可以查出对应的宿舍楼号
	6、学生入住登记
	7、学生迁出登记
	8、学生调换寝室
	9、学生缺寝登记(教师可以这样做、系统管理员只能查询)
教师管理：(TeacherManager)
	1、列出教师 
	2、添加教师(用户名、密码、姓名、性别、联系电话)
	3、修改教师
	4、删除教师
	5、查询教师(姓名、电话、用户名)
一个教师可以管理多个楼宇、一个楼宇可以被多个教师管理(多对多的关系)
Teacher------>domitory     多对多的关系

楼宇管理：
	1、列出  (名称、简介、操作[管理员、修改、删除])
	2、修改
	3、删除
	4、点击管理员(TBManager)进入TBManager.jsp也没列出对应楼宇的管理员(注意一个楼宇可能有多个管理员)、
	5、在TBManager.jsp中有关于添加管理员的操作(如果添加的管理员已经存在于此楼层当中、则不能重复添加)

宿舍管理：
	1、列出宿舍(楼宇号、寝室号、操作)？？？？？
	2、添加宿舍
	3、删除
	4、修改
	5、查询(全部楼宇、寝室号)
卫生评比：
	
	
common：公共
	登陆
	修改密码
	退出登陆
	
	
admin( Admin_ID
 Admin_Username
 Admin_Password
 Admin_Name
 Admin_Sex
 Admin_Tel)
 
building( Building_ID 、
 Building_Name 、
 Building_Introduction)

domitory:(
 Domitory_ID 、
 Domitory_BuildingID 、 
 Domitory_Name 、 
 Domitory_Type 、 
 Domitory_Number 、
 Domitory_Tel )

stduent：
Student_ID 、
 Student_DomitoryID 、
 Student_Username 、 
 Student_Password 、
 Student_Name 、 
 Student_Sex 、 
 Student_Class 、 
 Student_State 
 )
	
teacher(
Teacher_ID 
Teacher_Username 
Teacher_Password 
Teacher_Name     
Teacher_Sex 
Teacher_Tel )


TB(多对多关系：楼管和楼宇之间的中间表)
 TB_ID
 TB_TeacherID
 TB_BuildingID
 )


卫生评比表
(id,

宿舍号、
日期、(打分日期)
评分人
分数、
第几周、
操作
:打分、修改、删除
)

一个宿舍每周只是打一次分数、如果添加打分的时候、该宿舍已经打过分数了、就不应该打分、提示已经打过分数了

create table hygiene(
id int primary key auto_increment,
Domitory_ID int,
score int,
week int,
teacher_ID,
)


拦截器的配置：
	拦截器其实就是AOP(面向切面编程)的编程思想、拦截器允许在Action处理之前
	或者Action处理结束之后、插入开发者自定义的代码
应用：
	1、进行权限控制(检查浏览者是否是登录用户、并且是否有足够的访问权限)
	2、跟踪日志(记录每个浏览者所请求的每一个Action)
	3、跟踪系统的性能瓶颈(我们可以通过记录每一个Action开始处理时间
	和结束处理时间、从而取得耗时较长的Action)
struts2也允许多个拦截器组合在一起、形成一个拦截器栈
定义拦截器栈之前、必须先定义组成拦截器栈的多个拦截器、从功能上来、拦截器的实质就是大拦截器、
因此Struts2把拦截器栈当成拦截器处理、拦截器和拦截器栈都放在
<interceptors></interceptors>
//例如、下面是定义拦截器的部分
<interceptors>
	<!--定义权限检查的拦截器-->
	<interceptor name = "authority" class="lee.AuthorityInterceptro">
	<!--定义日志记录的拦截器-->
	<interceptor name="log" class="lee.LogInterceptor"/>
	<!--定义一个拦截器栈-->
	<interceptor-stack name = "authorityandlog">
		<!--定义该拦截器里包含log拦截器-->
		<interceptor-ref name = "log">
	</interceptor-stack>
</interceptors>

在action中使用拦截器或拦截器栈的方式是：
<action name="MyAction" class="lee.MyAction">
	<result name = "success">..</result>
	<interceptor-ref name = "auuthorityandlog"/>
</action>

Struts2允许以一种可插拔的方式来管理Action需要完成的通用操作，将这些通用的操作定义成拦截器方法、然后再
struts.xml文件中配置Action时引入该Action即可

将登录检查、记录日志放在一起组成一个拦截器栈













