package objetos;

import java.time.LocalDateTime;

class Vaga {
    private int numero;
    private int tamanho;
    private boolean disponibilidade;
    private String placa_veiculo;
    private LocalDateTime hora_entrada;
    private LocalDateTime hora_saida;
    private Float valor_pago;
    
    public Vaga(int numero, int tamanho) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.disponibilidade = true;
        this.placa_veiculo = null;
        this.valor_pago = null;
        
    }
    
    public LocalDateTime  getHoraEntrada() {
		return hora_entrada;
	}

	public void setHoraEntrada(LocalDateTime hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public LocalDateTime getHoraSaida() {
		return hora_saida;
	}

	public void setValorPago(float valorPago) {
		this.valor_pago = valorPago;
	}
	public Float getValorPago() {
		return valor_pago;
	}
	public void setHoraSaida(LocalDateTime hora_saida) {
		this.hora_saida = hora_saida;
	}

	public int getNumero() {
    	return numero;
    }
	public int getTamanho() {
    	return tamanho;
    }
    public String getVeiculo() {
    	return placa_veiculo;
    }
    public void setDisponibilidade(boolean disponibilidade) {
    	this.disponibilidade = disponibilidade;
    }
    public boolean getDisponibilidade() {
    	return disponibilidade;
    }
    public void setVeiculo(String placa_veiculo) {
    	this.placa_veiculo = placa_veiculo;
    }

	@Override
	public String toString() {
		return "Vaga [numero=" + numero + ", tamanho=" + tamanho + ", disponibilidade=" + disponibilidade
				+ ", placa_veiculo=" + placa_veiculo + ", hora_entrada=" + hora_entrada + ", hora_saida=" + hora_saida
				+ "]";
	}
}

