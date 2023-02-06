package com.keduit.bpro54.repository;

import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.keduit.bpro54.entity.ClubMember;

public interface ClubMemberRepository extends JpaRepository<ClubMember, String>{
	
	@EntityGraph(attributePaths = {"roleset"}, type = EntityGraph.EntityGraphType.LOAD)
	@Query("select m from ClubMember m where m.fromSocial = :social and m.email = :email")
	Optional<ClubMember> findbyEmail(String email, Boolean social);
}
