package com.app.para.models;

import jakarta.persistence.*;
@Entity
public class Invite {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "user_from", referencedColumnName = "user_id")
    @Column(nullable = false)
    private int userFrom;
    @JoinColumn(name = "user_to", referencedColumnName = "user_id")
    @Column(nullable = false)
    private int userTo;
    boolean status;

    public Invite(int inviteId, int userFrom, int userTo) {
        super();
        this.id = inviteId;
        this.userFrom = userFrom;
        this.userTo = userTo;
    }
    public Invite() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getInviteId() {
        return id;
    }

    public void setInviteId(int inviteId) {
        this.id = inviteId;
    }

    public int getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(int userFrom) {
        this.userFrom = userFrom;
    }

    public int getUserTo() {
        return userTo;
    }

    public void setUserTo(int userTo) {
        this.userTo = userTo;
    }


}
