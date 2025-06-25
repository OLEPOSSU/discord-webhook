package olepossu.webhook.content.objects;

import olepossu.webhook.content.AbstractContent;
import olepossu.webhook.content.contents.ListContent;
import olepossu.webhook.content.contents.StringContent;
import olepossu.webhook.content.contents.BooleanContent;

import java.util.ArrayList;
import java.util.List;

public class WebhookMessage extends ListContent {
    private final List<AttachmentObject> attachments = new ArrayList<>();

    private WebhookMessage() {

    }

    @Override
    public WebhookMessage append(AbstractContent content) {
        if (content instanceof AttachmentObject) attachments.add((AttachmentObject) content);
        else super.append(content);
        return this;
    }

    @Override
    public WebhookMessage clone() {
        WebhookMessage message = new WebhookMessage();
        message.contents.addAll(contents);
        message.attachments.addAll(attachments);
        return message;
    }

    public void addAttachment(AttachmentObject attachment) {
        attachments.add(attachment);
    }

    public List<AttachmentObject> getAttachments() {
        return attachments;
    }

    public boolean isEmpty() {
        return contents.isEmpty();
    }

    public WebhookMessage content(String content) {
        append(StringContent.of("content", content));
        return this;
    }

    public WebhookMessage username(String username) {
        append(StringContent.of("username", username));
        return this;
    }

    public WebhookMessage avatarUrl(String avatarUrl) {
        append(StringContent.of("avatar_url", avatarUrl));
        return this;
    }

    public WebhookMessage tts(boolean tts) {
        append(BooleanContent.of("tts", tts));
        return this;
    }

    public WebhookMessage embeds(EmbedsObject embeds) {
        append(embeds);
        return this;
    }

    public static WebhookMessage empty() {
        return new WebhookMessage();
    }
}
