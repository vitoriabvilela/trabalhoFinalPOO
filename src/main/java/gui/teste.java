package gui;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class teste implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	public teste() {
	
	}
	
	public teste(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	

}
