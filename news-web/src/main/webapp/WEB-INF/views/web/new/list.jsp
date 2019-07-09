<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/tin-tuc"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách bài viết</title>
</head>
<body>
<div class="main">
    <form:form action="${formUrl}/${model.categoryId}/${newstags:seoURL(model.categoryCode)}" method="get" commandName="model" id="formURL">
        <div class="content">
            <div class="col span_2_of_3">
                <div class="contact-form">
                    <div>
                                <span>
                                    <form:input path="title" cssClass="textbox"/>
                                </span>
                    </div>
                </div>
            </div>
            <c:forEach var="item" items="${model.listResult}">
                <div class="image group">
                    <div class="grid images_3_of_1">
                        <img src='<c:url value="/repository/${item.thumbnail}"/>' alt="" />
                    </div>
                    <div class="grid news_desc">
                        <h3><a href="<c:url value="/tin-tuc/${newstags:seoURL(item.categoryCode)}/${item.id}/${newstags:seoURL(item.title)}"/>">${item.title}</a></h3>
                        <h4>${item.createdDate}</h4>
                        <p>${item.shortDescription}</p>
                    </div>
                </div>
            </c:forEach>
            <ul id="pagination-demo" class="pagination-sm"></ul>
            <form:hidden path="page" id="page"/>
        </div>
    </form:form>
</div>
<script type="text/javascript">
    var totalPages = ${model.totalPages};
    var currentPage = ${model.page};
    var visiblePages = ${model.maxPageItems};
    $(document).ready(function () {
    });
    $(function () {
        var obj = $('#pagination-demo').twbsPagination({
            totalPages: totalPages,
            startPage: currentPage,
            visiblePages: visiblePages,
            onPageClick: function (event, page) {
                if (page != currentPage) {
                    $('#page').val(page);
                    $('#formURL').submit();
                }
            }
        });
    });
</script>
</body>
</html>