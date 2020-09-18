package net.kemitix.fontface;

import java.net.URI;

public interface FontFace {
    static FontFace of(
            URI fontUri,
            int size,
            String colour,
            int shadowOffsetX,
            int shadowOffsetY
    ) {
        final String shadowColour = FontFaceImpl.shadowColour(colour);
        return new FontFaceImpl(fontUri, size, colour,
                shadowColour, shadowOffsetX, shadowOffsetY);
    }

    static FontFace of(
            URI fontUri,
            int size,
            String colour
    ) {
        return of(fontUri, size, colour, 0, 0);
    }

    URI getFontLocation();

    int getSize();

    String getColour();

    String getShadowColour();

    int getShadowOffsetX();

    int getShadowOffsetY();

    FontFace withSize(int size);
    FontFace withColour(String colour);
    FontFace withShadowColour(String colour);
    FontFace withShadowOffsetX(int offset);
    FontFace withShadowOffsetY(int offsetY);
}
