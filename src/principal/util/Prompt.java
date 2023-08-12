package principal.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Prompt {
	
	// Método para imprimir uma mensagem no console
		public static void imprimir(String mensagem) {
			System.out.println(mensagem); // imprime a mensagem no console
			System.out.flush(); // limpa o buffer de saída
		}

		// Sobrecarga do método imprimir para receber um objeto e imprimir sua representação String
		public static void imprimir(Object object) {
			System.out.println(object); // imprime a representação String do objeto no console
			System.out.flush(); // limpa o buffer de saída
		}

		// Método para imprimir um separador no console
		public static void separador() {
			imprimir("---------------------------------------------------"); // imprime o separador no console
		}

		// Método para imprimir uma linha em branco no console
		public static void linhaEmBranco() {
			System.out.println(); // imprime uma linha em branco no console
			System.out.flush(); // limpa o buffer de saída
		}

		// Método para ler uma linha de texto do console, exibindo uma mensagem opcional
		public static String lerLinha(String mensagem) {
			imprimir(mensagem); // imprime a mensagem no console
			return lerLinha(); // chama o método lerLinha() sem mensagem para ler a linha de texto do console
		}

		// Método para ler uma linha de texto do console
		public static String lerLinha() {
			while (true) { // laço infinito
				try {
					InputStreamReader isr = new InputStreamReader(System.in); // cria um InputStreamReader para ler do console
					BufferedReader br = new BufferedReader(isr); // cria um BufferedReader para ler do InputStreamReader
					return br.readLine(); // lê uma linha de texto do BufferedReader e retorna como String
				} catch (IOException e) {
					System.out.println("Texto inválido, digite novamente..."); // imprime mensagem de erro no console
				}
			}
		}

		// Método para ler um número inteiro do console, exibindo uma mensagem opcional
		public static int lerInteiro(String mensagem) {
			imprimir(mensagem); // imprime a mensagem no console
			return lerInteiro(); // chama o método lerInteiro() sem mensagem para ler o número inteiro do console
		}

		// Método para ler um número inteiro do console
		public static int lerInteiro() {
			while (true) { // laço infinito
				try {
					String linha = lerLinha(); // lê uma linha de texto do console
					if (linha.isEmpty()) { // se a linha for vazia
						return 0; // retorna zero
					}
					return Integer.parseInt(linha); // converte a linha em um número inteiro e retorna
				} catch (NumberFormatException tExcept) {
					System.out.println("Inteiro inválido, digite novamente..."); // imprime mensagem de erro no console
				}
			}
		}
		/**
	 * Lê um número decimal digitado pelo usuário a partir da entrada padrão.
	 * Se o usuário digitar um valor inválido, exibe uma mensagem de erro e solicita
	 * que o usuário tente novamente.
	 * @param mensagem a mensagem a ser exibida antes da entrada do usuário
	 * @return o número decimal digitado pelo usuário
	 */
	public static double lerDecimal(String mensagem) {
		// exibe a mensagem fornecida antes da entrada do usuário
		imprimir(mensagem);
		// lê a entrada do usuário e retorna o número decimal correspondente
		return lerDecimal();
	}

	/**
	 * Lê um número decimal digitado pelo usuário a partir da entrada padrão.
	 * Se o usuário digitar um valor inválido, exibe uma mensagem de erro e solicita
	 * que o usuário tente novamente.
	 * @return o número decimal digitado pelo usuário
	 */
	public static double lerDecimal() {
		while (true) {
			try {
				// lê uma linha de texto da entrada padrão
				String linha = lerLinha();
				// se a linha estiver vazia, retorna 0
				if (linha.isEmpty()) {
					return 0;
				}
				// converte a linha em um número decimal e retorna o valor correspondente
				return Double.parseDouble(linha);
			} catch (NumberFormatException e) {
				// exibe uma mensagem de erro e solicita que o usuário tente novamente
				imprimir("Decimal inválido, digite novamente...");
			}
		}
	}

	//ler uma data digitada pelo usuário
	public static LocalDate lerData(String mensagem) {
		LocalDate data = null;
		while (data == null) {
			try {
				Prompt.imprimir(mensagem);
				String input = lerLinha();
				data = LocalDate.parse(input);
			} catch (DateTimeParseException e) {
				System.out.println("Data inválida. Digite novamente.");
			}
		}
		return data;
	}

	//ler a hora digitada pelo usuário 
	public static LocalTime lerHora(String mensagem) {
		System.out.println(mensagem);
		while (true) {
			try {
				String horaStr = lerLinha();
				// Formato de hora esperado
				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");
				return LocalTime.parse(horaStr, formatador);
			} catch (Exception e) {
				System.out.println("Hora inválida, digite novamente...");
			}
		}
	}

	/**
	 * Exibe uma mensagem pedindo que o usuário pressione a tecla ENTER para continuar.
	 * Aguarda até que o usuário pressione a tecla ENTER antes de retornar.
	 */
	public static void pressionarEnter() {
		// exibe a mensagem pedindo que o usuário pressione ENTER
		System.out.print("Pressione ENTER para continuar...");
		// aguarda até que o usuário pressione ENTER
		lerLinha();
	}

}
