package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import domain.Album;

public class AlbumDaoImpl implements AlbumDao {
	
	@PersistenceContext(name="PDSIIPU")
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Album> getAlbum(Album album){
		StringBuffer hql = new StringBuffer("from Album a where 1 = 1");
		if (album.getCodAlbum() != null) {
			hql.append(" and a.codAlbum = :codAlbum");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (album.getCodAlbum() != null) {
			query.setParameter("codAlbum", album.getCodAlbum());
		}
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Album album){
		album = entityManager.merge(album);
		entityManager.remove(album);
	}
	
	@Override
	@Transactional
	public Album salvar(Album album){
		entityManager.persist(album);
		return album;
	}
	@Override
	@Transactional
	public void atualizar(Album album) {
		album = entityManager.merge(album);
		entityManager.persist(album);		
	}

}
