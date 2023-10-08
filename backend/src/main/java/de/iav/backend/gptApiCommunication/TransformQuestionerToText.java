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

        // Check if there are any activities
        if (!answers.getActivity().isEmpty()) {
            String activities = String.join(", ", answers.getActivity());
            message += "I love " + activities + ". ";
        }

        message += "I want to travel in " + answers.getSeason() + " and my purpose is to " +
                answers.getTravelPurpose().get(0) + ". ";

        if (answers.getPreferredDestination() != null){
            message += "I want to go to " + answers.getPreferredDestination();
        } else {
            message += "I have no preferred destination ";
            if (answers.destinationContinent()!= null){
                message += "but i prefer to go to "+answers.destinationContinent();
            }
        }

        return message;
    }
}
