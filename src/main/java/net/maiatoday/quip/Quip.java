package net.maiatoday.quip;

import android.support.annotation.ArrayRes;
import android.support.annotation.IntDef;

import java.util.Random;

/**
 * Fake data
 * Created by maia on 2016/07/30.
 */
public class Quip {

    private static final String[] ADJECTIVES = {"damp", "luminescent", "vaulted", "dusty", "warm", "humid", "dry", "slippery", "crepuscular", "shadowy", "magical"};
    private static final String[] CAVE_NAME = {"cave", "cavern", "grotto", "hollow", "chamber", "den", "crypt", "cistern"};
    private static final String[] PASSAGE_NAME = {"tunnel", "chimney", "passage", "channel", "hole", "mine", "pit", "shaft", "subway", "burrow", "tube", "crawlspace"};

    private static Random dice = new Random();

    public static String getCave() {
        return ADJECTIVES[dice.nextInt(ADJECTIVES.length)] + " " + CAVE_NAME[dice.nextInt(CAVE_NAME.length)];
    }

    public static String getPassage() {
        return ADJECTIVES[dice.nextInt(ADJECTIVES.length)] + " " + PASSAGE_NAME[dice.nextInt(PASSAGE_NAME.length)];
    }

    String[] quips;

    boolean random = true;
    int i = 0;

    public Quip(String[] quips) {
        this.quips = quips;
    }

    public Quip(String[] quips, boolean random) {
        this.quips = quips;
        this.random = random;
    }

    public String blurt() {
        if (random) {
            return quips[dice.nextInt(quips.length)];
        } else {
            int next = i;
            if (i == quips.length - 1) {
                i = 0;
            } else {
                i++;
            }
            return quips[next];
        }
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public boolean isRandom() {
        return random;
    }
}
