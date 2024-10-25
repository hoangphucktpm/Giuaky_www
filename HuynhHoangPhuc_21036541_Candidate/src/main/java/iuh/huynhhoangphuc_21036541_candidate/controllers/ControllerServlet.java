package iuh.huynhhoangphuc_21036541_candidate.controllers;

import iuh.huynhhoangphuc_21036541_candidate.enums.Roles;
import iuh.huynhhoangphuc_21036541_candidate.models.Candidate;
import iuh.huynhhoangphuc_21036541_candidate.dao.CandidateDao;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

        @WebServlet(name = "ControllerServlet", value = "/controller")
        public class ControllerServlet extends HttpServlet {
            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                CandidateDao candidateDao = new CandidateDao();
                String action = request.getParameter("action");

                if (action.equalsIgnoreCase("listCandidates")) {
                    request.setAttribute("candidates", candidateDao.getAllCandidates());
                    request.getRequestDispatcher("candidate.jsp").forward(request, response);
                } else if (action.equalsIgnoreCase("viewCandidate")) {
                    long id = Long.parseLong(request.getParameter("id"));
                    request.setAttribute("candidate", candidateDao.getCandidateById(id));
                    request.getRequestDispatcher("cand_details.jsp").forward(request, response);
                } else if (action.equalsIgnoreCase("report1")) {
                    String role = request.getParameter("role");
                    Roles selectedRole = Roles.getRole(role);
                    request.setAttribute("candidates", candidateDao.getCandidatesByRole(selectedRole));
                    request.getRequestDispatcher("report1.jsp").forward(request, response);
                } else if (action.equalsIgnoreCase("report2")) {
                    request.setAttribute("candidates", candidateDao.getCandidatesUsingGmail());
                    request.getRequestDispatcher("report2.jsp").forward(request, response);
                }
    }
}