<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pages">
	<a href="productList?level=${level }&id=${id }&page=1" class="p_pre">首页</a>
	<a href="productList?level=${level }&id=${id }&page=${page-1}" class="p_pre">上一页</a>
	<a href="javascript:void(0);" class="cur">${page }/${pages }</a>
	<a href="productList?level=${level }&id=${id }&page=${page+1}" class="p_pre">下一页</a>
	<a href="productList?level=${level }&id=${id }&page=${pages}" class="p_pre">尾页</a>
</div>