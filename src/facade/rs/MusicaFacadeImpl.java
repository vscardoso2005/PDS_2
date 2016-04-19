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

import dao.MusicaDao;
import domain.Musica;
import facade.MusicaFacade;

@Path("/musica")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

public class MusicaFacadeImpl implements MusicaFacade{
	
	@Inject
	private MusicaDao musicaDao;
			
	@Override
	@GET
	public List<Musica> getMusicaSemParametros() {
		return musicaDao.getMusica(new Musica());
	}
	
	@Override
	@GET
	@Path("/{codMusica}")
	public List<Musica> getMusica(@WebParam(name="codigoMusica") Integer codMusica) {
		Musica musica = new Musica();
		musica.setCodMusica(codMusica);;
		return musicaDao.getMusica(musica);
	}
	
	@Override
	@POST 
	public Musica salvar(@WebParam(name="musica") Musica musica) {
		return musicaDao.salvar(musica);
	}
	
	@Override
	@PUT 
	public void atualizar(@WebParam(name="Musica") Musica Musica) {
		musicaDao.atualizar(Musica);
	}
	
	@Override
	@DELETE
	@Path("/{codMusica}")
	public void deletarMusica(@WebParam(name="codigoMusica") Integer codMusica) {
		Musica Musica = new Musica();
		Musica.setCodMusica(codMusica);
		musicaDao.excluir(Musica);
	}

}
