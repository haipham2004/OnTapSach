package com.example.OnTapSach.repository;

import com.example.OnTapSach.config.HibernateConfig;
import com.example.OnTapSach.entity.NhaXuatBan;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class NhaXuatBanRepository {
    List<NhaXuatBan> listNXB=new ArrayList<>();

    public List<NhaXuatBan> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        listNXB=session.createQuery("FROM NhaXuatBan",NhaXuatBan.class).getResultList();
        return listNXB;
    }


    public NhaXuatBan getOne(int id){
        NhaXuatBan nhaXuatBan=null;
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            nhaXuatBan=session.get(NhaXuatBan.class,id);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return nhaXuatBan;
    }
}
