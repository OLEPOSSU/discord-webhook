package olepossu.webhook.content.objects;

import olepossu.webhook.content.contents.KeyListContent;
import olepossu.webhook.content.contents.StringContent;

public class ImageObject extends KeyListContent {
    private ImageObject() {
        super("image");
    }

    public static ImageObject of(String url) {
        ImageObject content = new ImageObject();
        content.append(StringContent.of("url", url));
        return content;
    }
}
