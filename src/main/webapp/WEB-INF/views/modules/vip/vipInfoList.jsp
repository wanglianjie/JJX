<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/vip/vipInfo/">会员信息列表</a></li>
		<shiro:hasPermission name="vip:vipInfo:edit"><li><a href="${ctx}/vip/vipInfo/form">会员信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="vipInfo" action="${ctx}/vip/vipInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>会员名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>手机号码：</label>
				<form:input path="mobile" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>会员名称</th>
				<th>会员性别</th>
				<th>所剩次数</th>
				<th>手机号码</th>
				<th>备注信息</th>
				<shiro:hasPermission name="vip:vipInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="vipInfo">
			<tr>
				<td>
					${vipInfo.name}
				</td>
				<td>
					${fns:getDictLabel(vipInfo.sex, 'sex', vipInfo.sex)}
				</td>
				<td>
					${vipInfo.currentTimes}
				</td>
				<td>
					${vipInfo.mobile}
				</td>
				<td>
					${vipInfo.remarks}
				</td>
				<shiro:hasPermission name="vip:vipInfo:edit"><td>
<%--     				<a href="${ctx}/vip/vipInfo/form?id=${vipInfo.id}">修改</a> --%>
    				<a href="${ctx}/vip/vipInfo/form?id=${vipInfo.id}">修改</a>
<%-- 					<a href="${ctx}/vip/vipInfo/delete?id=${vipInfo.id}" onclick="return confirmx('确认要删除该会员信息吗？', this.href)">删除</a> --%>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>