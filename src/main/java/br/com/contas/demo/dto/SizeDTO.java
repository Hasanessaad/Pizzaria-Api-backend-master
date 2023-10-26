package br.com.contas.demo.dto;

public class SizeDTO {


    private String Tamanho;
    private Integer Nsabor;

    public SizeDTO(String tamanho, Integer nsabor) {
        Tamanho = tamanho;
        Nsabor = nsabor;
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
