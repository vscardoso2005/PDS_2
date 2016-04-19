package facade;

import java.util.List;

import domain.Musica;

public interface MusicaFacade {

	List<Musica> getMusicaSemParametros();

	List<Musica> getMusica(Integer codMusica);

	Musica salvar(Musica musica);

	void atualizar(Musica Musica);

	void deletarMusica(Integer codMusica);

}
