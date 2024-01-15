package com.app.para.models;

import jakarta.persistence.*;

@Entity
public class Friends {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "owner", referencedColumnName = "user_id")
    @Column(nullable = false)
    private ApplicationUser owner;
    @JoinColumn(name = "friend", referencedColumnName = "user_id")
    @Column(nullable = false)
    private ApplicationUser friend;


    public Friends(ApplicationUser owner, ApplicationUser friend) {
        super();
        this.owner = owner;
        this.friend = friend;
    }
    public Friends() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getFriendListId() {
        return id;
    }

    public void setFriendListId(int friendListId) {
        this.id = friendListId;
    }

    public ApplicationUser getOwner() {
        return owner;
    }

    public void setOwner(ApplicationUser owner) {
        this.owner = owner;
    }

    public ApplicationUser getFriend() {
        return friend;
    }

    public void setFriend(ApplicationUser friend) {
        this.friend = friend;
    }
}