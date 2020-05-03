package com.mkdev.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.mkdev.example.model.DnUser;

/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-May-03 9:54:05 pm 
 */
@Service
public class DnUserConsumeService {

	private static final Log log = LogFactory.getLog(DnUserConsumeService.class);
	
	public DnUser getUser(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<DnUser> entity = restTemplate.getForEntity("http://localhost:8090/api/v1/users/{id}",
				DnUser.class, Long.toString(id));
		log.info(" Status Code " + entity.getStatusCode());
		log.info(" Status Code " + entity.getBody());
		return entity.getBody();
	}

	public List<DnUser> getUserList() {
		RestTemplate restTemplate = new RestTemplate();
		List<DnUser> users = new ArrayList<DnUser>();
		try {
			ResponseEntity<List<DnUser>> userResponse = restTemplate.exchange("http://localhost:8090/api/v1/users",
					HttpMethod.GET, new HttpEntity<String>("some sample body sent along the get User request"), new ParameterizedTypeReference<List<DnUser>>() {
					});
			if (userResponse != null && userResponse.hasBody()) {
				users = userResponse.getBody();
			}
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return users;
	}

	public void createOrUpdateUser(DnUser user) {
		// request url
		String url = "http://localhost:8090/api/v1/users";

		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		// build the request
		HttpEntity<DnUser> request = new HttpEntity<>(user, headers);

		ResponseEntity<DnUser> response = restTemplate.postForEntity(url, request, DnUser.class);
		log.info(" Status Code " + response.getStatusCode());
		if (response.getStatusCode() == HttpStatus.CREATED) {
			log.info("DnUser Created");
			log.info(response.getBody());
		} else {
			log.info("Request Failed");
			log.info(response.getStatusCode());
		}
	}

	public String deleteUser(Long id) {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8090/api/v1/user/{id}",
				HttpMethod.DELETE, new HttpEntity<String>("some sample body sent along the DELETE request"),
				String.class, Long.toString(id));

		// exchange.get
		// restTemplate.delete("http://localhost:8090/api/v1/users/{id}", id);

		log.info(" Status Code " + exchange.getStatusCode());
		log.info(" Status Code " + exchange.getBody());
		return exchange.getBody();
	}
}

/*
 * ResponseEntity<Object[]> responseEntity =
 * restTemplate.getForEntity(urlGETList, Object[].class); Object[] objects =
 * responseEntity.getBody(); MediaType contentType =
 * responseEntity.getHeaders().getContentType(); HttpStatus statusCode =
 * responseEntity.getStatusCode();
 * 
 * 
 * @RequestMapping(value="/Object/getList/", method=RequestMethod.GET)
 * public @ResponseBody List<Object> findAllObjects() {
 * 
 * List<Object> objects = new ArrayList<Object>(); return objects; }
 */