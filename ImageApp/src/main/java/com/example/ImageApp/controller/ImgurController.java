package com.example.ImageApp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ImageApp.service.ImgurService;

@RestController
@RequestMapping("/api/imgur")
public class ImgurController {
	private final ImgurService imgurService;

	public ImgurController(ImgurService imgurService) {
		this.imgurService = imgurService;
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			String imgurResponse = imgurService.uploadImage(file);
			if (imgurResponse != null) {
				return ResponseEntity.ok(imgurResponse);
			}
		}
		return ResponseEntity.badRequest().build();
	}

	
	
	
	
	 @GetMapping("/retrieveImage/{imageId}")
	    public ResponseEntity<String> retrieveImage(@PathVariable String imageId) {
	        ResponseEntity<String> imageBytes = imgurService.retrieveImageFromImgur(imageId);
			
	         return imageBytes;
	    }

	   @DeleteMapping("/delete/{imageId}")
	    public ResponseEntity<String> deleteImage(@PathVariable String imageId) {
	        ResponseEntity<String> response =imgurService.deleteImage(imageId);
	        return response;
	    }

	       
}
