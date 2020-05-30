package com.jkt.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.jkt.training.entity.LeavesTrack;

public interface LeaveRepository extends JpaRepository<LeavesTrack, Integer> {

	public List<LeavesTrack> findByEmployeeId(int eid);
	
	@Query(nativeQuery = true, value = "select * from leaves_track where active=true")
	public List<LeavesTrack> getAllActiveLeaves();
}
