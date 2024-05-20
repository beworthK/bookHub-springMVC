<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/include/admin/header.jsp" %>
<!--  


-->

<div class="container-fluid px-4">
    <h1 class="mt-4">도서 관리 페이지</h1>
    <ol class="breadcrumb mb-4">
       
    </ol>
    <div class="card mb-4">
        <div class="card-body">
			<!-- 분류표기 -->
			
        </div>
    </div>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            도서 목록
        </div>
        <div class="card-body">
            <div id="bookMngGrid">
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	
	const grid = new tui.Grid({
		el: document.getElementById('bookMngGrid'),
		scrollX: false,
	    scrollY: false,
		columns: [ 
			{ header: 'No', name: 'no' },
 			{ header: 'Category', name: '카테고리' },
			{ header: 'Name', name: '제목'},
		],
		
	});
	
	
});
</script>

<%@ include file="/include/admin/footer.jsp" %>