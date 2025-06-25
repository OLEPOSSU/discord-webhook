package olepossu.webhook.content.contents;

import olepossu.webhook.content.AbstractListContent;

public class KeyListContent extends AbstractListContent {
    public KeyListContent(String key) {
        super("\"" + key + "\": {", "}");
    }
}
