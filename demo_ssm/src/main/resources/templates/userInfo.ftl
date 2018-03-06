<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>用户信息</title>
</head>
<body>
<center>
<h1>用户信息</h1>
<p><label>ID</label>${user.id!}</p>
    <p><label>姓名</label>${user.name!}</p>
    <p><label>年龄</label>${user.age!}</p>
</center>
</body>
</html>