package facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import dao.AlbumDao;
import domain.Album;
import facade.AlbumFacade;

@WebService(serviceName="ws/album")
public class AlbumFacadeImpl implements AlbumFacade {

	@Inject
	private AlbumDao albumDao;
			
	@WebMethod
	public List<Album> getAlbumSemParametros() {
		return albumDao.getAlbum(new Album());
	}
	
	@WebMethod(operationName="getAlbumCodigo")
	public List<Album> getAlbum(@WebParam(name="getAlbumCodigo") Integer codAlbum) {
		Album album = new Album();
		album.setCodAlbum(codAlbum);
		return albumDao.getAlbum(album);
	}
	
	@WebMethod
	public Album salvar(@WebParam(name="album") Album album) {
		return albumDao.salvar(album);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="album") Album album) {
		albumDao.atualizar(album);
	}
	
	@WebMethod
	public void deletarAlbum(@WebParam(name="getAlbumCodigo") Integer codAlbum) {
		Album album = new Album();
		album.setCodAlbum(codAlbum);
		albumDao.excluir(album);
	}
}