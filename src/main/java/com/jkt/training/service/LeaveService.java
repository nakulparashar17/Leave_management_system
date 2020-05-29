package com.jkt.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.entity.LeavesTrack;
import com.jkt.training.repository.LeaveRepository;

import com.jkt.training.exception.*;


@Service
public class LeaveService {
	
	@Autowired
	private LeaveRepository repository;
	
	@SuppressWarnings("deprecation")
	public LeavesTrack applyLeaves(LeavesTrack leaves) {
		if(!leaves.getFromDate().equals(null)&&!leaves.getToDate().equals(null)
			&&!leaves.getReason().equals(null)&&!leaves.getType().equals(null)) {
				int duration=leaves.getToDate().getDate()-leaves.getFromDate().getDate();
				leaves.setDuration(duration+1);
				leaves.setActive(true);
				return repository.save(leaves);
		}
		else {
			throw new NotFoundException("Some field data is missing!!");
		}
	}
	
	public List<LeavesTrack> getAllLeaves(){
		if(repository.findAll().isEmpty()) 
			throw new NotFoundException("Leaves record is Empty!");
		else 
			return repository.findAll();
	}
	
	public Optional<LeavesTrack> getLeavesById(int id) {
		if(repository.findById(id).isPresent())
			return repository.findById(id);
		else
			throw new NotFoundException("Leave Record with id="+id+" not exist!");
	}
	
	public LeavesTrack updateLeaves(LeavesTrack leaves,int id) {
		if(repository.existsById(id)) {
			if(!leaves.getFromDate().equals(null)&&!leaves.getToDate().equals(null)
					&&!leaves.getReason().equals(null)&&!leaves.getType().equals(null)) {
				return repository.save(leaves);
			}
			else
				throw new NotFoundException("Wrong Update/missing data!!");
		}
		else
			throw new NotFoundException("Leaves record Id not found for updation!");
		 
	}
	
	public List<LeavesTrack> getAllActiveLeaves() {
		 return repository.getAllActiveLeaves();
	}
	
	public void deleteLeaves(int id) {
		if(repository.existsById(id)) 
			repository.deleteById(id);
		else
			throw new NotFoundException("Leaves record Id not found for deletion!");
		
	}
}
