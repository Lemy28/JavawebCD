# JavawebCD
JavawebCourseDesign

javaweb作业

## 2021/12/8 在网上找了一个html免费模版，出现问题

解决后发现千万不要乱改前段代码。

## 2021年12月15日 16:08:00  中文乱码问题出现
在通过servlet向数据库添加内容时出现乱码的问题
![image](https://user-images.githubusercontent.com/73866622/146147865-98c307ff-46fc-4a60-b6ef-ff3ea0852fb5.png)
尝试：
（1）
form表单中添加以下属性<form action="" method="" enctype="multipart/form-data" accept-charset="UTF-8"></form>
无法解决问题
（2）设置 request.setCharacterEncoding("UTF-8");意料之中，也无法解决，因为过滤器里已经添加了该语句。
（3）使用item.getString("UTF-8");问题解决

commons-fileupload组件对form提交的文本域进行了处理，如果需要取出其中的文本域值，
有两个重载的方法，分别是item.getString()和item.getString(字符编码集);
commons-fileupload上传中如果form中的参数有中文，此时用item.getString()会出现乱码，
必须用item.getString("UTF-8")，UTF-8为编码方式。


## 2021年12月17日 00:17:08  重大更新！投票系统终于可以投票了。

## 2021年12月17日 14:19:34  实现ajax时，引入的js文件跟前端的js文件发生冲突。