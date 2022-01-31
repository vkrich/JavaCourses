package ru.java.courses.sport1.team.football;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FootballTeam{

    private String name;
    private Coach coach;
    private List<FootballPlayer> players = new ArrayList<>();

    public final static int MAX_PLAYERS_COUNT = 20;

    public FootballTeam(String name) {
        if(nameCheck(name)) {
            this.name = name;
        }
    }
    public boolean nameCheck(String name){
        if (name == null || name.equals("") || name.strip().length() == 0){
            throw new IllegalArgumentException("Имя команды обязательно должно быть задано!");
        }else{
            return true;
        }
    }

    public void setName(String name) {
        if(nameCheck(name)) {
            this.name = name;
        }
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Coach getCoach() {
        return coach;
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayersCount(){
        return MAX_PLAYERS_COUNT;
    }

    public List<FootballPlayer> getPlayers(){
        return players;
    }

    public void addPlayer(FootballPlayer pl){
        if(players.size() < MAX_PLAYERS_COUNT) {
            players.add(pl);
        }else{
            throw new IllegalArgumentException("Превышено количество человек в команде!");
        }
    }

    public void removePlayer(String name){
        for(FootballPlayer a: players){
            if(a.getName().equals(name)){
                players.remove(a);
            }
        }
    }

    public void removePlayer(FootballPlayer player){
        players.remove(player);
    }

    public int getPlayersCount(){
        return players.size();
    }

    public int getScore(){
        int score= 0;
        for(FootballPlayer player: players){
            score += player.getGoals();
        }
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballTeam that = (FootballTeam) o;
        return name.equals(that.name) && coach.equals(that.coach) && players.equals(that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coach, players);
    }

    public void addPlayers(FootballPlayer player1, FootballPlayer  player2, FootballPlayer  player3) {
        players.add(player1);
        players.add(player2);
        players.add(player3);
    }
}
