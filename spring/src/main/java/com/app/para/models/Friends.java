package com.app.para.models;

import jakarta.persistence.*;

@Entity
public class Friends {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int friendListId;
    @OneToOne
    @JoinColumn(name = "owner", referencedColumnName = "user_id")
    @Column(nullable = false)
    private int owner;
    @OneToOne
    @JoinColumn(name = "friend", referencedColumnName = "user_id")
    @Column(nullable = false)
    private int friend;


    public Friends(int friendListId, int owner, int friend) {
        super();
        this.friendListId = friendListId;
        this.owner = owner;
        this.friend = friend;
    }
    public Friends() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getFriendListId() {
        return friendListId;
    }

    public void setFriendListId(int friendListId) {
        this.friendListId = friendListId;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getFriend() {
        return friend;
    }

    public void setFriend(int friend) {
        this.friend = friend;
    }
}