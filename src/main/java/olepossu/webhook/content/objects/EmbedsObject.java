package olepossu.webhook.content.objects;

import olepossu.webhook.content.contents.KeyArrayContent;

import java.util.function.Consumer;

public class EmbedsObject extends KeyArrayContent {
    private EmbedsObject() {
        super("embeds");
    }

    public void add(Consumer<EmbedObject> consumer) {
        consumer.accept(EmbedObject.empty(this));
    }

    public static EmbedsObject empty() {
        return new EmbedsObject();
    }

    public static EmbedsObject empty(WebhookMessage message) {
        EmbedsObject embeds = empty();
        message.embeds(embeds);
        return embeds;
    }
}
