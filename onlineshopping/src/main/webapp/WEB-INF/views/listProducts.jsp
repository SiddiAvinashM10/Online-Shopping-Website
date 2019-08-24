<div class="container">

	<div class="row">

		<!-- disp sidebar -->
		<div class="col-md-3">
			<%@include file="./common/sidebar.jsp"%>
		</div>

		<!-- disp Products -->
		<div class="col-md-9">

			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userClickProducts == true}">
						<script>
							window.categoryId = '';
						</script>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
								<li class="breadcrumb-item active">All Products</li>
							</ol>
						</nav>
					</c:if>

					<c:if test="${userClickProduct == true}">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Product Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>
				</div>

			</div>

		</div>
	</div>

</div>