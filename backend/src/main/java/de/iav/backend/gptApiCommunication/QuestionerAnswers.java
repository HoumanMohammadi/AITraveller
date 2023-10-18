package de.iav.backend.gptApiCommunication;

import java.util.List;


public class QuestionerAnswers {
    private int age;
    private List<String> coTraveller;
    private String livingCity;
    private boolean disability;
    private String travelDuration;
    private List<String> activity;
    private String season;
    private List<String> meansOfTravel;
    private List<String> travelPurpose;
    private List<String> destinationContinent;
    private String preferredDestination;

    public QuestionerAnswers(Builder builder, String preferredDestination) {
        this.age = builder.age;
        this.coTraveller = builder.coTraveller;
        this.livingCity = builder.livingCity;
        this.disability = builder.disability;
        this.travelDuration = builder.travelDuration;
        this.activity = builder.activity;
        this.season = builder.season;
        this.meansOfTravel = builder.meansOfTravel;
        this.travelPurpose = builder.travelPurpose;
        this.destinationContinent = builder.destinationContinent;
        this.preferredDestination = builder.preferredDestination;
    }

    public QuestionerAnswers() {

    }

    public String getPreferredDestination() {
        return preferredDestination;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCoTraveller() {
        return coTraveller;
    }

    public String getLivingCity() {
        return livingCity;
    }

    public boolean isDisability() {
        return disability;
    }

    public String getTravelDuration() {
        return travelDuration;
    }

    public List<String> getActivity() {
        return activity;
    }

    public String getSeason() {
        return season;
    }

    public List<String> getTravelPurpose() {
        return travelPurpose;
    }

    public List<String> destinationContinent() {
        return destinationContinent;
    }

    public static class Builder {
        private int age;
        public List<String> coTraveller;
        private  String livingCity;
        private  boolean disability;
        private String travelDuration;
        private List<String> activity;
        private String season;
        private String preferredDestination;
        private List<String> meansOfTravel;
        private List<String> travelPurpose;
        private List<String> destinationContinent;


        @Override
        public String toString() {
            return "Builder{" +
                    "age=" + age +
                    ", coTraveller=" + coTraveller +
                    ", livingCity='" + livingCity + '\'' +
                    ", disability=" + disability +
                    ", travelDuration=" + travelDuration +
                    ", activity=" + activity +
                    ", season='" + season + '\'' +
                    ", meansOfTravel=" + meansOfTravel +
                    ", travelPurpose=" + travelPurpose +
                    ", destinationContinent=" + destinationContinent +
                    ", preferredDestination=" + preferredDestination +
                    '}';
        }

        public QuestionerAnswers build() {
            return new QuestionerAnswers(this, preferredDestination);
        }
    }
}
