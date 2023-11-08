package com.fullstack.examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//Lombok no funciona
public class ArtworkDTO {
	
	private Integer id;
	private String title;
	private String description;
	private Integer artistId;
	
	public ArtworkDTO(Integer id, String title, String description, Integer artistId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.artistId = artistId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}
	

}
