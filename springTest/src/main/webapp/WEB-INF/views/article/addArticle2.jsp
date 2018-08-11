<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ include file="/WEB-INF/views/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<%@ include file="/WEB-INF/views/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	
				<form id="frmAddArticle" action="/article/addArticle2Result" method="post" enctype="multipart/form-data">
					<input type="hidden" name="board_no" value="${articleVo.board_no}">
					<input type="hidden" name="article_pno" value="${articleVo.article_pno}">
					<input type="hidden" name="article_gno" value="${articleVo.article_gno}">
					<table width="100%">
				        <tr>
				            <td>제목</td>
				            <td><input type="text" id="title" name="article_title" style="width:650px"/></td>
				        </tr>
				        <tr>
				            <td>내용</td>
				            <td>
				                <textarea rows="10" cols="30" id="smarteditor" name="article_content" style="width:650px; height:350px; "></textarea>
				            </td>
				        </tr>
				         <tr>
				            <td>첨부파일</td>
				            <td>
					            <div id="addAttach">
<!-- 				                	<input type="file" id="uploadFile" name="uploadFile" style="width:650px"/> -->
					            </div>
				                	<input type="button" value="추가" onclick="addInput();" />
									<input type="button" value="삭제" onclick="deleteInput();"/>
				            </td>
				        </tr>
				        <tr>
				            <td colspan="2">
				                <input type="submit" id="save" value="저장"/>
				                <input type="button" value="취소"/>
				            </td>
				        </tr>
					</table>
				</form>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>