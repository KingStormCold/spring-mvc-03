<%@ page import="com.example.utils.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/api/comment"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chi tiết bài viết</title>
</head>
<body>
<div class="main">
    <div class="content">
        <div class="image group">
            <div class="grid images_3_of_1">
                <img src='<c:url value="/repository/${model.thumbnail}"/>' alt=""/>
            </div>
            <div class="grid news_desc">
                <h3>${model.title}</h3>
                <h4>
                    ${model.createdDate}
                </h4>
                <p>${model.content}</p>
            </div>
        </div>

        <br>




        <security:authorize access="isAnonymous()">
            <input type="hidden" id="userId" value=""/>
        </security:authorize>

        <security:authorize access="isAuthenticated()">
            <input type="hidden" id="userId" value="<%=SecurityUtils.getPrincipal().getId()%>"/>
        </security:authorize>
                <h2>Bình luận bài viết</h2><br/>
                <div class="form-group">
                    <div class="form-group">
                        <label>Comment:</label>
                        <textarea class="form-control" rows="5" id="content_"></textarea>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <%--<input type="button" class="btn btn-white btn-warning btn-bold" value="Send" class="btnAddComment"/>--%>
                            <p class="text-right"><a href="#" class="btnAddComment"><i class="fa fa-reply"></i>Send</a></p>
                        </div>
                    </div>
                </div>
                <input type="hidden" id="newId" value="${model.id}"/>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <h2 class="page-header">Comments</h2>
                        <section class="comment_list">
                            <c:set var="comments" value="${commentTrees}" scope="request"/>
                            <jsp:include page="comment.jsp"/>
                        </section>
                    </div>
                </div>
            </div>


</div>
<script>

    var dataArray = {};
    var id = "";
    $(document).ready(function () {

    });

    $('.btnReply').click(function (event) {
        event.preventDefault();
        id = $(this).attr("id");
        if ($('#reply_'+id).is(":hidden")) {
            $("#"+id).text("Close");
            $('#reply_'+id).show();
            dataArray['parentId'] = id;
        }
        else {
            $("#"+id).text("Reply");
            $('#reply_'+id).hide();
        }
    });

    $('.btnAddComment').click(function (event) {
        event.preventDefault();
        if($('#userId').val() == ""){
            alert("Mời bạn đăng nhập");
        }
        else{
            bindDataComment();
        }
    });


    function bindDataComment() {
        dataArray["newId"] = $('#newId').val();
        dataArray["content"] = $('#content_'+id).val();
        addCommment(dataArray);
    }


    function addCommment(data) {
        $.ajax({
            url: '${formUrl}',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                window.location.href = "<c:url value="/tin-tuc/${newstags:seoURL(model.categoryCode)}/${model.id}/${newstags:seoURL(model.title)}"/>";
            }
        });
    }

</script>
</body>
</html>