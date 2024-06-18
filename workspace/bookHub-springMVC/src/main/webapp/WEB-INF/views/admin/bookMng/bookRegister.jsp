<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/include/admin/header.jsp" %>
<!--  


-->

<div class="container-fluid px-4">
    <h1 class="mt-4">도서 관리 > 도서 등록</h1>
    
    <div class="row justify-content-center">
	    <div class="col-lg-10">
	        <div class="card rounded-lg mt-5">
	            <div class="card-body">
	                <!-- form -->
	                <form role="form" action="/admin/bookMng/bookRegister" method="post">
	                	<input type="hidden" name="ctgr_id" value="0101" >
	                	
	                	<div class="row mb-5">
	                		<div class="col-md-6">
			                    <div style="height: 100%;">
			                        <label class="form-label mx-sm-2" for="inputFile"><i class="fa-solid fa-image"></i> 도서 이미지</label>

			                        <!-- 썸네일 영역 추가  -->
			                        <input class="form-control mb-2" id="thumbnail" style="height: 70%;"/>
			                        
			                        <input class="form-control d-inline-block" id="inputFile" type="file" />
			                    </div>
			                 </div>
			                 <div class="col-md-6">
			                 	<div class="form-control-plaintext mb-3">
			                        <label class="form-label mx-sm-2" for="inputTitle">제목</label>
			                        <input class="form-control d-inline-block w-70" id="inputTitle" name="title" type="text" placeholder="" />
			                    </div>
			                    <div class="form-control-plaintext mb-3">
			                        <label class="form-label mx-sm-2" for="inputAuthor">저자</label>
			                        <input class="form-control d-inline-block w-70" id="inputAuthor" name="author" type="text" placeholder="" />
			                    </div>
			                    <div class="form-control-plaintext mb-3">
			                        <label class="form-label mx-sm-2" for="inputPubNm">출판사명</label>
			                        <input class="form-control d-inline-block w-70" id="inputPubNm" name="pub_nm" type="text" placeholder="" />
			                    </div>
			                    <div class="form-control-plaintext mb-3">
			                        <label class="form-label mx-sm-2" for="inputAuthor">출간일</label>
			                        <input class="form-control d-inline-block w-70" id="inputAuthor" name="pub_dt" type="date" value="2024-06-04" />
			                    </div>
			                    
		                     </div>
						</div>
						<div class="mt-4 mb-0">
						    <div class="d-grid">
						    	<button type="submit" class="btn btn-success btn-block" id="regBtn">등록하기</button>
						    </div>
						</div>
	                </form>
	                
	            </div>
	        </div>
	    </div>
	</div>
</div>

<!-- form -->
<script type="text/javascript">
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	// 등록버튼 클릭시
	$('#regBtn').on('click',  function(e){
		
		e.preventDefault(); // 첨부파일 관련 처리를 위해 기본동작 막기
		
		//formObj.attr("action", "/admin/bookMng/bookRegister");
		//formObj.attr("method", "post");
		
		formObj.submit();
	});
	
	
	
});
</script>

<%@ include file="/include/admin/footer.jsp" %>