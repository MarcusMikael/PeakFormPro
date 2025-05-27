package model;
import java.time.LocalDate;
// Classe do corredor com seus atributos sendo private.
public class Corredor {
	private int id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private String sexo;
	private double peso;
	private double altura;
	private String nivelExperiencia;
	
	public Corredor() {
		//Contrutor vazio
	}
	
// Contrutor da classe corredor com seus metodos gettter e setters.
	
	public Corredor(int id, String nome, String email, LocalDate data_nascimento, String sexo, double peso, double altura,
			String nivel_experiencia) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = data_nascimento;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.nivelExperiencia = nivel_experiencia;
	}
// ID
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
// NOME
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
// EMAIL
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
// DATA_NASCIMENTO
	public LocalDate getDataNascimento() {
    return dataNascimento;
}

public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
}
// SEXO
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
// PESO
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
// ALTURA
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
// NIVEL EXPERIENCIA 
	public String getNivel_experiencia() {
		return nivelExperiencia;
	}

	public void setNivel_experiencia(String nivel_experiencia) {
		this.nivelExperiencia = nivel_experiencia;
	}
}