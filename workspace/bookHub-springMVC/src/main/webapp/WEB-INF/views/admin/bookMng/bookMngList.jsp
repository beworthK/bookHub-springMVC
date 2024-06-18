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
        	<div class="d-inline-block py-lg-1">
            	<i class="fas fa-table me-1"></i>
            	도서 목록
            </div>
            <div class="btn-wrapper d-inline-block" style="float: right;">
	        	<button class="btn btn-sm btn-add" id="addBookBtn" type="button"><i class="fa-solid fa-plus"></i>도서 등록</button>
      		</div>
        </div>
        <div class="card-body d-flex">
        	<div class="w-20 me-4">
        		<div id="ctgrGrid" ></div>
        	</div>
        	<div class="w-75">
            	<div id="bookGrid"></div>
        	</div>
        </div>
    </div>
</div>


<script type="text/javascript" src="/resources/js/grid.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	// 분류목록
	const ctgrGrid = new tui.Grid({
		el: document.getElementById('ctgrGrid'),
		scrollX: false,
	    scrollY: false,
		columns: [
			{header: '분류코드', name: 'id', hidden: 1,},
			{header: '분류', name: 'name'},
		],
		treeColumnOptions: {
			name: 'name'
		},
	});
	
	// ctgrTreeData
	var treeData;
	$.ajax({
		type: 'post',
		url: '/ajax/getCtgrTreeList',
		data: { ctgr_id: '${categoryVO.ctgr_id}'},
		contentType: "application/json; charset=utf-8",
		success: function(result, status, xhr){
			treeData = gridService.getTreeData(result);
			//console.log(treeData);
			
			ctgrGrid.resetData(treeData)
			ctgrGrid.expandAll();
		},
		error: function(xhr, status, err) {
			if(err){
				console.log(err);
			}
		}
	});
	
	ctgrGrid.on('click', function(ev) {
        var rowKey = ev.rowKey;
        var rowData = ctgrGrid.getRow(rowKey);
        
        console.log(rowData.id);
        // 카테고리 값 기준으로 책 목록 가져오기
    });
	
	  
	// 책 목록 
	const bookGrid = new tui.Grid({
		el: document.getElementById('bookGrid'),
		//scrollX: false,
	    scrollY: false,
		columns: [ 
			{ header: 'no', name: 'no' },
			{ header: 'id', name: 'hide' },
 			{ header: '분류', name: 'Category' },
			{ header: '제목', name: 'title'},
			{ header: '작가', name: 'author'},
			{ header: '출판사', name: 'pub_nm'},
		],
		
	});
	
	/// 도서 등록 페이지 이동
    $('#addBookBtn').on('click', function(){
 		location.href = "/admin/bookMng/bookRegister";
	});
	
	
});
</script>

<%@ include file="/include/admin/footer.jsp" %>