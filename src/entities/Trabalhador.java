package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trabalhador {
    private String nome;
    private NivelTrabalhador nivel;
    private Double salarioBase;
    private List<Contrato> contratos;
    private Departamento departamento;

    public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.contratos = new ArrayList<Contrato>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public List<Contrato> getContratos() {
        return this.contratos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void adicionarContrato(Contrato contrato) {
        this.contratos.add(contrato);
    }

    public void removerContrato(Contrato contrato) {
        this.contratos.remove(contrato);
    }

    public Double renda(Integer ano, Integer mes) {

        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
        String dataRendaString = String.valueOf(mes).concat("/").concat(String.valueOf(ano));
        double rendaTotal = 0.00;
        try{
            Date dataRenda = formatter.parse(dataRendaString);
            for (int i = 0; i < this.contratos.size(); i++) {
                Contrato contratoAtual = this.contratos.get(i);
                Date dataContrato = formatter.parse(formatter.format(contratoAtual.getData()));

                if (dataRenda.compareTo(dataContrato) == 0) {
                    rendaTotal = rendaTotal + contratoAtual.getValorHora() * contratoAtual.getHoras();
                }
            }
            return rendaTotal;
        } catch (ParseException pe){}
        return rendaTotal;
    }
}
