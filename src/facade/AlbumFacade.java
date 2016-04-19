package facade;

import java.util.List;

import domain.Album;

public interface AlbumFacade {

	List<Album> getAlbumSemParametros();

	List<Album> getAlbum(Integer codAlbum);

	Album salvar(Album album);

	void atualizar(Album album);

	void deletarAlbum(Integer codAlbum);

}
