package principal.modelos;
import java.time.LocalDate;
import java.time.LocalTime;

public class Funcionario extends Pessoa {
	
		private LocalDate dataAdmissao;
		private LocalTime horarioEntrada;
		private LocalTime horarioSaida;
		
		public Funcionario(String nome, Integer CPF, String telefone, String sexo, String email, LocalDate dataAdmissao, LocalTime horarioEntrada, LocalTime horarioSaida) {
			super(nome, CPF, telefone, sexo, email);
			this.dataAdmissao = dataAdmissao;
			this.horarioEntrada = horarioEntrada;
			this.horarioSaida = horarioSaida;
		}
		
		public void setDataAdmissao(LocalDate dataAdmissao) {
			this.dataAdmissao = dataAdmissao;
		}
		
		public void setHorarioEntrada(LocalTime horarioEntrada) {
			this.horarioEntrada = horarioEntrada;
		}
		
		public void setHorarioSaida(LocalTime horarioSaida) {
			this.horarioSaida = horarioSaida;
		}
		
		public LocalDate getDataAdmissao() {
			return dataAdmissao;
		}
		
		public LocalTime getHorarioEntrada() {
			return horarioEntrada;
		}
		
		public LocalTime getHorarioSaida() {
			return horarioSaida;
		}
	}	