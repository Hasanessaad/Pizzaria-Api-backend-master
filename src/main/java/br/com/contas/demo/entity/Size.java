package br.com.contas.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String Tamanho;
    private Integer Nsabor;
    public Size(Long id, String tamanho, Integer nsabor) {
        this.id = id;
        Tamanho = tamanho;

        Nsabor = nsabor;
    }

    public Size() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String tamanho) {
        Tamanho = tamanho;
    }

    public Integer getNsabor() {
        return Nsabor;
    }

    public void setNsabor(Integer nsabor) {
        Nsabor = nsabor;
    }
}
