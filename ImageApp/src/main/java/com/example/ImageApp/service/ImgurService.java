package com.example.ImageApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImgurService {
	/*
	 * @Value("${imgur.client-id}") private String clientId;
	 */

	@Value("${imgur.accessToken}")
	private String accessToken;

	private final RestTemplate restTemplate;

	public ImgurService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	// upload Image
	public String uploadImage(MultipartFile file) {
		HttpHeaders headers = new HttpHeaders();
		/* headers.set("Authorization", "Client-ID " + clientId); */
		headers.set("Authorization", "Bearer " + accessToken);
		System.out.println("Authorization Header: " + headers.get("Authorization"));

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("image", new HttpEntity<>(file.getResource()));

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"https://api.imgur.com/3/image", 
				HttpMethod.POST,
				requestEntity, 
				String.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			// Process the Imgur API response
			return response.getBody();
		} else {
			// Handle error
			return null;
		}
	}

	// retrive Image
	
	public ResponseEntity<String> retrieveImageFromImgur(String imageId) {
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("Authorization", "Bearer " + accessToken);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		String imgurImageUrl = "https://api.imgur.com/3/image/" + imageId;

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.exchange(imgurImageUrl,
				HttpMethod.GET, 
				entity, 
				String.class,
				imageId);
		
		return response; 
	}
	
	

    public ResponseEntity<String> deleteImage(String imageId) {
        HttpHeaders headers = new HttpHeaders();
		/*
		 * headers.set("Authorization", "Client-ID " + clientId);
		 */
		headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);


        ResponseEntity<String> response = restTemplate.exchange(
            "https://api.imgur.com/3/image/" + imageId,
            HttpMethod.DELETE,
            entity,
            String.class
        );

		/*
		 * if (response.getStatusCode() == HttpStatus.OK) { // Image deleted
		 * successfully } else { // Handle the error }
		 */
        return ResponseEntity.ok("Image deleted successfully");

    }

}
