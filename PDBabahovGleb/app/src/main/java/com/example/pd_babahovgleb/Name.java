package com.example.pd_babahovgleb;

public class Name {
    private String english;
    private String japanese;
    private String chinese;
    private String french;

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }

    @Override
    public String toString() {
        return "Name{" +
                "english='" + english + '\'' +
                ", japanese='" + japanese + '\'' +
                ", chinese='" + chinese + '\'' +
                ", french='" + french + '\'' +
                '}';
    }
}
