package entities;

import java.util.Scanner;

public class Programa {

    public static void executarCasoBase() {
        Trabalhador trabalhador = new Trabalhador("Marcelo Filho", NivelTrabalhador.PLENO, 1200.00, new Departamento("TI"));
        trabalhador.adicionarContrato(new Contrato("20/08/2018", 50.00, 20));
        trabalhador.adicionarContrato(new Contrato("13/06/2018", 30.00, 18));
        trabalhador.adicionarContrato(new Contrato("25/08/2018", 80.00, 10));

        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        System.out.println("Renda em 8/2021: " + trabalhador.obterRenda(2018, 8));
    }
    public static void executarCasoTeste() {

        Scanner sc = new Scanner(System.in);

        String departamento = "";
        do {
            System.out.println("Nome do Departamento: ");
            departamento = sc.nextLine();
        } while (departamento.isEmpty());

        Departamento departamentoTrabalhador = new Departamento(departamento);

        System.out.println("Preencha as informações do Trabalhador");

        String nome = "";
        do {
            System.out.println("Nome: ");
            nome = sc.nextLine();
        } while (nome.isEmpty());

        String nivel = "";
        do {
            System.out.println("Nível: ");
            nivel = sc.nextLine();
        } while (nivel.isEmpty());

        double salarioBase = -1;
        do {
            System.out.println("Salário Base: ");

            String entrada = sc.nextLine();
            try {
                salarioBase = Double.parseDouble(entrada);
            } catch (NumberFormatException nfe) {
            }
        } while (salarioBase < 0);

        Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase, departamentoTrabalhador);

        System.out.println("Quantos contratos este trabalhador possui? ");

        int quantidadeContratos = -1;
        do {
            String entrada = sc.nextLine();
            try {
                quantidadeContratos = Integer.parseInt(entrada);
            } catch (NumberFormatException nfe) {
            }
        } while (quantidadeContratos < 0);

        for (int i = 0; i < quantidadeContratos; i++) {
            System.out.println("Preencher dados do Contrato " + (i + 1) + ": ");

            String data = "";
            do {
                System.out.println("Data (dd/MM/yyyy): ");
                data = sc.nextLine();
            } while (data.isEmpty());

            double valorPorHora = -1.00;
            do {
                System.out.println("Valor por Hora: ");
                String entrada = sc.nextLine();
                try {
                    valorPorHora = Double.parseDouble(entrada);
                } catch (NumberFormatException nfe) {
                }
            } while (valorPorHora < 0);

            int duracao = -1;
            do {
                System.out.println("Duração (horas): ");
                String entrada = sc.nextLine();
                try {
                    duracao = Integer.parseInt(entrada);
                } catch (NumberFormatException nfe) {
                }
            } while (duracao < 0);

            Contrato contrato = new Contrato(data, valorPorHora, duracao);
            trabalhador.adicionarContrato(contrato);
        }

        System.out.println("Insira mês e ano para calcular a renda (MM/yyyy): ");

        int mes = 0;
        do {
            System.out.println("Mês: ");
            String entrada = sc.nextLine();
            try {
                mes = Integer.parseInt(entrada);
            } catch (NumberFormatException nfe) {
            }
        } while (mes <= 0 || mes > 12);

        int ano = -1;
        do {
            System.out.println("Ano: ");
            String entrada = sc.nextLine();
            try {
                ano = Integer.parseInt(entrada);
            } catch (NumberFormatException nfe) {
            }
        } while (ano < 0);

        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        System.out.println("Renda em " + mes + "/" + ano + ": " + trabalhador.obterRenda(ano, mes));
    }

    public static void main(String[] args) {
        executarCasoBase();
        executarCasoTeste();
    }
}
