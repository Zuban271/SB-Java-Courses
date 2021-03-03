// Класс Игрок
public class Gamer {
    private String name;
    private Integer score;
    private Boolean is_winnner;

    public Gamer(String name, Integer score, Boolean is_winnner) {
        this.name = name;
        this.score = score;
        this.is_winnner = is_winnner;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public Boolean getIs_winnner() {
        return is_winnner;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setIs_winnner(Boolean is_winnner) {
        this.is_winnner = is_winnner;

    }
}
