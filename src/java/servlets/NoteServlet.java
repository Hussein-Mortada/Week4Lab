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
   
    
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String mode = request.getParameter("mode");
    if (mode == null || mode.equals("edit")) {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title=br.readLine();
        String contents=br.readLine();
        Note note = new Note(title,contents);
        request.getSession().setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    } else {
        Note note = (Note) request.getSession().getAttribute("note");
        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
    }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
          String title = request.getParameter("edittitle");
          String contents = request.getParameter("editcontents");
          Note note = (Note) request.getSession().getAttribute("note");
          note.setContents(contents);
          note.setTitle(title);
          request.getSession().setAttribute("note", note);
           
          try {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));             
            out.print(note.getTitle()+"\n");
            out.print(note.getContents()+"\n");
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
