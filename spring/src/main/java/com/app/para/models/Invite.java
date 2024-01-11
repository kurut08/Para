package com.app.para.models;

import jakarta.persistence.*;

public class Invite {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int inviteId;
    @OneToOne
    @JoinColumn(name = "user_from", referencedColumnName = "user_id")
    @Column(nullable = false)
    private int userFrom;
    @OneToOne
    @JoinColumn(name = "user_to", referencedColumnName = "user_id")
    @Column(nullable = false)
    private int userTo;
    boolean status;

    public Invite(int inviteId, int userFrom, int userTo) {
        super();
        this.inviteId = inviteId;
        this.userFrom = userFrom;
        this.userTo = userTo;
    }
    public Invite() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
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
