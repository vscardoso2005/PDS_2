package facade;

import java.util.List;

import domain.Artista;

public interface ArtistaFacade {

	List<Artista> getArtistaSemParametros();

	List<Artista> getArtista(Integer codArtista);

	void deletarArtista(Integer codArtista);

	void atualizar(Artista artista);

	Artista salvar(Artista artista);

}
