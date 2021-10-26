package com.sef.customactivityview;

import java.io.Serializable;

public class Cricketer implements Serializable
{
    private String teamName;
    private String cricketerName;

    public Cricketer(String teamName, String cricketerName) {
        this.teamName = teamName;
        this.cricketerName = cricketerName;
    }

    public Cricketer() {
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCricketerName() {
        return cricketerName;
    }

    public void setCricketerName(String cricketerName) {
        this.cricketerName = cricketerName;
    }
}
