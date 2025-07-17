package com.paulograbin.SimpleCRUD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_id_Pessoas", sequenceName = "seq_id_Pessoas")
public class Pessoas {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	private String nome;
	private int idade;
	private char sexo;

	@Override
	public String toString() {
        return "ID: " + id + " - Nome: " + nome + " - Idade: " + idade + " - Sexo: " + sexo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
}