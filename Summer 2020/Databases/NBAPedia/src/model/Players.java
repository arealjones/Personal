package model;

import java.util.Date;

public class Players {
    private int playerId;
    private String name;
    private String fullName;
    private String position;
    private String position2;
    private String height;
    private int weight;
    private Date birthDate;
    private boolean retired;
    private String about;
    private String imgUrl;

    public Players(int playerId, String name, String fullName, String position,
        String position2, String height, int weight, Date birthDate, boolean retired,
        String about) {
        this.playerId = playerId;
        this.name = name;
        this.fullName = fullName;
        this.position = position;
        this.position2 = position2;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
        this.retired = retired;
        this.about = about;
    }

    public Players(int playerId, String name, String fullName, String position,
        String position2, String height, int weight, Date birthDate, boolean retired,
        String about, String imgUrl) {
        this.playerId = playerId;
        this.name = name;
        this.fullName = fullName;
        this.position = position;
        this.position2 = position2;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
        this.retired = retired;
        this.about = about;
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public Players() {
    }

    public Players(String name) {
        this.name = name;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerIdString() {
        return Integer.toString(playerId);
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition2() {
        return position2;
    }

    public void setPosition2(String position2) {
        this.position2 = position2;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isRetired() {
        return retired;
    }

    public String getRetired() {
        if (this.isRetired()) {
            return "Retired";
        }
        return "Active";
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }


    @Override
    public String toString() {
        return "Players{" +
            "playerId=" + playerId +
            ", name='" + name + '\'' +
            ", fullName='" + fullName + '\'' +
            ", position='" + position + '\'' +
            ", position2='" + position2 + '\'' +
            ", height='" + height + '\'' +
            ", weight=" + weight +
            ", birthDate=" + birthDate +
            ", retired=" + retired +
            ", about='" + about + '\'' +
            '}';
    }
}
