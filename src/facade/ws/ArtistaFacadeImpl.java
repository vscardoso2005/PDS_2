package facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import dao.ArtistaDao;
import domain.Artista;
import facade.ArtistaFacade;

@WebService(serviceName="ws/artista")
public class ArtistaFacadeImpl implements ArtistaFacade {

	
	@Inject
	private ArtistaDao artistaDao;
			
	@WebMethod
	public List<Artista> getArtistaSemParametros() {
		return artistaDao.getArtista(new Artista());
	}
	
	@WebMethod(operationName="getArtistaCodigo")
	public List<Artista> getArtista(@WebParam(name="codigoArtista") Integer codArtista) {
		Artista artista = new Artista();
		artista.setCodArtista(codArtista);
		return artistaDao.getArtista(artista);
	}
	
	@WebMethod
	public Artista salvar(@WebParam(name="artista") Artista artista) {
		return artistaDao.salvar(artista);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="artista") Artista artista) {
		artistaDao.atualizar(artista);
	}
	
	@WebMethod
	public void deletarArtista(@WebParam(name="codigoArtista") Integer codArtista) {
		Artista artista = new Artista();
		artista.setCodArtista(codArtista);
		artistaDao.excluir(artista);
	}

}
