package com.javen.model;

public class Tournament {
    private String player;
    private String ethnicity;
    private int population;
    private long gold ;
    private long wood ;
    private String hero;

    public Tournament(String player, String ethnicity, int population, long gold, long wood, String hero) {
        this.player = player;
        this.ethnicity = ethnicity;
        this.population = population;
        this.gold = gold;
        this.wood = wood;
        this.hero = hero;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public long getWood() {
        return wood;
    }

    public void setWood(long wood) {
        this.wood = wood;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }
}
