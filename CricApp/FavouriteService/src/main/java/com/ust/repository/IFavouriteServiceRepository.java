package com.ust.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ust.entity.Favourite;

@Repository
public interface IFavouriteServiceRepository extends JpaRepository<Favourite, Integer>{
	@Query ("SELECT f FROM Favourite f where f.matchId = :macthId and f.userName = :userName" )
	public Favourite findByUserNameAndMatchId(@Param("userName") String userName, @Param("macthId") Integer macthId);
	
	@Query ("SELECT f FROM Favourite f where f.userName = :userName" )
	public List<Favourite> findAllFavouriteMatchesByUserName(@Param("userName") String userName);
	
}
