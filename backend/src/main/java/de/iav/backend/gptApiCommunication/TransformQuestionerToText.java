package de.iav.backend.gptApiCommunication;

public class TransformQuestionerToText {

    public String transform(QuestionerAnswers answers) {
        // Create a message using the provided answers
        String message = "Hi, I am " + answers.getAge() + " years old and want to travel. ";

        // Join co-traveler list
        String coTravellers = String.join(", ", answers.getCoTraveller());

        message += "I travel " + coTravellers + ". ";
        message += "I live in " + answers.getLivingCity() + " and I am in " ;
        if (answers.isDisability()) {
            message += "I have a mobility disability. ";
        } else {
            message += "I am in good shape. ";
        }
        message += "I want to travel for " + answers.getTravelDuration() + " . ";
        message += "I want to travel with " + answers.getMeansOfTravel() + " . ";


        // Check if there are any activities
        if (!answers.getActivity().isEmpty()) {
            String activities = String.join(", ", answers.getActivity());
            message += "I love " + activities + ". ";
        }

        message += "I want to travel in " + answers.getSeason() + " and my purpose is to " +
                answers.getTravelPurpose().get(0) + ". ";

        if (answers.getPreferredDestination() != null){
            message += "I want to go to " + answers.getPreferredDestination();
            message += ". please make me two different itineraries based on the infos i gave you.";
        } else {
            message += "I have no preferred destination ";
            if (answers.destinationContinent()!= null){
                message += "but i prefer to go to "+answers.destinationContinent();
                message += ". please suggest me two different destinations and make one itinerary for each based on the infos i gave you.";
            }
        }
/*        message += "\n please give me your response in the following format:" +
                "\n ";*/
        return message;
    }
}
