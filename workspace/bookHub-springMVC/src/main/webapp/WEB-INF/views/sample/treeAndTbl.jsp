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
        <div class="card-body d-flex">
        	<div id="ctgrGrid" class="w-25 me-4">
        	</div>
            <div id="bookGrid" class="w-75">
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	
	//const ctgrTreeData = 
	// console.log('${ctgrList}');
	
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
	
	var dataList = '${dateList}';
	var ctgrList = JSON.parse(dataList);
	
	var ctgrArr = new Array();
	
	var childArr = new Array();
	var parent_ctgr = "";
	var parentMap = new Map();
	
	for(var i=0; i<ctgrList.length; i++) {
		
	 	if(i==0){ //첫번째 데이터
	 		parent_ctgr =  ctgrList[i].ctgr_id;
     		
	 		parentMap.set('id', ctgrList[i].ctgr_id);
	 		parentMap.set('name', ctgrList[i].ctgr_nm);
	 		continue;
	 	}
	 	
	 	if(ctgrList[i].parent_ctgr === parent_ctgr){ //자식 노드
	 		
	 		childArr.push({
	 			id: ctgrList[i].ctgr_id,
	 			name: ctgrList[i].ctgr_nm,
	 		});
	 	
	 	}else{ //부모 노드
	 		
	 		ctgrArr.push({
	 			id: parentMap.get('id'), //부모 값 
	 			name: parentMap.get('name'),// 부모 갑
	 			_children: childArr,
	 		});
	 		
	 		childArr = []; // 자식 배열 초기화 
	 		// 부모정보 새로 담기
	 		parent_ctgr =  ctgrList[i].ctgr_id;
		 	
	 		parentMap.set('id', ctgrList[i].ctgr_id);
	 		parentMap.set('name', ctgrList[i].ctgr_nm);
	 		
	 	}
	 	
	} // end for
	
	//console.log(JSON.stringify(ctgrArr));
	
	ctgrGrid.resetData(ctgrArr);
	ctgrGrid.expandAll();
	

	// grid 확장 이벤트
	// ctgrGrid.on('expand', ev => {
	// 	const { rowKey } = ev;
	// 	const descendantRows = ctgrGrid.getDescendantRows(rowKey);
	// 		
	// 	console.log('rowKey: ' + rowKey);
	// 	console.log('descendantRows: ' + descendantRows);
	// 		
	// 	if (!descendantRows.length) {
	// 		ctgrGrid.appendRow(
	// 			{
	// 				name: 'dynamic loading data',
	// 				_children: [
	// 					{
	// 					  name: 'leaf row'
	// 					},
	// 					{
	// 					  name: 'internal row',
	// 					  _children: []
	// 					}
	// 		    	]
	// 			},
	// 			{ parentRowKey: rowKey }
	// 		);
	// 	}
	// });
	
	// gird 축소 이벤트
	// ctgrGrid.on('collapse', ev => {
	// 	const { rowKey } = ev;
	// 	const descendantRows = ctgrGrid.getDescendantRows(rowKey);
	// 	
	// 	console.log('rowKey: ' + rowKey);
	// 	console.log('descendantRows: ' + descendantRows);
	// });
	  
	
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
	
	
});
</script>

<%@ include file="/include/admin/footer.jsp" %>