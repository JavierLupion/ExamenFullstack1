package com.fullstack.examen.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fullstack.examen.model.ArtworkDTO;
import com.fullstack.examen.service.ArtworkServiceImpl;

@RestController
@RequestMapping("/artworks")
public class ArtworkController {
	
	@Autowired
	ArtworkServiceImpl artworkService;
	
	@PostMapping()
	public ResponseEntity<?> saveArtwork(@RequestBody ArtworkDTO artwork){
		
		artworkService.createArtwork(artwork);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(artwork.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
			
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllArtworks(){
		return ResponseEntity.ok(artworkService.getAllArtworks());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllArtworks(@PathVariable Integer id){
		return ResponseEntity.ok(artworkService.getAllArtworks(id));
	}
}