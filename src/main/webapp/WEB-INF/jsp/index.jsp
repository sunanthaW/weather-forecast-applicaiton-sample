<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="_shared/header.jsp" />
<script type="text/javascript">
	$(function() {
		var $dateInput = $('#date');
		var $searchForm = $("#searchForm");
		var $region = $("#region");

		$dateInput.datepicker({
			format : 'yyyy-mm-dd',
			startDate : new Date(),
			endDate : '+9D',
		});
		
		$dateInput.on("change",function(e){
			validateInput();
		});
		$region.on("change",function(e){
			validateInput();
		});

		$searchForm.on('submit', function(e) {
			if (validateInput()) {
				$(this).submit();
			} else {
				e.preventDefault();
			}
		});

		function validateInput() {
			var isFormPassValidate = true;

			if ($region.val() === "") {
				isFormPassValidate = false;
				$region.addClass("is-invalid");
			} else {
				$region.removeClass("is-invalid");
			}

			if ($dateInput.val() === "") {
				isFormPassValidate = false;
				$dateInput.addClass("is-invalid");
			} else {
				$dateInput.removeClass("is-invalid");
			}

			return isFormPassValidate;

		}

	});
</script>
<div class="container mt-4">
	<form action="/" method="GET" id="searchForm">
		<div class="form-row mb-2">
			<div class="col-md-4 mb-3">
				<label for="region">ภูมิภาค</label> <select
					class="custom-select mx-2" name="region" id="region">
					<option value="" ${region == "" ? "selected":""}>เลือกภูมิภาค</option>
					<option value="c" ${region == "c" ? "selected":""}>ภาคกลาง</option>
					<option value="n" ${region == "n" ? "selected":""}>ภาคเหนือ</option>
					<option value="ne"  ${region == "ne" ? "selected":""}>ภาคตะวันออกเฉียงเหนือ</option>
					<option value="e"  ${region == "e" ? "selected":""}>ภาคตะวันออก</option>
					<option value="s"  ${region == "s" ? "selected":""}>ภาคใต้</option>
					<option value="w"  ${region == "w" ? "selected":""}>ภาคตะวันตก</option>
				</select>
				<div class="invalid-feedback  text-center">กรุณากรอกภูมิภาค</div>
			</div>
			<div class="col-md-4 mb-3">
				<label for="date">วันที่</label> <input type="text"
					class="form-control mx-2" id="date" autocomplete="off" name="date"
					value="${date}" placeholder="" />
				<div class="invalid-feedback text-center">กรุณากรอกวันที่</div>
			</div>

			<div class="col-md-4 mb-3 mt-2">
				<input type="hidden" value="1" name="duration" required="required" />
				<button type="submit" class="btn btn-primary mt-4">แสดงพยากรณ์อากาศ</button>
			</div>

		</div>
	</form>
	<div class="table-responsive-lg">
		<h3>รายการพยากรณ์อากาศ</h3>
		<table class="table table-hover table-sn border">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">จังหวัด</th>
					<th scope="col">อุณหภูมิสูงสุด ที่ระดับพื้นผิว</th>
					<th scope="col">อุณหภูมิต่ำสุด ที่ระดับพื้นผิว</th>
					<th scope="col">สภาพอากาศโดยทั่วไป</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${!empty weahterModel}">
						<c:forEach items="${weahterModel.weatherForecasts}"
							varStatus="loop" var="weatherForecast">
							<tr>
								<th scope="row">${loop.index+1}</th>
								<td>${weatherForecast.location.province}</td>
								<td>${weatherForecast.forecasts[0].data.tcMax}</td>
								<td>${weatherForecast.forecasts[0].data.tcMin}</td>
								<c:set var="conds" scope="session"
									value="${weatherForecast.forecasts[0].data.cond-1 }"></c:set>
								<td>${cond[conds]}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>

						<tr>
							<td colspan="5">
								<p class="text-center">กรุณาเลือกภูมิภาคและวันที่</p>
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>


<jsp:include page="_shared/footer.jsp" />