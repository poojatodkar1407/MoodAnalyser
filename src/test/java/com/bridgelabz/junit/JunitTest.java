package com.bridgelabz.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JunitTest {

    @Test
    public void moodTest() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am SAD mood");
        String message = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",message);
    }

    @Test
    public void happyMoodTest() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("Im in HAPPY mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNullMood_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = null;
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Enter Proper mood",e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnHappy() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridgelabz.junit.MoodAnalyser").getConstructor(String.class);
            Object mood = constructor.newInstance("I am in HAPPY Mood");
            MoodAnalyser moodAnalyser = (MoodAnalyser) mood;
            String analyseMood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",analyseMood);
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
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in HAPPY mood");
        Assert.assertEquals(new MoodAnalyser("I am in HAPPY mood"),moodAnalyser);
    }


}

















