package com.app.para.models;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class HelpOrder {
    private String userId;
    private List<String> gameId;

    public HelpOrder(String userId, List<String> gameId) throws JsonProcessingException {
        super();
        this.userId = userId;
        this.gameId = gameId;
    }
    public HelpOrder(){
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getGameId() {
        return gameId;
    }

    public void setGameId(List<String> gameId) {
        this.gameId = gameId;
    }
}
