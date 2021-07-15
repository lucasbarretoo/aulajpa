package entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Modelo implements Serializable{

	private static final long serialVersionUID = 1L;

	public Modelo() {
	}

	public Modelo(Integer id, String nome, String descricao, Integer potencia) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.potencia = potencia;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nomemodelo", nullable = false)
	private String nome;
	
	@Column (name = "descricao", nullable = false)
	private String descricao;
	
	@Column (name = "potencia", nullable = false)
	private Integer potencia;
	
	@ManyToOne
    @JoinColumn(name="marca_id", nullable=true)
    private Marca marca;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, marca, nome, potencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(marca, other.marca)
				&& Objects.equals(nome, other.nome) && Objects.equals(potencia, other.potencia);
	}

	@Override
	public String toString() {
		return "Modelo [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", potencia=" + potencia
				+ ", marca=" + marca + "]";
	}
	
	
}
