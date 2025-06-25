package olepossu.webhook.content.objects;

import olepossu.webhook.content.contents.ListContent;
import olepossu.webhook.content.contents.StringContent;

import java.awt.*;

public class EmbedObject extends ListContent {
    private EmbedObject() {

    }
    
    public EmbedObject title(String title) {
        append(StringContent.of("title", title));
        return this;
    }

    public EmbedObject description(String description) {
        append(StringContent.of("description", description));
        return this;
    }

    public EmbedObject url(String url) {
        append(StringContent.of("url", url));
        return this;
    }

    public EmbedObject color(String color) {
        append(StringContent.of("color", String.valueOf(color)));
        return this;
    }

    public EmbedObject color(Color color) {
        return color(String.valueOf(
            ((color.getRed() & 0xFF) << 16) |
            ((color.getGreen() & 0xFF) << 8)  |
            ((color.getBlue() & 0xFF)))
        );
    }

    public EmbedObject timestamp(String timestamp) {
        append(StringContent.of("timestamp", timestamp));
        return this;
    }

    public EmbedObject footer(FooterObject footer) {
        append(footer);
        return this;
    }

    public EmbedObject image(ImageObject image) {
        append(image);
        return this;
    }

    public EmbedObject thumbnail(ThumbnailObject thumbnail) {
        append(thumbnail);
        return this;
    }

    public EmbedObject author(AuthorObject author) {
        append(author);
        return this;
    }

    public EmbedObject fields(FieldsObject fields) {
        append(fields);
        return this;
    }

    public static EmbedObject empty() {
        return new EmbedObject();
    }

    public static EmbedObject empty(EmbedsObject parent) {
        EmbedObject embed = empty();
        parent.append(embed);
        return embed;
    }
}
