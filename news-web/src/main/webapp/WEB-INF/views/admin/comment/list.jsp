<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/admin/comment/${model.news.id}/list"/>
<c:url var="formUrl" value=""/>
<c:url var="deleteAPI" value="/api/admin/comment"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách bài viết</title>
</head>
<body>
<div class="main-content">
    <form:form action="${formUrl}" method="get" commandName="model" id="formURL">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                    <li>Quản lý bình luận</li>
                    <li>Danh sách bình luận</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${messageResponse!=null}">
                            <div class="alert alert-block alert-${alert}">
                                <button type="button" class="close" data-dismiss="alert">
                                    <i class="ace-icon fa fa-times"></i>
                                </button>
                                    ${messageResponse}
                            </div>
                        </c:if>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-btn-controls">
                                    <div class="pull-right tableTools-container">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" disabled
                                                    data-toggle="tooltip" title="Xóa bài viết" onclick="warningBeforeDelete()">
                                                        <span>
                                                        <i class="fa fa-trash-o bigger-110 pink"></i>
                                                        </span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table id="tree-table" class="table table-hover table-bordered">
                                        <thead>
                                            <th class="center select-cell">
                                                <fieldset class='form-group'>
                                                <input type='checkbox' id='checkAll' class='check-box-element'>
                                                </fieldset>
                                            </th>
                                            <th>Nội dung comment</th>
                                            <th>Tên user</th>
                                        </thead>
                                        <tbody>
                                            <c:set var="comments" value="${model.listResult}" scope="request"/>
                                            <jsp:include page="comments.jsp"/>
                                        </tbody>
                                    </table>
                                    <ul id="pagination-demo" class="pagination"></ul>
                                    <form:hidden path="page" id="page"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>

<script type="text/javascript">

    $(document).ready(function () {
        //evenCheckAllCheckBox('checkAll');
    });
    var totalPages = ${model.totalPages};
    var currentPage = ${model.page};
    var visiblePages = ${model.maxPageItems};
    function evenCheck(id) {
                $('#checkbox'+id).closest('tbody').find('tr[data-parent="'+ id +'"]').find(':checkbox').prop('checked',true);
                var dataArray = $('#checkbox'+id).closest('tbody').find('tr[data-parent="'+ id +'"]').each(function () {
                    var subitem = ($(this).attr("data-id"));
                    evenCheck(subitem);
                });
    }
    function warningBeforeDelete() {
        showAlertBeforeDelete(function () {
            event.preventDefault();
            var dataArray = $(' tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            deleteComment(dataArray);
        });
    }
    function deleteComment(data) {
        $.ajax({
            url: '${deleteAPI}',
            type: 'DELETE',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
                window.location.href = "<c:url value='?message=delete_success'/>";
            },
            error: function(res) {
                console.log(res);
                window.location.href = "<c:url value='?message=error_system'/>";
            }
        });
    }

    (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();
</script>
</body>
</html>
