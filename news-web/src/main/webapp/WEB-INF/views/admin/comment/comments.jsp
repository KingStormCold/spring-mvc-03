<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:forEach var="item" items="${comments}">
    <tr data-id="${item.id}" data-parent="${item.parentId}" data-level="${item.dataLevel}" class="${item.dataLevel}">
        <td class="center select-cell">
            <fieldset>
                <input type="checkbox" name="checkList_${item.id}" value="${item.id}" id="checkbox${item.id}" class="check-box-element"  onclick="evenCheck(${item.id})" />
            </fieldset>
        </td>
        <td data-column="name">${item.content}</td>
        <td>${item.users.fullName}</td>
    </tr>
    <c:set var="comments" value="${item.subComments}" scope="request" />
    <jsp:include page="comments.jsp" />
</c:forEach>
