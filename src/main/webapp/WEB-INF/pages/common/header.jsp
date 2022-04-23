<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar page-header">


    <a class="navbar-brand" href="/">
        <span style="font-size: 18px;">客户管理系统</span>
    </a>

    <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
        <i class="fa fa-bars"></i>
    </a>

    <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <img src="static/images/avatar-1.png" class="avatar avatar-sm" alt="logo">
                <span class="ml-1 d-md-down-none">当前账户：${adminUser.username}</span>
            </a>

            <div class="dropdown-menu dropdown-menu-right">
                <div class="dropdown-header">Account</div>
                <a href="/logout" class="dropdown-item">
                    <i class="fa fa-lock"></i> 退出系统
                </a>
            </div>
        </li>
    </ul>
</nav>
