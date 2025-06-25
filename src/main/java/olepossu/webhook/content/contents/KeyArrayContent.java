package olepossu.webhook.content.contents;

import olepossu.webhook.content.AbstractListContent;

public class KeyArrayContent extends AbstractListContent {
    public KeyArrayContent(String key) {
        super("\"" + key + "\": [", "]");
    }
}
