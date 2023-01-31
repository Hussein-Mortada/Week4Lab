<%-- 
    Document   : viewnote
    Created on : Jan 30, 2023, 8:23:54 PM
    Author     : Hussein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p>Title: ${note.title}</p>
        <p>Contents: ${note.contents}</p>
        <a href="editnote">Edit</a>
        <input type="hidden" name="mode" value="edit">
    </body>
</html>
