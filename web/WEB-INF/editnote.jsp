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
        
    <form action="note" method="post">
    <label for="edittitle">Title:</label>
    <input type="text"  name="edittitle" value=${note.title}>
    <br>

    <label for="editcontents">Contents:</label>
    <textarea name="editcontents" >${note.contents}</textarea><br><br>
    
    <input type="submit" name="operation" value="Save Changes">
    <input type="hidden" name="mode" value="view">
  </form>
    
    </body>
</html>
