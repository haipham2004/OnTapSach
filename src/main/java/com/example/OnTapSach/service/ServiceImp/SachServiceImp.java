package com.example.OnTapSach.service.ServiceImp;

import com.example.OnTapSach.entity.NhaXuatBan;
import com.example.OnTapSach.entity.Sach;
import com.example.OnTapSach.repository.NhaXuatBanRepository;
import com.example.OnTapSach.repository.SachRepository;
import com.example.OnTapSach.request.SachRequest;
import com.example.OnTapSach.response.SachResponse;
import com.example.OnTapSach.service.SachService;

import java.util.List;

public class SachServiceImp implements SachService {
    SachRepository repo=new SachRepository();
    NhaXuatBanRepository repo2=new NhaXuatBanRepository();
    @Override
    public List<SachResponse> getAll() {
        return repo.getAll();
    }

    @Override
    public Sach getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(Sach sach) {
        return false;
    }

    @Override
    public boolean update(Sach sach) {
        return false;
    }

    @Override
    public boolean delete(Sach sach) {
        return repo.delete(sach);
    }

    public boolean addRequest(SachRequest sachRequest){
        Sach sach=new Sach();
        sach.setDonGia(sachRequest.getDonGia());
        sach.setMa(sachRequest.getMa());
        sach.setSoTrang(sachRequest.getSoTrang());
        sach.setTen(sachRequest.getTen());
        sach.setDonGia(sachRequest.getDonGia());
        NhaXuatBan nxb=repo2.getOne(sachRequest.getIdNhaXuatBan());
        sach.setNhaXuatBan(nxb);
        return repo.add(sach);
    }

    public boolean updateRequest(SachRequest sachRequest){
        Sach sach=new Sach();
        sach.setId(sachRequest.getId());
        sach.setDonGia(sachRequest.getDonGia());
        sach.setMa(sachRequest.getMa());
        sach.setSoTrang(sachRequest.getSoTrang());
        sach.setTen(sachRequest.getTen());
        sach.setDonGia(sachRequest.getDonGia());
        NhaXuatBan nxb=repo2.getOne(sachRequest.getIdNhaXuatBan());
        sach.setNhaXuatBan(nxb);
        return repo.update(sach);
    }
}
