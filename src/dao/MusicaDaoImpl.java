package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import domain.Musica;

public class MusicaDaoImpl implements MusicaDao {

	@PersistenceContext(name="PDSIIPU")
	private EntityManager entityManager;

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Musica> getMusica(Musica musica){
		StringBuffer hql = new StringBuffer("from Musica m where 1 = 1");
		if (musica.getCodMusica() != null) {
			hql.append(" and m.codMusica = :codMusica");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (musica.getCodMusica() != null) {
			query.setParameter("codMusica", musica.getCodMusica());
		}
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Musica musica){
		musica = entityManager.merge(musica);
		entityManager.remove(musica);
	}
	
	@Override
	@Transactional
	public Musica salvar(Musica musica){
		entityManager.persist(musica);
		return musica;
	}
	@Override
	@Transactional
	public void atualizar(Musica musica) {
		musica = entityManager.merge(musica);
		entityManager.persist(musica);		
	}
}
