<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<!--<div class="categoryMenu" style="">
<c:forEach items="${cs}" var="c">
    <div cid="${c.id}" class="eachCategory">
    <span class="glyphicon glyphicon-link"></span>
    <a href="forecategory?cid=${c.id}">
    ${c.name}
    </a>
    </div>
</c:forEach>
</div>-->
<!--<div>
<c:forEach items="${cs}" var="c">
    <div cid="${c.id}" style="float: left;margin-left: 20px;margin-right: 20px;margin-top: 10px;margin-bottom: 10px;">
    <span class="glyphicon glyphicon-link" style="color: #ffffff;"></span>
    <a href="forecategory?cid=${c.id}" style="font-size: medium;color: #ffffff;">
    ${c.name}
    </a>
    </div>
</c:forEach>
</div>-->

<c:forEach items="${cs}" var="c">
    <li cid="${c.id}"><a href="forecategory?cid=${c.id}">${c.name}</a> <span class="count">6</span></li>
</c:forEach>