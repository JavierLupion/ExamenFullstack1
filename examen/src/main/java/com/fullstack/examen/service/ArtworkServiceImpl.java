package com.fullstack.examen.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.examen.exceptions.ArtworkCreationException;
import com.fullstack.examen.exceptions.artistNotFoundException;
import com.fullstack.examen.model.ArtworkDTO;

@Service
public class ArtworkServiceImpl implements ArtworkService {
	
	@Autowired
	ArtistServiceImpl artistService;

	ArrayList<ArtworkDTO> obras = new ArrayList<>();

	ArtworkDTO ar = new ArtworkDTO(1, "Titulo1", "hola soy la descripción uno", 1);
	ArtworkDTO ar2 = new ArtworkDTO(2, "Titulo2", "hola soy la descripción dos", 2);
	ArtworkDTO ar3 = new ArtworkDTO(3, "Titulo3", "hola soy la descripción tres", 1);
	ArtworkDTO ar4 = new ArtworkDTO(4, "Titulo4", "hola soy la descripción cuatro", 3);

	public ArtworkServiceImpl() {

		obras.add(ar);
		obras.add(ar2);
		obras.add(ar3);
		obras.add(ar4);

	}

	@Override
	public ArrayList<ArtworkDTO> getAllArtworks() {
		return obras;
	}

	@Override
	public ArrayList<ArtworkDTO> getAllArtworks(Integer artistId) {
		
		ArrayList<ArtworkDTO> artworks = new ArrayList<>();
		for (ArtworkDTO art : obras) {
			if (art.getArtistId() == artistId) {
				artworks.add(art);
			}
		}
		if (artworks.isEmpty()) {
			throw new artistNotFoundException("No se tiene ninguna obra registrada del artista con ID: "+artistId);
		} else {
			return artworks;
		}
	}

	@Override
	public void createArtwork(ArtworkDTO artworkDTO) {

		if (artistService.getArtistById(artworkDTO.getArtistId()) == null) {
			throw new ArtworkCreationException("El artista no se encuentra registrado");
		} else {

			ArrayList<ArtworkDTO> artworks = getAllArtworks(artworkDTO.getArtistId());
			
			for (ArtworkDTO art : artworks) {
				if (art.getTitle().equals(artworkDTO.getTitle())) {
					throw new ArtworkCreationException("Ya existe una obra de este artista con el mismo título");
				}
			}

			obras.add(artworkDTO);
		}

	}

}
