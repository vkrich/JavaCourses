package ru.java.courses.sport.team.football;

public class Coach {
    private String name;
    private int experience;

    public Coach(String name, int experience) {
        if(nameCheck(name)) {
            this.name = name;
        }
        this.experience = experience;
    }

    public Coach(String name) {
        if(nameCheck(name)) {
            this.name = name;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        if(experience >= 0) {
            this.experience = experience;
        }else{
            throw new IllegalArgumentException("Опыт тренера не может быть отрицательным");
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
