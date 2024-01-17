package com.app.para.models;

public class InviteHelp {
   private String userFrom;
   private String userTo;
   private String bool;

   public InviteHelp(){
       super();
   }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public String getBool() {
        return bool;
    }

    public void setBool(String bool) {
        this.bool = bool;
    }
}
