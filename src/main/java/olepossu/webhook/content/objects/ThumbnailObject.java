package olepossu.webhook.content.objects;

import olepossu.webhook.content.contents.KeyListContent;
import olepossu.webhook.content.contents.StringContent;

public class ThumbnailObject extends KeyListContent {
    private ThumbnailObject() {
        super("thumbnail");
    }

    public static ThumbnailObject of(String url) {
        ThumbnailObject content = new ThumbnailObject();
        content.append(StringContent.of("url", url));
        return content;
    }
}
