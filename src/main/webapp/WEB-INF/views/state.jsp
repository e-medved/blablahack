<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="offer-modal" class="modal hide fade">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>

        <span class="pull-right plugin-status"></span>
    </div>
    <div class="modal-body">
        <%--<div class="modal-loader">--%>
            <%--<span class="message">загрузка данных</span>--%>
        <%--</div>--%>

        <div class="modal-content main">
            <div class="alert alert-info plugin-main-status">
                ${phone}
            </div>
        </div>
    </div>
</div>