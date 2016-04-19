package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="tb_artistas")
public class Artista implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codArtista")
	private Integer codArtista;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="nacionalidade")
	private String nacionalidade;

	@OneToMany(mappedBy="artista")
	private List<Album> albuns;

	
	public Artista(){
		super();
	}


	public Integer getCodArtista() {
		return codArtista;
	}


	public void setCodArtista(Integer codArtista) {
		this.codArtista = codArtista;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNacionalidade() {
		return nacionalidade;
	}


	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}


	@XmlTransient
	public List<Album> getAlbuns() {
		return albuns;
	}


	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codArtista == null) ? 0 : codArtista.hashCode());
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
		Artista other = (Artista) obj;
		if (codArtista == null) {
			if (other.codArtista != null)
				return false;
		} else if (!codArtista.equals(other.codArtista))
			return false;
		return true;
	}
	
	
}
