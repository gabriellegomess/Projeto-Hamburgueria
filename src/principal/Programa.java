package principal;
import principal.db.Banco;
import principal.telas.TelaLogin;
public class Programa {
		public static void main(String[] args)  {

			Banco.inserindoDados();
			TelaLogin.mostrar();
		}
}