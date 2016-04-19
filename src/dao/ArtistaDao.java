package dao;

import java.util.List;


import domain.Artista;

public interface ArtistaDao {

	List<Artista> getArtista(Artista artista);

	void excluir(Artista artista);

	Artista salvar(Artista artista);

	void atualizar(Artista artista);

}
