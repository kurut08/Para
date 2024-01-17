package com.app.para.models;

import jakarta.persistence.*;

@Entity
@Table(name="glhhelp")
public class GLHelp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private boolean ok;
    @Column(nullable = false)
    private String text;

    public GLHelp(boolean ok, String text) {
        super();
        this.ok = ok;
        this.text = text;
    }

    public GLHelp(){super();}
    public boolean ok() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
