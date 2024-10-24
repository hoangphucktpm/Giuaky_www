package iuh.huynhhoangphuc_21036541_quanlyxe.controllers;

import java.io.*;
import java.util.List;

import iuh.huynhhoangphuc_21036541_quanlyxe.dao.QuanLyLoaiXeDAO;
import iuh.huynhhoangphuc_21036541_quanlyxe.dao.QuanLyXeDAO;
import iuh.huynhhoangphuc_21036541_quanlyxe.models.Loaixe;
import iuh.huynhhoangphuc_21036541_quanlyxe.models.Xe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");

            QuanLyXeDAO quanLyXeDAO = new QuanLyXeDAO();
            QuanLyLoaiXeDAO quanLyLoaiXeDAO = new QuanLyLoaiXeDAO();
            if (action.equalsIgnoreCase("listXe")) {
                    request.setAttribute("listLoaiXe", quanLyLoaiXeDAO.getAllLoaiXe());
                    request.setAttribute("listXe", quanLyXeDAO.getAllXe());
                    request.getRequestDispatcher("danhSachXe.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("listLoaiXe")) {
                    request.setAttribute("listLoaiXe", quanLyLoaiXeDAO.getAllLoaiXe());
                    request.getRequestDispatcher("danhSachLoaiXe.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("filterByLoai")) {
                    int maloai = Integer.parseInt(request.getParameter("maLoai"));
                    request.setAttribute("listLoaiXe", quanLyLoaiXeDAO.getAllLoaiXe());
                    request.setAttribute("listXe", quanLyXeDAO.getDSXeTheoLoai(maloai));
                    request.getRequestDispatcher("danhSachXe.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("addXe")) {
                    request.setAttribute("listLoaiXe", quanLyLoaiXeDAO.getAllLoaiXe());
                    request.getRequestDispatcher("ThemXe.jsp").forward(request, response);

            } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
            }
    }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String action = request.getParameter("action");
                QuanLyXeDAO quanLyXeDAO = new QuanLyXeDAO();
                if (action.equalsIgnoreCase("addXeSubmit")) {
                        Xe xe = new Xe();
                        xe.setMaxe(Integer.parseInt(request.getParameter("maXe")));
                        xe.setTenxe(request.getParameter("tenXe"));
                        xe.setGia(Double.parseDouble(request.getParameter("gia")));
                        xe.setNamsx(Integer.parseInt(request.getParameter("namSx")));
                        Loaixe loaixe = new Loaixe();
                        loaixe.setMaloai(Integer.parseInt(request.getParameter("maLoai")));
                        xe.setMaloai(loaixe);
                        quanLyXeDAO.addXe(xe);
                        response.sendRedirect("controller?action=listXe");

                } else {
                        response.sendRedirect("index.jsp");
                }
        }


}