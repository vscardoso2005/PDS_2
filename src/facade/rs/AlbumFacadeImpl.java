package facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AlbumDao;
import domain.Album;
import facade.AlbumFacade;

@Path("/album")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AlbumFacadeImpl implements AlbumFacade {

	@Inject
	private AlbumDao albumDao;
	
	@Override
	@GET
	public List<Album> getAlbumSemParametros() {
		return albumDao.getAlbum(new Album());
	}
	
	@Override
	@GET
	@Path("/{codAlbum}")
	public List<Album> getAlbum(@PathParam("codAlbum") Integer codAlbum) {
		Album album = new Album();
		album.setCodAlbum(codAlbum);
		return albumDao.getAlbum(album);
	}

	@Override
	@POST 
	public Album salvar(Album album) { 
		return albumDao.salvar(album);
	}
	
	@Override
	@PUT 
	public void atualizar(Album album) { 
		albumDao.atualizar(album);
	}

	@Override
	@DELETE
	@Path("/{codAlbum}")
	public void deletarAlbum(@PathParam("codAlbum") Integer codAlbum) {
		Album album = new Album();
		album.setCodAlbum(codAlbum);
		albumDao.excluir(album);
	}
}
