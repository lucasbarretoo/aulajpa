package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Marca implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Marca() {
	}

	public Marca(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nome", nullable = false)
	private String nome;
	
    @OneToMany(mappedBy="modelo_id")
	private List<Modelo> modelos= new ArrayList<>();

    public void adicionarModelo(Modelo M) {
		this.modelos.add(M);
		M.setMarca(M.getMarca());
	}
    
    public void removerModelo(Modelo M) {
		this.modelos.remove(M);
		M.setMarca(null);
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

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(modelos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		return Objects.equals(modelos, other.modelos) && Objects.equals(nome, other.nome);
	}


	@Override
	public String toString() {
		return "Marca [id=" + id + ", nome=" + nome + ", modelos=" + modelos + "]";
	}
	

}
