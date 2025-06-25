package olepossu.webhook.content.objects;

import olepossu.webhook.content.contents.KeyListContent;
import olepossu.webhook.content.contents.StringContent;

public class FooterObject extends KeyListContent {
    private FooterObject() {
        super("footer");
    }

    public static FooterObject text(String text) {
        FooterObject content = new FooterObject();
        content.append(StringContent.of("text", text));
        return content;
    }

    public static FooterObject of(String text, String iconUrl) {
        FooterObject content = new FooterObject();
        content.append(StringContent.of("text", text));
        content.append(StringContent.of("icon_url", iconUrl));
        return content;
    }
}
