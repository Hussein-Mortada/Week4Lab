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
        <h2>Edit Note</h2>
        <form action="viewnote" method="post">
    <label for="title">Title:</label>
    <input type="text"  name="title" value=${note.title}>
    <br>

    <label for="contents">Contents:</label>
    <input type="text" name="contents" value=${note.contents}><br><br>
    
    test to see if attributes sent correctly
    <p>${note.title}</p>
    <p>${note.contents}</p>
    <br>
    <input type="submit" name="operation" value="Save Changes">
    <input type="hidden" name="mode" value="view">
  </form>
    
    </body>
</html>
