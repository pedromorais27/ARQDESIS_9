package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.usjt.model.Conta;
import br.com.usjt.model.Saque;

public class SaqueCommand  implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		RequestDispatcher dispatcher;
		Boolean sucesso = false;
		String parameter = request.getParameter("valor");
		request.setAttribute("conta", Conta.conta);
		request.setAttribute("resposta", sucesso);
			
			Saque saque = new Saque();
			Double valorDoSaque = Double.parseDouble(parameter);
			
			if (saque.fazerSaque(Conta.conta, valorDoSaque)) {
				sucesso = true;
			}

			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/conteudo/resposta-saque.jsp");

//		dispatcher.forward(request, response);
	}
}