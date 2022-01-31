package ru.java.courses.sport1.team.football;

public class FootballPlayer extends Athlete implements ScoringPlayer{
    private String name;
    private int goals;
    private final PlayerRole role;

    public PlayerRole getRole() {
        return role;
    }

    public FootballPlayer(String name, PlayerRole role) {
        if(role == null){
            throw new IllegalArgumentException("Нет возможности создать игрока с ролью null");
        }else {
            this.role = role;
        }

        if(nameCheck(name)) {
            this.name = name;
        }
        goals = 0;
    }

    public void score(){
        if(this.active)
            goals+=1;
        else{
            throw new UnsupportedOperationException("Player is not active");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(nameCheck(name)) {
            this.name = name;
        }
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        if(goals >= 0) {
            this.goals = goals;
        }else{
            throw new IllegalArgumentException("Количество забитых голов не может быть отрицательным");
        }
    }

    public boolean nameCheck(String name){
        if (name == null || name.equals("") || name.strip().length() == 0){
            throw new IllegalArgumentException("Имя тренера обязательно должно быть задано!");
        }else{
            return true;
        }
    }
}
