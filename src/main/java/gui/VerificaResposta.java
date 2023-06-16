package gui;

public class VerificaResposta {
	
	float respostaUsuario, respostaCorreta;
	
	public VerificaResposta(float respostaUsuario, float respostaCorreta) {
		this.respostaUsuario = respostaUsuario;
		this.respostaCorreta = respostaCorreta;
	}
	
	public int verificar() {
		if (respostaUsuario == respostaCorreta) {
			return 1;

		} else return 0;
	}

}
