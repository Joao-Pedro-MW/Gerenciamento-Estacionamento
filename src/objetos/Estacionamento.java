package objetos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Vaga> historico;

    public Estacionamento() {
        vagas = new ArrayList<>();
        historico = new ArrayList<>();
    }

    public void cadastraVaga(int numero, int tamanho) {
        vagas.add(new Vaga(numero, tamanho));
    }

    public void checkinVaga(String placaVeiculo, int tamanhoVeiculo) {
        if (vagas.isEmpty()) {
            System.out.println("...Não há vagas disponíveis");
            return;
        }
        for (Vaga vaga : vagas) {
            if (vaga.getTamanho() >= tamanhoVeiculo && vaga.getDisponibilidade()) {
                vaga.setDisponibilidade(false);
                vaga.setVeiculo(placaVeiculo);
                vaga.setHoraEntrada(LocalDateTime.now());
                System.out.println("Vaga disponível: " + vaga.getNumero());
                return;
            }
        }
        System.out.println("...Não há vagas disponíveis para o tamanho do veículo");
    }

    public void checkoutVaga(String placaVeiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.getVeiculo().equals(placaVeiculo)) {
                vaga.setDisponibilidade(true);
                vaga.setHoraSaida(LocalDateTime.now());
                vaga.setValorPago(valorOcupacao(vaga));
                System.out.println("Valor ocupação: " + vaga.getValorPago());
                historico.add(vaga);
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }

    public void relatorioVagasOcupadas() {
        List<Vaga> vagasOcupadas = new ArrayList<>();
        for (Vaga vaga : vagas) {
            if (!vaga.getDisponibilidade()) {
                vagasOcupadas.add(vaga);
            }
        }
        if (vagasOcupadas.isEmpty()) {
            System.out.println("Não há vagas ocupadas...");
        } else {
            for (Vaga vaga : vagasOcupadas) {
                System.out.println(vaga);
            }
        }
    }

    public void relatorioHistoricoVeicular() {
        for (Vaga vaga : historico) {
            System.out.println(vaga);
        }
    }

    public float valorOcupacao(Vaga vaga) {
        Duration duracao = Duration.between(vaga.getHoraEntrada(), vaga.getHoraSaida());
        long horas = duracao.toHours();
        if (horas < 1) {
            return 5.00f;
        } else if (horas < 3) {
            return 10.00f;
        } else {
            return 15.00f;
        }
    }
}
