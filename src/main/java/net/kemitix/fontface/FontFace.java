package net.kemitix.fontface;

import lombok.*;

import java.net.URI;

@Getter
@With
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class FontFace {

    private URI fontLocation;
    private int size;
    private String colour;
    private String shadowColour;
    private int shadowOffsetX;
    private int shadowOffsetY;

    public static FontFace of(
            URI fontUri,
            int size,
            String colour,
            String shadowColour,
            int shadowOffsetX,
            int shadowOffsetY
    ) {
        return new FontFace(fontUri, size, colour,
                shadowColour, shadowOffsetX, shadowOffsetY);
    }

    public static FontFace of(
            URI fontUri,
            int size,
            String colour,
            int shadowOffsetX,
            int shadowOffsetY
    ) {
        final String shadowColour = FontFace.shadowColour(colour);
        return new FontFace(fontUri, size, colour,
                shadowColour, shadowOffsetX, shadowOffsetY);
    }

    public static FontFace of(
            URI fontUri,
            int size,
            String colour
    ) {
        return of(fontUri, size, colour, 0, 0);
    }

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
