1、templates相当于WEB-INF目录，需要视同controller跳转访问页面。
2、static静态资源文件，如CSS/JS等。springboot默认找寻static下面的静态资源文件，
       但不会逐级子级目录查找，只能当前这一级目录，需要将其他静态资源文件配置到static下，详见WebAppConfigurer.java
  thymeleaf代码举例:<img th:src="@{/timg.jpg}"/>