package olepossu.webhook.content.objects;

import olepossu.webhook.content.contents.KeyListContent;
import olepossu.webhook.content.contents.StringContent;

public class AuthorObject extends KeyListContent {
    private AuthorObject() {
        super("author");
    }

    public static AuthorObject name(String name) {
        AuthorObject content = new AuthorObject();
        content.append(StringContent.of("name", name));
        return content;
    }

    public static AuthorObject nameUrl(String name, String url) {
        AuthorObject content = new AuthorObject();
        content.append(StringContent.of("name", name));
        content.append(StringContent.of("url", url));
        return content;
    }

    public static AuthorObject nameIcon(String name, String iconUrl) {
        AuthorObject content = new AuthorObject();
        content.append(StringContent.of("name", name));
        content.append(StringContent.of("icon_url", iconUrl));
        return content;
    }

    public static AuthorObject of(String name, String url, String iconUrl) {
        AuthorObject content = new AuthorObject();
        content.append(StringContent.of("name", name));
        content.append(StringContent.of("url", url));
        content.append(StringContent.of("icon_url", iconUrl));
        return content;
    }
}
