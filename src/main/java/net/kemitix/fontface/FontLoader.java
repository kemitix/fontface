package net.kemitix.fontface;

import net.kemitix.fontface.FontFace;

import java.awt.*;

public interface FontLoader {
    Font loadFont(FontFace fontFace);
}
