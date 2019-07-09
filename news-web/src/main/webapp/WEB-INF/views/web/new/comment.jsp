<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:forEach var="item" items="${comments}">
    <article class="row">
        <div class="col-md-${item.col1} col-sm-${item.col1} hidden-xs">
        </div>

        <div class="col-md-${item.col2} col-sm-${item.col2}">
            <div class="panel panel-default arrow left">
                <div class="panel-body">
                    <header class="text-left">
                        <div class="comment-user"><i class="fa fa-user"></i>${item.users.userName}</div>
                            <time class="comment-date" datetime="16-12-2014 01:05"><i class="fa fa-clock-o"></i>${item.createdDate}</time>
                    </header>
                    <div class="comment-post">
                        <p class="content">
                            ${item.content}
                        </p>
                        <div class="form-group" style="display: none" id="reply_${item.id}"><label >Comment:</label>
                            <textarea class="form-control" rows="5" id="content_${item.id}"></textarea>
                                <div class="col-sm-${item.col2 + 2}">
                                    <%--<input type="button" class="btn btn-white btn-warning btn-bold" value="Send" class="btnAddComment"/>--%>
                                    <p class="text-right"><button  class="btnAddComment">Send</button></p>
                                </div>
                        </div>
                    </div>
                    <p class="text-right"><button id="${item.id}" class="btnReply">Reply</button></p>
                </div>
            </div>
        </div>
    </article>
    <c:set var="comments" value="${item.subComments}" scope="request"/>
    <jsp:include page="comment.jsp"/>
</c:forEach>

