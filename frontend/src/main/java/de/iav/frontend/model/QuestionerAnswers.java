package de.iav.frontend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionerAnswers {
    private  int age;
    private  List<String> coTraveller;
    private  String livingCity;
    private  boolean disability;
    private  String travelDuration;
    private  List<String> activity;
    private  String season;
    private  List<String> meansOfTravel;
    private  List<String> travelPurpose;
    private  List<String> destinationContinent;
    private  String preferredDestination;
    public QuestionerAnswers() {
    }

    private QuestionerAnswers(Builder builder, String preferredDestination) {
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
        this.preferredDestination = preferredDestination;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCoTraveller() {
        return coTraveller;
    }

    public String getPreferredDestination() {
        return preferredDestination;
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

    public List<String> getMeansOfTravel() {
        return meansOfTravel;
    }

    public List<String> getTravelPurpose() {
        return travelPurpose;
    }

    public List<String> getDestinationContinent() {
        return destinationContinent;
    }

    public int age() {
        return age;
    }

    public List<String> coTraveller() {
        return coTraveller;
    }

    public String livingCity() {
        return livingCity;
    }

    public boolean disability() {
        return disability;
    }

    public String travelDuration() {
        return travelDuration;
    }

    public List<String> activity() {
        return activity;
    }

    public String season() {
        return season;
    }

    public List<String> meansOfTravel() {
        return meansOfTravel;
    }

    public List<String> travelPurpose() {
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

        public Builder() {
        }

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


        public Builder(int age, List<String> coTraveller, String livingCity, boolean disability, String travelDuration, List<String> activity, String season, String preferredDestination, List<String> meansOfTravel, List<String> travelPurpose, List<String> destinationContinent) {
            this.age = age;
            this.coTraveller = coTraveller;
            this.livingCity = livingCity;
            this.disability = disability;
            this.travelDuration = travelDuration;
            this.activity = activity;
            this.season = season;
            this.preferredDestination = preferredDestination;
            this.meansOfTravel = meansOfTravel;
            this.travelPurpose = travelPurpose;
            this.destinationContinent = destinationContinent;
        }



        public Builder livingCity(String livingCity) {
            this.livingCity = livingCity;
            return this;
        }

        public Builder preferredDestination(String preferredDestination) {
            this.preferredDestination = preferredDestination;
            return this;
        }

        public Builder disability(boolean disability) {
            this.disability = disability;
            return this;
        }

        public Builder travelDuration(String travelDuration) {
            this.travelDuration = travelDuration;
            return this;
        }

        public Builder activity(List<String> activity) {
            this.activity = activity;
            return this;
        }

        public Builder coTraveller(List<String> coTraveller) {
            this.coTraveller = coTraveller;
            return this;
        }

        public Builder age(int age){
            this.age=age;
            return this;
        }

        public Builder season(String season) {
            this.season = season;
            return this;
        }

        public Builder meansOfTravel(List<String> meansOfTravel) {
            this.meansOfTravel = meansOfTravel;
            return this;
        }

        public Builder travelPurpose(List<String> travelPurpose) {
            this.travelPurpose = travelPurpose;
            return this;
        }

        public Builder destinationContinent(List<String> destinationContinent) {
            this.destinationContinent = destinationContinent;
            return this;
        }

        public QuestionerAnswers build() {
            return new QuestionerAnswers(this, preferredDestination);
        }
    }
}

