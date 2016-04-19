package dao;

import java.util.List;

import domain.Musica;

public interface MusicaDao {

	List<Musica> getMusica(Musica musica);

	void excluir(Musica musica);

	Musica salvar(Musica musica);

	void atualizar(Musica musica);

}
