package com.example.OnTapSach.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SachRequest {

    private int id;

    private String ma;

    private String ten;

    private int soTrang;

    private float donGia;

    private int idNhaXuatBan;
}
