package com.vrubizha.eduspace.service.serviceImpl;

import com.vrubizha.eduspace.domain.FriendRequest;
import com.vrubizha.eduspace.repository.FriendRequestRepository;
import com.vrubizha.eduspace.service.FriendRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FriendRequestServiceImpl implements FriendRequestService {

    private  final FriendRequestRepository friendRequestRepository;

    @Autowired
    public FriendRequestServiceImpl(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }


    @Override
    public FriendRequest findByOpponentAccount(int opponentId) {
        return friendRequestRepository.findByOpponentAccount(opponentId);
    }

    @Override
    public FriendRequest createFriendRequest(FriendRequest friendRequest) {
        return friendRequestRepository.save(friendRequest);
    }
}
