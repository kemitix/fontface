package net.kemitix.fontface;

import net.kemitix.fontface.FontFace;

import java.awt.*;

public interface FontCache {
    Font loadFont(FontFace fontFace);
}
