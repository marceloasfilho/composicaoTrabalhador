package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contrato {
    private Date data;
    private Double valorHora;
    private Integer horas;

    public Contrato(String data, Double valorHora, Integer horas) {
        this.data = this.stringToDate(data);
        this.valorHora = valorHora;
        this.horas = horas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Double valorTotal() {
        return this.valorHora * this.horas;
    }

    private Date stringToDate(String data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = formatter.parse(data);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }
}
