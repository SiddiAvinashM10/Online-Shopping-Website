<h1 class="my-4">Products List</h1>
<div class="list-group">
	<c:forEach items="${categories}" var="category">
		<a href="<spring:url value = "${contextRoot}/show/category/${category.id}/products"/>" class="list-group-item">${category.name}</a>
	</c:forEach>
</div>