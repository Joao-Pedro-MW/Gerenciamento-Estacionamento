package fag;

import java.util.Scanner;
import objetos.Estacionamento;

public class principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Vaga");
            System.out.println("2. Check-in de Veículo");
            System.out.println("3. Check-out de Veículo");
            System.out.println("4. Relatório de Vagas Ocupadas");
            System.out.println("5. Relatório de Historico");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarVaga(estacionamento, scanner);
                    break;
                case 2:
                    checkinVeiculo(estacionamento, scanner);
                    break;
                case 3:
                    checkoutVeiculo(estacionamento, scanner);
                    break;
                case 4:
                    estacionamento.relatorioVagasOcupadas();
                    break;
                case 5:
                	estacionamento.relatorioHistoricoVeicular();
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void cadastrarVaga(Estacionamento estacionamento, Scanner scanner) {
        System.out.print("Digite o número da vaga: ");
        int numero = scanner.nextInt();
        System.out.print("Digite o tamanho da vaga (1 - Pequeno, 2 - Médio, 3 - Grande): ");
        int tamanho = scanner.nextInt();
        estacionamento.cadastraVaga(numero, tamanho);
        System.out.println("Vaga cadastrada com sucesso!");
    }

    private static void checkinVeiculo(Estacionamento estacionamento, Scanner scanner) {
        System.out.print("Digite a placa do veículo: ");
        String placaVeiculo = scanner.nextLine();
        System.out.print("Digite o tamanho do veículo (1 - Pequeno, 2 - Médio, 3 - Grande): ");
        int tamanhoVeiculo = scanner.nextInt();
        estacionamento.checkinVaga(placaVeiculo, tamanhoVeiculo);
    }

    private static void checkoutVeiculo(Estacionamento estacionamento, Scanner scanner) {
        System.out.print("Digite a placa do veículo para checkout: ");
        String placaVeiculo = scanner.nextLine();
        estacionamento.checkoutVaga(placaVeiculo);
    }
}
