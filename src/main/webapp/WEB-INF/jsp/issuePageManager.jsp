<%--
  Created by IntelliJ IDEA.
  User: lgala
  Date: 2/06/2023
  Time: 10:20 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Issue Display</title>
</head>
<body>
<div>
    <button class="dropbtn">Menu</button>
    <div>
        <a href="#">Issues</a>
        <a href="#">Knowledge Base</a>
        <a href="#">Assigned Issues</a>
        <a href="#">Log Out</a>
    </div>
</div>
<h1>Issue</h1>

<p><s:property value="title"/></p>
<p><s:property value="Description"/></p>
<p><s:property value="Category"/></p>
<p><s:property value="Tags"/></p>
<p><s:property value="title"/></p>

<table>
    <tr>
        <th>Comments:</th>
    </tr>
    <s:iterator value="commentList"> <%-- 'commentList' WILL BE THE ARRAY THAT STORES THE COMMENTS --%>
        <tr>
            <td><s:property value="staffId"/></td>
            <td><s:property value="commentText"/></td>
            <td><button onclick="Reply" class="reply">Reply</button></td>
        </tr>
    </s:iterator>
</table>
<div>
    <button onclick="commentPage" class="addComment">Add Comment</button>
    <button onclick="addToKnowledgeBase" class="addToKnowledgeBase">Add to Knowledge Base</button>
</div>
</body>
</html>
