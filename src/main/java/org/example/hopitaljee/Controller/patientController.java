package org.example.hopitaljee.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.hopitaljee.Entity.Patient;
import org.example.hopitaljee.Interface.PatientServiceInterface;
import org.example.hopitaljee.Service.PatientService;
import org.example.hopitaljee.util.HibernateSession;

import java.io.File;
import java.io.IOException;

@WebServlet("/patients")
@MultipartConfig(maxFileSize = 10 * 1024 * 1024) // 10 MB
public class patientController extends HttpServlet {

    private PatientServiceInterface patientService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService(HibernateSession.getSessionFactory());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patients", patientService.getAllPatients());
        req.getRequestDispatcher("/WEB-INF/Views/Patients.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateOfBirth = req.getParameter("dateOfBirth");


        // Récupération de l'image
        Part imagePart = req.getPart("image");
        String imageName = imagePart.getSubmittedFileName();
        String uploadPath = getServletContext().getRealPath("/images");

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        imagePart.write(uploadPath + File.separator + imageName);

        patientService.createPatient(Patient patient);

        // Rediriger vers la liste (même page)
        resp.sendRedirect(req.getContextPath() + "/patients");
    }
}
