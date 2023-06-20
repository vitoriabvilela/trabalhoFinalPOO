package gui;

public class LabelRecorde implements Observer {

		String label = "";
	    
	    public LabelRecorde() {
	    	
	    }
	    
	    public String getLabel() {
			return this.label;
	    }

	    //se o observer avisar que bateu o recorde de pontuacao o notify muda o texto 
	    //esse texto foi usado no controller para setar uma label, caso não tenha o notify
	    //significa que não houve recorde 
	    //então a label ficará vazia e não apresenta mensagem na interface
	    public void notify(int pontos) {
	        this.label = "Você bateu o recorde de pontuação!";
	    }	
	    
	    
	
}
