package com.app.para.services;

import com.app.para.models.ApplicationUser;
import com.app.para.models.Friends;
import com.app.para.models.Invite;
import com.app.para.repository.FriendsRepo;
import com.app.para.repository.InviteRepo;

import java.util.List;
import java.util.Optional;

import com.app.para.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendsService
{
    @Autowired
    private FriendsRepo friendsRepo;
    @Autowired
    private InviteRepo inviteRepo;
    @Autowired
    private UserRepo userRepo;

    public void createInvite(String userFrom, String userTo){
        inviteRepo.save(new Invite(Integer.parseInt(userFrom), Integer.parseInt(userTo)));
    }
    public void acceptInvite(int userFrom, int userTo, boolean accept){
        if(accept){
            friendsRepo.save(new Friends(userRepo.getUserById(userFrom), userRepo.getUserById(userTo)));
        }
        else{
            inviteRepo.deleteByUserFrom(userFrom);
        }
    }
    public Optional<List<Invite>> getAllInvites(Integer id){
        return inviteRepo.findInviteById(id);
    }
    public Optional<List<Friends>> getAllFriends(Integer id){
        return friendsRepo.findFriendsById(id);
    }
    public void deleteFriends(int id, int idOwner) {
        friendsRepo.deleteByOwnerId(id, idOwner);
    }
}
