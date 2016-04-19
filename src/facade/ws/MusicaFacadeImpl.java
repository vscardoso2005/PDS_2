package facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import dao.MusicaDao;
import domain.Musica;
import facade.MusicaFacade;

@WebService(serviceName="ws/musica")
public class MusicaFacadeImpl implements MusicaFacade{
	
	@Inject
	private MusicaDao musicaDao;
			
	@WebMethod
	public List<Musica> getMusicaSemParametros() {
		return musicaDao.getMusica(new Musica());
	}
	
	@WebMethod(operationName="getMusicaCodigo")
	public List<Musica> getMusica(@WebParam(name="codigoMusica") Integer codMusica) {
		Musica musica = new Musica();
		musica.setCodMusica(codMusica);;
		return musicaDao.getMusica(musica);
	}
	
	@WebMethod
	public Musica salvar(@WebParam(name="musica") Musica musica) {
		return musicaDao.salvar(musica);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="Musica") Musica Musica) {
		musicaDao.atualizar(Musica);
	}
	
	@WebMethod
	public void deletarMusica(@WebParam(name="codigoMusica") Integer codMusica) {
		Musica Musica = new Musica();
		Musica.setCodMusica(codMusica);
		musicaDao.excluir(Musica);
	}

}
