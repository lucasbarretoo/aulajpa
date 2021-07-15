package application;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Automovel;
import entities.Marca;
import entities.Modelo;

public class Application {

	/*
	 * Não consegui sair desse erro na linha 51, não sei porque não consegue criar a fabrica do entityManager na linha 51
	 * O erro na verdade parece estar na relação @ManyToOne das entidades Automovel e modelo
	 * 
	 * Criação das tabelas no banco, mesmo utilizando o método create no persistence.xml as tabelas não foram criadas
	 * 
	 *  create table marca(
	 *		id serial primary key,
	 *		nome character varying(50)
	 *	)
	 *	
	 *	create table modelo(
	 *		id serial primary key,
	 *		nome character varying(50),
	 *		descricao character varying(255),
	 *		potencia integer,
	 *		marca_id integer references marca(id)
	 *	)
	 *	
	 *	create table automovel(
	 *		id serial primary key,
	 *		nome character varying(50),
	 *		anoFabricacao integer,
	 *		anoModelo integer,
	 *		observacoes character varying(255),
	 *		quilometragem integer,
	 *		modelo_id integer references modelo(id)
	 *	)
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ParseException {
		
		System.out.println("\n*** Versão 1 - Inicial ***");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulajpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Automovel automovel = new Automovel(null, "Audi A1", "Cor -> Branca", 2021, 2021, (float) 150000.00, 0);
		
		Modelo modelo = new Modelo(null, "RS", "Super Esportivo Compacto", 300);
		
		Marca marca = new Marca(null,"Audi");
		
		automovel.adicionarModelo(modelo);
		marca.adicionarModelo(modelo);
		
		em.persist(marca);
		em.persist(modelo);
		em.persist(automovel);
		
		em.getTransaction().commit();
		
		Query query1 = em.createQuery("SELECT a FROM Automovel a");
		
		List<Automovel> automoveis = query1.getResultList();
		for (Automovel a : automoveis) {
			System.out.println("\n *** [" + a.getId() + " | Nome: "+ a.getNome() + "Marca: " + a.getModelo().getMarca().getNome() +"] ***");
			
			
		}
		
		
		Query query2 = em.createQuery("SELECT m FROM Marca m");
		
		List<Marca> marcas = query2.getResultList();
		for (Marca m : marcas) {
			System.out.println("\n *** [ " + m.getId() + " | Marca: "+ m.getNome() + "] ***");
			for (Modelo modelos : m.getModelos()) {
				System.out.println("\t " + modelos.getId() + " | Modelo: "+ modelos.getNome() );
			}
		}
		
		em.close();
		emf.close();
	}

}