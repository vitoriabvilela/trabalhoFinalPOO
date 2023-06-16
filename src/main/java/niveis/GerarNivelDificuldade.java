package niveis;

public class GerarNivelDificuldade {
	
	int NivelSelecionado;
	NivelDificuldade nivelDificuldade;
	
	public GerarNivelDificuldade(int x) {
		this.NivelSelecionado = x;
	}
	
	//verificar se encaixa como padrão estrategy
	public NivelDificuldade gerar(){
				
		if (NivelSelecionado == 1) {
			return nivelDificuldade = new NivelFacil();
		}

		else if (NivelSelecionado == 2) {
			return nivelDificuldade = new NivelMedio();
		}

		else if (NivelSelecionado == 3) {
			return nivelDificuldade = new NivelDificil();
		}
		return null;
	}

}
