<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="modal fade" id="myModal">
	<div class="modal-dialog" role="dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn-modal-save" id="">Save
					changes</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="modifyModal">
	<div class="modal-dialog" role="dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">modify</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p class="text-default">정말 수정하시겠습니까?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn-modal-save"
					id="modify_save">Save changes</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="removeModal">
	<div class="modal-dialog" role="dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">remove</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>정말 삭제하시겠습니까?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger btn-go"
					title="remove?bno=${board.bno}" id="remove_save">YES</button>
				<button type="button" class="btn btn-warning" data-dismiss="modal">NO</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="passwordModal">
	<div class="modal-dialog" style="width: 310px;" role="dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">비밀번호</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body form-group">
				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input insert-view-checkbox"
						id="modal_pw_insert"> 
						<label class="custom-control-label" for="modal_pw_insert">
						비밀번호 보이게
						</label>
				</div>
				<div class="form form-inline">
					<input type="password" class="form-control insert-view" id="modalPWCheck">
					<button class="btn btn-success form-control" id="passwordSubmit">입력</button>

					<div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="historyModal">
	<div class="modal-dialog modal-lg" role="dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">수정내역</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">
				<jsp:include page="/WEB-INF/views/board/detail_history.jsp"></jsp:include>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="brd_previewModal" style="width: 100%">
	<div class="modal-dialog modal-lg" role="dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">미리보기</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">
				<div class="card panel border">

					<div class="panel-head border-primary bg-primary">content</div>
					<div id="brd_preview"
						class="panel-body border-primary content-div container-fluid"></div>

				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="loginModal">
	<div class="modal-dialog" role="dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">login</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<jsp:include page="/WEB-INF/views/login.jsp"></jsp:include>

			</div>
			<!--     <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-modal-save" id= "login_submit">login</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div> -->
		</div>
	</div>
</div>


