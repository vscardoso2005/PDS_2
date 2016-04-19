package facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ArtistaDao;
import domain.Artista;
import facade.ArtistaFacade;

@Path("/artista")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

public class ArtistaFacadeImpl implements ArtistaFacade {

	
	@Inject
	private ArtistaDao artistaDao;
			
	@Override
	@GET
	public List<Artista> getArtistaSemParametros() {
		return artistaDao.getArtista(new Artista());
	}

	@Override
	@GET
	@Path("/{codArtista}")
	public List<Artista> getArtista(@WebParam(name="codigoArtista") Integer codArtista) {
		Artista artista = new Artista();
		artista.setCodArtista(codArtista);
		return artistaDao.getArtista(artista);
	}
	
	@Override
	@POST 
	public Artista salvar(@WebParam(name="artista") Artista artista) {
		return artistaDao.salvar(artista);
	}
	
	@Override
	@PUT 
	public void atualizar(@WebParam(name="artista") Artista artista) {
		artistaDao.atualizar(artista);
	}
	
	@Override
	@DELETE
	@Path("/{codArtista}")
	public void deletarArtista(@WebParam(name="codigoArtista") Integer codArtista) {
		Artista artista = new Artista();
		artista.setCodArtista(codArtista);
		artistaDao.excluir(artista);
	}
}