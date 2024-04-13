package com.example.OnTapSach.repository;

import com.example.OnTapSach.config.HibernateConfig;
import com.example.OnTapSach.entity.Sach;
import com.example.OnTapSach.response.SachResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SachRepository {
    List<SachResponse> listS=new ArrayList<>();

    public List<SachResponse> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        listS=session.createQuery("SELECT new com.example.OnTapSach.response.SachResponse(sach.id,sach.ma,sach.ten" +
                ",sach.soTrang,sach.donGia,sach.nhaXuatBan.id,sach.nhaXuatBan.ten) FROM Sach sach",SachResponse.class).getResultList();
        return listS;
    }


    public Sach getOne(int id){
        Sach sach=null;
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            sach=session.get(Sach.class,id);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return sach;
    }

    public boolean add(Sach sach){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(sach);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(Sach sach){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(sach);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Sach sach){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(sach);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
