package com.app.para.services;
import java.util.List;

import com.app.para.models.Friends;
import com.app.para.models.Invite;
import com.app.para.repository.FriendsRepo;
import com.app.para.repository.InviteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendsService
{
    @Autowired
    private FriendsRepo friendsRepo;
    private InviteRepo inviteRepo;

    public void createInvite(int inviteId, int userFrom, int userTo){
        inviteRepo.save(new Invite(inviteId, userFrom, userTo));
    }
    public void acceptInvite(Invite invite, boolean accept){
        if(accept){
            friendsRepo.save(new Friends(0, invite.getUserFrom(), invite.getUserTo()));
        }
        else{
            inviteRepo.delete(invite);
        }
    }
    public List<Invite> getAllInvites(){
        return inviteRepo.findAll();
    }
    public List<Friends> getAllFriends(){
        return friendsRepo.findAll();
    }
    public void deleteFriends(int id) {
        friendsRepo.deleteById(id);
    }
}
