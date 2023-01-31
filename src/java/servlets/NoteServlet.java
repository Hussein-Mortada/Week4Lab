/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Hussein
 */
public class NoteServlet extends HttpServlet {
    Note note;
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String mode = request.getParameter("mode");
    if (mode != null && mode.equals("edit")) {
        File file= new File(getServletContext().getRealPath("/WEB-INF/note.txt"));
        Scanner in = new Scanner(file);
        String title=in.nextLine();
        String contents=in.nextLine();
        note = new Note(title,contents);
        request.getSession().setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
//        Note note = (Note) request.getSession().getAttribute("note");
//        request.setAttribute("note", note);
//        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
    } else {
        note = (Note) request.getSession().getAttribute("note");
        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
          String title = request.getParameter("title");
          String contents = request.getParameter("contents");
          note = (Note) request.getSession().getAttribute("note");
          note.setContents(contents);
          note.setTitle(title);
          request.getSession().setAttribute("note", note);
           
          try {
            PrintWriter out = new PrintWriter(new File(getServletContext().getRealPath("/WEB-INF/note.txt")));
            out.println(title);
            out.println(contents);
            out.flush();
            out.close();
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          }
          request.setAttribute("note", note);
          getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
    
        }
    }
