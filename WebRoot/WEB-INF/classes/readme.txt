��ϵͳ�Ĺ��ܷ�Ϊ��
common(goLogin,quit,passwordupdate)
TeacherManager()
StudentManager();
DomitoryManager();
BuildingManager();


ѧ������(StudentManager)
	1�����ѧ��  
	2���޸�ѧ����
	3���г�ѧ��
	 4��ɾ��ѧ�� 
 	5����ѯѧ��(��ס��������ѧ�š��༶) ��Ȼû���г�����ID�����Ǹ������ݿ���Բ����Ӧ������¥��
	6��ѧ����ס�Ǽ�
	7��ѧ��Ǩ���Ǽ�
	8��ѧ����������
	9��ѧ��ȱ�޵Ǽ�(��ʦ������������ϵͳ����Աֻ�ܲ�ѯ)
��ʦ����(TeacherManager)
	1���г���ʦ 
	2����ӽ�ʦ(�û��������롢�������Ա���ϵ�绰)
	3���޸Ľ�ʦ
	4��ɾ����ʦ
	5����ѯ��ʦ(�������绰���û���)
һ����ʦ���Թ�����¥�һ��¥����Ա������ʦ����(��Զ�Ĺ�ϵ)
Teacher------>domitory     ��Զ�Ĺ�ϵ

¥�����
	1���г�  (���ơ���顢����[����Ա���޸ġ�ɾ��])
	2���޸�
	3��ɾ��
	4���������Ա(TBManager)����TBManager.jspҲû�г���Ӧ¥��Ĺ���Ա(ע��һ��¥������ж������Ա)��
	5����TBManager.jsp���й�����ӹ���Ա�Ĳ���(�����ӵĹ���Ա�Ѿ������ڴ�¥�㵱�С������ظ����)

�������
	1���г�����(¥��š����Һš�����)����������
	2���������
	3��ɾ��
	4���޸�
	5����ѯ(ȫ��¥����Һ�)
�������ȣ�
	
	
common������
	��½
	�޸�����
	�˳���½
	
	
admin( Admin_ID
 Admin_Username
 Admin_Password
 Admin_Name
 Admin_Sex
 Admin_Tel)
 
building( Building_ID ��
 Building_Name ��
 Building_Introduction)

domitory:(
 Domitory_ID ��
 Domitory_BuildingID �� 
 Domitory_Name �� 
 Domitory_Type �� 
 Domitory_Number ��
 Domitory_Tel )

stduent��
Student_ID ��
 Student_DomitoryID ��
 Student_Username �� 
 Student_Password ��
 Student_Name �� 
 Student_Sex �� 
 Student_Class �� 
 Student_State 
 )
	
teacher(
Teacher_ID 
Teacher_Username 
Teacher_Password 
Teacher_Name     
Teacher_Sex 
Teacher_Tel )


TB(��Զ��ϵ��¥�ܺ�¥��֮����м��)
 TB_ID
 TB_TeacherID
 TB_BuildingID
 )


�������ȱ�
(id,

����š�
���ڡ�(�������)
������
������
�ڼ��ܡ�
����
:��֡��޸ġ�ɾ��
)

һ������ÿ��ֻ�Ǵ�һ�η����������Ӵ�ֵ�ʱ�򡢸������Ѿ���������ˡ��Ͳ�Ӧ�ô�֡���ʾ�Ѿ����������

create table hygiene(
id int primary key auto_increment,
Domitory_ID int,
score int,
week int,
teacher_ID,
)


�����������ã�
	��������ʵ����AOP(����������)�ı��˼�롢������������Action����֮ǰ
	����Action�������֮�󡢲��뿪�����Զ���Ĵ���
Ӧ�ã�
	1������Ȩ�޿���(���������Ƿ��ǵ�¼�û��������Ƿ����㹻�ķ���Ȩ��)
	2��������־(��¼ÿ��������������ÿһ��Action)
	3������ϵͳ������ƿ��(���ǿ���ͨ����¼ÿһ��Action��ʼ����ʱ��
	�ͽ�������ʱ�䡢�Ӷ�ȡ�ú�ʱ�ϳ���Action)
struts2Ҳ�����������������һ���γ�һ��������ջ
����������ջ֮ǰ�������ȶ������������ջ�Ķ�����������ӹ�����������������ʵ�ʾ��Ǵ���������
���Struts2��������ջ����������������������������ջ������
<interceptors></interceptors>
//���硢�����Ƕ����������Ĳ���
<interceptors>
	<!--����Ȩ�޼���������-->
	<interceptor name = "authority" class="lee.AuthorityInterceptro">
	<!--������־��¼��������-->
	<interceptor name="log" class="lee.LogInterceptor"/>
	<!--����һ��������ջ-->
	<interceptor-stack name = "authorityandlog">
		<!--����������������log������-->
		<interceptor-ref name = "log">
	</interceptor-stack>
</interceptors>

��action��ʹ����������������ջ�ķ�ʽ�ǣ�
<action name="MyAction" class="lee.MyAction">
	<result name = "success">..</result>
	<interceptor-ref name = "auuthorityandlog"/>
</action>

Struts2������һ�ֿɲ�εķ�ʽ������Action��Ҫ��ɵ�ͨ�ò���������Щͨ�õĲ��������������������Ȼ����
struts.xml�ļ�������Actionʱ�����Action����

����¼��顢��¼��־����һ�����һ��������ջ













