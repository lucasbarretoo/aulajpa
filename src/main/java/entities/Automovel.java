package entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Automovel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Automovel() {
	}

	public Automovel(Integer id, String nome, String observacoes, Integer anoFabricacao, Integer anoModelo, Float preco,
			Integer quilometragem) {
		super();
		this.id = id;
		this.nome = nome;
		this.observacoes = observacoes;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.preco = preco;
		this.quilometragem = quilometragem;
	}



	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nome", nullable = false)
	private String nome;
	
	@Column (name = "observacoes", nullable = false)
	private String observacoes;
	
	@Column (name = "anoFabricacao", nullable = false)
	private Integer anoFabricacao;
	
	@Column (name = "anoModelo", nullable = false)
	private Integer anoModelo;
	
	@Column (name = "preco", nullable = false)
	private Float preco;
	
	@Column (name = "quilometragem", nullable = false)
	private Integer quilometragem;
	
	@ManyToOne
	@JoinColumn(name = "modelo_id", nullable = true)
	private Modelo modelo;
	
    public void adicionarModelo(Modelo M) {
		this.modelo = M;
	}
    
    public void removerModelo(Modelo M) {
		this.modelo = null;
	}

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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(anoFabricacao, anoModelo, modelo, nome, observacoes, preco, quilometragem);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovel other = (Automovel) obj;
		return Objects.equals(anoFabricacao, other.anoFabricacao) && Objects.equals(anoModelo, other.anoModelo)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(nome, other.nome)
				&& Objects.equals(observacoes, other.observacoes) && Objects.equals(preco, other.preco)
				&& Objects.equals(quilometragem, other.quilometragem);
	}

	
	@Override
	public String toString() {
		return "Automovel [id=" + id + ", nome=" + nome + ", observacoes=" + observacoes + ", anoFabricacao="
				+ anoFabricacao + ", anoModelo=" + anoModelo + ", preco=" + preco + ", quilometragem=" + quilometragem
				+ ", modelo=" + modelo+ "]";
	}
	
	
}
