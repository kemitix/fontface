package net.kemitix.fontface;

import lombok.*;

import java.net.URI;

@Getter
@With
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class FontFaceImpl implements FontFace {

    private URI fontLocation;
    private int size;
    private String colour;
    private String shadowColour;
    private int shadowOffsetX;
    private int shadowOffsetY;

    static String shadowColour(final String colour) {
        switch (colour) {
            case "white":
            case "yellow":
                return "black";
            default:
                return "white";
        }
    }

}
