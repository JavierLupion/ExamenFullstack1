package com.fullstack.examen.service;

import java.util.ArrayList;

import com.fullstack.examen.model.ArtworkDTO;

public interface ArtworkService {
	
	public ArrayList<ArtworkDTO> getAllArtworks();
	public ArrayList<ArtworkDTO> getAllArtworks(Integer artistId);
	void createArtwork(ArtworkDTO artworkDTO);

}
