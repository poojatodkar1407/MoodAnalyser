package com.bridgelabz.junit;

import java.util.Objects;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood(String message) throws MoodAnalyserException {
        this.message = message;
        return analyseMood();
    }

    public String analyseMood() throws MoodAnalyserException {
        try {
            if (message.contains("HAPPY"))
                return "HAPPY";
            return "SAD";
        }catch (NullPointerException e){
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"Enter Proper mood");
        }
    }

    @Override
    public boolean equals(Object anotherObject) {
       if(this.message.equals(((MoodAnalyser)anotherObject).message))
           return true;
       return false;
    }

}
