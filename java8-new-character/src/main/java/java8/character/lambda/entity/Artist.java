package java8.character.lambda.entity;

import java.util.List;

/**
 * Created by admin on 2017/7/9.
 */
public class Artist {
    private String name;
    private List<String> membres;
    private String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembres() {
        return membres;
    }

    public void setMembres(List<String> membres) {
        this.membres = membres;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
