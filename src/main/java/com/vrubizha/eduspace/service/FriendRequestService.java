package com.vrubizha.eduspace.service;

import com.vrubizha.eduspace.domain.FriendRequest;

public interface FriendRequestService {

    FriendRequest findByOpponentAccount(int opponentId);
    FriendRequest createFriendRequest(FriendRequest friendRequest);

}
