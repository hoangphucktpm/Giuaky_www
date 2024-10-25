package iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.controller;

import java.io.*;

import iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.dao.QuanLyLoaiThuocDAO;
import iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.dao.QuanLyThuocDAO;
import iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.models.Loaithuoc;
import iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.models.Thuoc;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "controllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuanLyThuocDAO quanLyThuocDAO = new QuanLyThuocDAO();
        QuanLyLoaiThuocDAO quanLyLoaiThuocDAO = new QuanLyLoaiThuocDAO();
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("listThuoc")) {
            request.setAttribute("listLoaiThuoc", quanLyLoaiThuocDAO.getAllLoaiThuoc());
            request.setAttribute("listThuoc", quanLyThuocDAO.getAllThuoc());
            request.getRequestDispatcher("danhSachThuoc.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("listLoaiThuoc")) {
            request.setAttribute("listLoaiThuoc", quanLyLoaiThuocDAO.getAllLoaiThuoc());
            request.getRequestDispatcher("danhSachLoaiThuoc.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("listThuocByLoai")) {
            int maloai = Integer.parseInt(request.getParameter("maloai"));
            request.setAttribute("listLoaiThuoc", quanLyLoaiThuocDAO.getAllLoaiThuoc());
            request.setAttribute("listThuoc", quanLyThuocDAO.getThuocByLoai(maloai));
            request.getRequestDispatcher("danhSachThuoc.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("addThuoc")) {
            request.setAttribute("listLoaiThuoc", quanLyLoaiThuocDAO.getAllLoaiThuoc());
            request.getRequestDispatcher("themThuoc.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuanLyThuocDAO quanLyThuocDAO = new QuanLyThuocDAO();
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("add")) {
            Thuoc thuoc = new Thuoc();
            thuoc.setId(Integer.parseInt(request.getParameter("mathuoc")));
            thuoc.setTenthuoc(request.getParameter("tenthuoc"));
            thuoc.setGia(Double.parseDouble(request.getParameter("gia")));
            thuoc.setNamsx(Integer.parseInt(request.getParameter("namsx")));
            Loaithuoc loaithuoc = new Loaithuoc();
            loaithuoc.setId(Integer.parseInt(request.getParameter("maloai")));
            thuoc.setMaloai(loaithuoc);
            quanLyThuocDAO.add(thuoc);
            response.sendRedirect("controller?action=listThuoc");
        }
    }

    public void destroy() {
    }
}