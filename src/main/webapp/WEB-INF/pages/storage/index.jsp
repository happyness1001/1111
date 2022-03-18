  <%--
    Created by IntelliJ IDEA.
    User: LN
    Date: 2021/11/4
    Time: 16:30
    To change this template use File | Settings | File Templates.
  --%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
    <head>
      <title>$Title$</title>
      <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>


    <h2><a class="btn btn-primary" href="${pageContext.request.contextPath}/commodity/allCommodity">查看库存商品</a></h2>
    <h2><a class="btn btn-primary" href="${pageContext.request.contextPath}/order/match">分析订单操作</a></h2>
    <h2><a class="btn btn-primary" href="${pageContext.request.contextPath}/order/map">生成路线</a></h2>
    </body>
  </html>
