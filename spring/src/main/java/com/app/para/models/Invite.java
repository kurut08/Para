package com.app.para.models;

import jakarta.persistence.*;
@Entity
public class Invite {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "user_from", referencedColumnName = "user_id")
    @Column(nullable = false)
    private ApplicationUser userFrom;
    @JoinColumn(name = "user_to", referencedColumnName = "user_id")
    @Column(nullable = false)
    private ApplicationUser userTo;
    boolean status;

    public Invite(ApplicationUser userFrom, ApplicationUser userTo) {
        super();
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

    public ApplicationUser getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(ApplicationUser userFrom) {
        this.userFrom = userFrom;
    }

    public ApplicationUser getUserTo() {
        return userTo;
    }

    public void setUserTo(ApplicationUser userTo) {
        this.userTo = userTo;
    }


}
