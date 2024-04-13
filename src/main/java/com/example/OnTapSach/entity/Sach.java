package com.example.OnTapSach.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name="Sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="Ma")
    private String ma;
    @Column(name="Ten")
    private String ten;
    @Column(name="SoTrang")
    private int soTrang;
    @Column(name="DonGia")
    private float donGia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IdNXB")
    private NhaXuatBan nhaXuatBan;
}
