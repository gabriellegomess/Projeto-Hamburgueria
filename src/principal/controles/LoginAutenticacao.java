package principal.controles;

public class LoginAutenticacao {

	public static boolean autenticar(String login, String senha){
        if(login.equals("gerente")  && senha.equals("senha")){
            return true;
        } else{
            return false;
        }
    }
	
}
