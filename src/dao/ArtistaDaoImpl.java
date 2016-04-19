package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import domain.Artista;

public class ArtistaDaoImpl implements ArtistaDao {

	@PersistenceContext(name="PDSIIPU")
	private EntityManager entityManager;

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Artista> getArtista(Artista artista){
		StringBuffer hql = new StringBuffer("from Artista ar where 1 = 1");
		if (artista.getCodArtista() != null) {
			hql.append(" and ar.codArtista = :codArtista");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (artista.getCodArtista() != null) {
			query.setParameter("codAlbum", artista.getCodArtista());
		}
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Artista artista){
		artista = entityManager.merge(artista);
		entityManager.remove(artista);
	}
	
	@Override
	@Transactional
	public Artista salvar(Artista artista){
		entityManager.persist(artista);
		return artista;
	}
	@Override
	@Transactional
	public void atualizar(Artista artista) {
		artista = entityManager.merge(artista);
		entityManager.persist(artista);		
	}
}
