package com.jkt.training.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.training.entity.LeavesTrack;
import com.jkt.training.service.LeaveService;

@RestController
@RequestMapping("/api")
public class LeavesController {

	@Autowired
	private LeaveService service;
	
	@GetMapping("/leaves")
	public List<LeavesTrack> getAllLeaves(){
		return service.getAllLeaves();
	}
	
	@GetMapping("/leaves/{l_id}")
	public ResponseEntity<?> getLeavesById(@PathVariable int l_id) {
		Optional<LeavesTrack> leaves= service.getLeavesById(l_id);
		return leaves.map(response->ResponseEntity.ok().body(response))
			   .orElse(new ResponseEntity<LeavesTrack>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/leaves/active")
	public List<LeavesTrack> getAllActiveLeaves(){
		return service.getAllActiveLeaves();
	}
	
	@PostMapping(path = "/leaves",consumes = "application/json")
	public ResponseEntity<LeavesTrack> applyLeaves(@Valid @RequestBody LeavesTrack leaves)throws URISyntaxException{
		LeavesTrack result=service.applyLeaves(leaves);
		return ResponseEntity.created(new URI("/api/leaves"+result.getId())).body(result);

	}
	
	@PutMapping(path = "/leaves/{l_id}",consumes = "application/json")
	ResponseEntity<LeavesTrack> updateLeaves(@Valid @RequestBody LeavesTrack leaves,@PathVariable int l_id){
		//LeavesTrack result=service.updateLeaves(leaves,l_id);;
		LeavesTrack result=service.applyLeaves(leaves);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/leaves/{l_id}")
	ResponseEntity<?> deleteLeaves(@PathVariable int l_id){
		service.deleteLeaves(l_id);
		return ResponseEntity.ok().build();
	}
}
