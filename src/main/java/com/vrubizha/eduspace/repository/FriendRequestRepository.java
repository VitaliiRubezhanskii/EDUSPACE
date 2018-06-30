package com.vrubizha.eduspace.repository;

import com.vrubizha.eduspace.domain.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest,Integer> {


    FriendRequest findByOpponentAccount(int opponentId);


}
