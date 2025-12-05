package com.acyeow.badmintonapi.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ms_rankings")
public class Player {
    @Column(name="\"Rank\"")
    private int rank;

    @Id
    @Column(name="\"Player Name\"", unique=true)
    private String name;

    @Column(name="\"Country\"")
    private String country;

    @Column(name="\"Points\"")
    private int points;

    @Column(name="\"Tournaments\"")
    private int tournaments;

    @Column(name="\"Last Update\"")
    private String lastUpdate;

    @Column(name="\"Rank Change\"")
    private String rankChange;

    public Player() {
    }

    public Player(int rank, String name, String country, int points, int tournaments, String lastUpdate, String rankChange) {
        this.rank = rank;
        this.name = name;
        this.country = country;
        this.points = points;
        this.tournaments = tournaments;
        this.lastUpdate = lastUpdate;
        this.rankChange = rankChange;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTournaments() {
        return tournaments;
    }

    public void setTournaments(int tournaments) {
        this.tournaments = tournaments;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getRankChange() {
        return rankChange;
    }

    public void setRankChange(String rankChange) {
        this.rankChange = rankChange;
    }
}
