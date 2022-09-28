package rikkei.academy.controller;

import rikkei.academy.Service.IStudentService;
import rikkei.academy.Service.StudentServiceIMLP;
import rikkei.academy.model.Students;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/", "/students"})
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentServiceIMLP();
    private String message;

    public StudentController() throws SQLException {
    }

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                showFromDelete(request, response);
                break;
                case "detail":
                    showFormDetail(request, response);
                    break;
            default:
                showListStudent(request, response);
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                actionCreate(request, response);
                break;
            case "edit":
                actionEdit(request, response);
                break;
            case "delete":
                actionDelete(request, response);
                break;

        }
    }


    public void destroy() {
    }

    public void showListStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Students> studentsList = studentService.findAll();
        request.setAttribute("listStudent", studentsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/list.jsp");
        dispatcher.forward(request, response);
    }

    public void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/create.jsp");
        dispatcher.forward(request, response);

    }


    public void actionCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        Students students = new Students(name, age);
        studentService.save(students);
        request.setAttribute("message", "Create successful.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/create.jsp");
        dispatcher.forward(request, response);

    }

    public void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Students students = studentService.findById(id);
        request.setAttribute("student", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/edit.jsp");
        dispatcher.forward(request, response);

    }

    public void actionEdit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Students students = studentService.findById(id);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        students.setName(name);
        students.setAge(age);
        studentService.save(students);
        request.setAttribute("message", "Edit successful.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/edit.jsp");
        dispatcher.forward(request, response);
    }

    public void showFromDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Students students = studentService.findById(id);
        request.setAttribute("student", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/delete.jsp");
        dispatcher.forward(request, response);
    }

    public void actionDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Students students = studentService.deleteById(id);
        request.setAttribute("message", "Delete successful");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/delete.jsp");
        dispatcher.forward(request, response);
    }

    public void showFormDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Students students = studentService.findById(id);
        request.setAttribute("student", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/detail.jsp");
        dispatcher.forward(request, response);
    }

}