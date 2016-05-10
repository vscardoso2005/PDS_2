package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="tb_albuns")
@XmlRootElement
public class Album implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codAlbum")
	private Integer codAlbum;

	@Column(name="nome")
	private String nome;
	
	@Column(name="ano")
	private Integer ano;
	
	@ManyToOne
	@JoinColumn(name="artista")
	private Artista artista;

	@OneToMany(mappedBy="album",cascade=CascadeType.ALL)
	private List<Musica> musicas;

	public Album(){
		super();
	}
	
	

	public Album(Integer codAlbum, String nome, Integer ano, Artista artista, List<Musica> musicas) {
		super();
		this.codAlbum = codAlbum;
		this.nome = nome;
		this.ano = ano;
		this.artista = artista;
		this.musicas = musicas;
	}



	public Integer getCodAlbum() {
		return codAlbum;
	}

	public void setCodAlbum(Integer codAlbum) {
		this.codAlbum = codAlbum;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@XmlTransient
	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAlbum == null) ? 0 : codAlbum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (codAlbum == null) {
			if (other.codAlbum != null)
				return false;
		} else if (!codAlbum.equals(other.codAlbum))
			return false;
		return true;
	}

	
}
