package net.kemitix.fontface;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class FontCache {

    private static final Logger LOGGER =
            Logger.getLogger(
                    FontCache.class.getName());

    private final Map<URI, Font> fileCache = new HashMap<>();

    private final Map<FontAndSize, Font> fontCache = new HashMap<>();

    private final FontLoader fontLoader;

    public Font loadFont(final FontFace fontFace) {
        LOGGER.finest(String.format("Requesting %s %d",
                fontFace.getFontLocation(), fontFace.getSize()));
        final Font baseFont =
                fileCache.computeIfAbsent(
                        fontFace.getFontLocation(),
                        loadNewFontFile(fontFace));
        return fontCache.computeIfAbsent(
                FontAndSize.of(baseFont, fontFace.getSize()),
                resizeFont());
    }

    private Function<URI, Font> loadNewFontFile(
            final FontFace fontFace
    ) {
        return uri -> {
            LOGGER.fine(String.format("Loading %s", uri));
            return fontLoader.loadFont(fontFace);
        };
    }


    private Function<FontAndSize, Font> resizeFont() {
        return fontAndSize -> {
            LOGGER.finer(String.format("Resizing %s to %d",
                    fontAndSize.getFont().getName(), fontAndSize.getSize()));
            return fontAndSize.font
                    .deriveFont(Font.PLAIN, fontAndSize.getSize());
        };
    }

    @Getter
    @EqualsAndHashCode
    private static class FontAndSize {
        private final Font font;
        private final int size;

        private FontAndSize(final Font font, final int size) {
            this.font = font;
            this.size = size;
        }

        static FontAndSize of(final Font font, final int size) {
            return new FontAndSize(font, size);
        }
    }
}
