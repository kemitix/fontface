package net.kemitix.fontface;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class FontLoader {

    private static final Logger LOGGER =
            Logger.getLogger(
                    FontLoader.class.getName());

    public Font loadFont(final FontFace fontFace) {
        URI fontUri = fontFace.getFontLocation();
        LOGGER.info(String.format("Loading %s", fontUri));
        final Map<TextAttribute, Object> map = new HashMap<>();
        //map.put(TextAttribute.LIGATURES, TextAttribute.LIGATURES_ON);
        map.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(fontUri))
                    .deriveFont(map);
        } catch (final FontFormatException | IOException e) {
            throw new FatalFontFaceError("Font load error", e);
        }
    }

}
