package com.example.OnTapSach.controller;

import com.example.OnTapSach.config.HibernateConfig;
import com.example.OnTapSach.entity.NhaXuatBan;
import com.example.OnTapSach.entity.Sach;
import com.example.OnTapSach.repository.NhaXuatBanRepository;
import com.example.OnTapSach.request.SachRequest;
import com.example.OnTapSach.response.SachResponse;
import com.example.OnTapSach.service.ServiceImp.SachServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = {
        "/HienThi",
        "/Detail",
        "/Delete",
        "/ViewUpdate",
        "/Add",
        "/Update"
})
public class Servlet extends HttpServlet {
    List<SachResponse> listS = new ArrayList<>();
    SachServiceImp service = new SachServiceImp();
    List<NhaXuatBan> listNXB = new ArrayList<>();
    NhaXuatBanRepository service2 = new NhaXuatBanRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThi")) {
            HienThi(request, response);
        } else if (uri.contains("Detail")) {
            Detail(request, response);
        } else if (uri.contains("Delete")) {
            Delete(request, response);
        } else if (uri.contains("ViewUpdate")) {
            ViewUpdate(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("Add")) {
            Add(request, response);
        } else if (uri.contains("Update")) {
            Update(request, response);
        }
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listS = service.getAll();
        request.setAttribute("listS", listS);
        listNXB = service2.getAll();
        request.setAttribute("listNXB", listNXB);
        request.getRequestDispatcher("/view/List.jsp").forward(request, response);
    }


    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String soTrang = request.getParameter("soTrang");
        String donGia = request.getParameter("donGia");
        String idNhaXuatBan = request.getParameter("idNhaXuatBan");
        SachRequest sachRequest = SachRequest.builder().id(Integer.parseInt(id)).ma(ma).ten(ten).soTrang(Integer.parseInt(soTrang)).donGia(Float.parseFloat(donGia)).idNhaXuatBan(Integer.parseInt(idNhaXuatBan)).build();
        service.addRequest(sachRequest);
        response.sendRedirect("/HienThi");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String soTrang = request.getParameter("soTrang");
        String donGia = request.getParameter("donGia");
        String idNhaXuatBan = request.getParameter("idNhaXuatBan");
        boolean check = true;
        if (ma.isEmpty()) {
            request.setAttribute("loiMa", "Mã trong");
            check = false;
        }
        if (ten.isEmpty()) {
            request.setAttribute("loiTen", "ten trong");
            check = false;
        }
        if (soTrang.isEmpty()) {
            request.setAttribute("loiTrang", "soTrang trong");
            check = false;
        }
        if (donGia.isEmpty()) {
            request.setAttribute("LoiGia", "donGia trong");
            check = false;
        }

        if (check) {
            SachRequest sachRequest = SachRequest.builder().ma(ma).ten(ten).soTrang(Integer.parseInt(soTrang)).donGia(Float.parseFloat(donGia)).idNhaXuatBan(Integer.parseInt(idNhaXuatBan)).build();
            for (SachResponse sach : service.getAll()) {
                if (sach.getMa().equalsIgnoreCase(ma)) {
                    request.setAttribute("maTrung", "Mã trùng");
                    break;
                } else {
                    service.addRequest(sachRequest);
                    break;
                }
            }

            listS = service.getAll();
            request.setAttribute("listS", listS);
            listNXB = service2.getAll();
            request.setAttribute("listNXB", listNXB);
            request.getRequestDispatcher("/view/List.jsp").forward(request, response);
        } else {
            listS = service.getAll();
            request.setAttribute("listS", listS);
            listNXB = service2.getAll();
            request.setAttribute("listNXB", listNXB);
            request.getRequestDispatcher("/view/List.jsp").forward(request, response);
        }


    }

    private void ViewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            int id = Integer.parseInt(request.getParameter("id"));
            Sach sach = session.get(Sach.class, id);
            List<NhaXuatBan> listNXB = session.createQuery("FROM NhaXuatBan", NhaXuatBan.class).getResultList();
            transaction.commit();
            session.close();
            request.setAttribute("sach", sach);
            request.setAttribute("listNXB", listNXB);
            request.getRequestDispatcher("/view/Update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void Delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Sach sach = service.getOne(id);
        service.delete(sach);
        if (service.getAll().size() == 0) {
            request.setAttribute("listRong", "List Rỗng");
            request.getRequestDispatcher("/view/List.jsp").forward(request, response);
        }
        response.sendRedirect("/HienThi");
    }

    private void Detail(HttpServletRequest request, HttpServletResponse response) {
    }


}
