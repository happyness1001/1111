<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar">
    <nav class="sidebar-nav">
        <ul class="nav">

            <li class="nav-title">客户关系管理</li>
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-grid"></i> 客户信息管理 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/customer/list" class="nav-link">
                            <i class="icon icon-user"></i> 客户基本信息管理
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/customerTransaction/data" class="nav-link">
                            <i class="icon icon-plus"></i> 客户流失管理
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/customer/point" class="nav-link">
                            <i class="icon icon-plus"></i> 客户积分管理
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/customer/insert" class="nav-link">
                            <i class="icon icon-plus"></i> 新增客户
                        </a>
                    </li>
                </ul>
            </li>
            <li class="nav-title">数据分析</li>
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-graph"></i> 需求预测(量) <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/bassCalculate/data" class="nav-link">
                            <i class="icon icon-speedometer"></i> 选择数据
                        </a>
                    </li>
                </ul>
                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/sentimentAnalysis/list" class="nav-link">
                            <i class="icon icon-speedometer"></i> 训练集管理
                        </a>
                    </li>
                </ul>
                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/sentimentAnalysis/insert" class="nav-link">
                            <i class="icon icon-speedometer"></i> 添加训练集
                        </a>
                    </li>
                </ul>
            </li>
            <li class="nav-title">关联挖掘</li>
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-graph"></i> 关联挖掘 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/AssociationAnalysis/list" class="nav-link">
                            <i class="icon icon-speedometer"></i> 交易记录
                        </a>
                    </li>
                </ul>
                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/AssociationAnalysis/manage" class="nav-link">
                            <i class="icon icon-speedometer"></i> 关联规则管理
                        </a>
                    </li>
                </ul>
            </li>
            <li class="nav-title">更新推荐评分</li>
            <li class="nav-item ">
                <a href="${pageContext.request.contextPath}/renew" class="nav-link ">
                    <i class="icon icon-graph"></i> 更新推荐评分
                </a>
            </li>
            <li class="nav-title">会员管理</li>
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-graph"></i> 会员管理 <i class="fa fa-caret-left"></i>
                </a>
                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/member/list" class="nav-link">
                            <i class="icon icon-speedometer"></i> 会员等级管理
                        </a>
                    </li>
                </ul>
                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/memberItem/list" class="nav-link">
                            <i class="icon icon-speedometer"></i> 会员个性化服务
                        </a>
                    </li>
                </ul>
            </li>
            <li class="nav-title">供货管理</li>
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-graph"></i> 供货管理 <i class="fa fa-caret-left"></i>
                </a>
                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/supplier/list" class="nav-link">
                            <i class="icon icon-speedometer"></i> 供货记录管理
                        </a>
                    </li>
                </ul>
                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/supplier/recommend" class="nav-link">
                            <i class="icon icon-speedometer"></i> 供货商推荐
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
