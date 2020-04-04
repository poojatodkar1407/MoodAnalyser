package com.bridgelabz.junit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyser(String message) {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.junit.MoodAnalyser").getConstructor(String.class);
            Object moodAnalyserObject = constructor.newInstance(message);
            return (MoodAnalyser)moodAnalyserObject;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
