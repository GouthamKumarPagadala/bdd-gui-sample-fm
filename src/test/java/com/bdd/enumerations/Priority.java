package com.bdd.enumerations;

import java.util.Arrays;
import java.util.Random;

public enum Priority {
    Normal,High,Urgent;
    public static String getRandomValue(){
        return Arrays.stream(Priority.values()).findAny().get().name();
    }
}
