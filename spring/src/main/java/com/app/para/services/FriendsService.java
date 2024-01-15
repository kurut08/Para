package com.app.para.services;

import com.app.para.models.ApplicationUser;
import com.app.para.models.Friends;
import com.app.para.models.Invite;
import com.app.para.repository.FriendsRepo;
import com.app.para.repository.InviteRepo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendsService
{
    @Autowired
    private FriendsRepo friendsRepo;
    private InviteRepo inviteRepo;

    public void createInvite(ApplicationUser userFrom, ApplicationUser userTo){
        inviteRepo.save(new Invite(userFrom, userTo));
    }
    public void acceptInvite(Invite invite, boolean accept){
        if(accept){
            friendsRepo.save(new Friends( invite.getUserFrom(), invite.getUserTo()));
        }
        else{
            inviteRepo.delete(invite);
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
