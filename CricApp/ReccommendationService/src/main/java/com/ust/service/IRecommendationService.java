package com.ust.service;

import java.util.List;

import com.ust.entity.Recommendation;

public interface IRecommendationService {

	List<Recommendation> findAllRecommendedMatches();

	Recommendation findByRecommendationMatchId(Integer matchId);

	Recommendation addRecommendationMatch(int matchId);

	void updateRecommendationMatch(int matchId);

}
