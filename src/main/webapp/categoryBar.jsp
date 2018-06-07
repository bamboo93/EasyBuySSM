<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="nav">
	<div class="nav_t">全部商品分类</div>
	<div class="leftNav none" style="display: none;">
		<ul>
			<c:forEach items="${categoryList }" var="category">
				<li>
					<div class="fj">
						<span class="n_img"><span></span> <img src="" /></span> <span
							class="fl">${category.name }</span>
					</div>
					<div class="zj">
						<div class="zj_l">
							<c:forEach items="${category.category }" var="cate2">
								<div class="zj_l_c">
									<h2>
										<a href="productList?level=2&id=${cate2.id }&page=1">${cate2.name }</a>
									</h2>	
									<c:forEach items="${cate2.category }" var="cate3">
										<a href="productList?level=3&id=${cate3.id }&page=1">${cate3.name }</a>|
									</c:forEach>
								</div>
							</c:forEach>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<ul class="menu_r">
	<li><a href="easybuy_queryAll">首页</a></li>
	<c:forEach items="${categoryList }" var="goods">
		<li><a
			href="goodsList_queryGoodsBylevel?level=1&id=${goods.id }&page=1">${goods.name
				}</a></li>
	</c:forEach>
</ul>
<div class="m_ad">中秋送好礼！</div>