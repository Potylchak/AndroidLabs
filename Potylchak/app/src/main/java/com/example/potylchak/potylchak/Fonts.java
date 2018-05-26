package com.example.potylchak.potylchak;

import android.content.Context;
import android.graphics.Typeface;

public class Fonts {
    public static Typeface tf = Typeface.SANS_SERIF;

    public static Typeface getTypefaceByString(String font, Context context) {
        Typeface tf;
        switch (font) {
            case "Inspiration":
                tf = Typeface.createFromAsset(context.getAssets(), "fonts/Inspiration.ttf");
                break;
            case "ApolloniaModern":
                tf = Typeface.createFromAsset(context.getAssets(), "fonts/ApolloniaModern.ttf");
                break;
            case "PehleviRegular":
                tf = Typeface.createFromAsset(context.getAssets(), "fonts/PehleviRegular.ttf");
                break;
            case "def":
                tf = Typeface.SANS_SERIF;
                break;
            default:
                tf = Typeface.SANS_SERIF;
        }
        return tf;
    }
}
