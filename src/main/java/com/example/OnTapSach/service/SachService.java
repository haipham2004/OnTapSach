package com.example.OnTapSach.service;

import com.example.OnTapSach.entity.Sach;
import com.example.OnTapSach.response.SachResponse;

import java.util.List;

public interface SachService {

    public List<SachResponse> getAll();


    public Sach getOne(int id);

    public boolean add(Sach sach);

    public boolean update(Sach sach);

    public boolean delete(Sach sach);
}
