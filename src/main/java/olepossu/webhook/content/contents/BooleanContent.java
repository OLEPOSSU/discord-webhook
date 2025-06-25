package olepossu.webhook.content.contents;

import olepossu.webhook.content.AbstractContent;

public class BooleanContent extends AbstractContent {
    private final String key;
    private final boolean content;

    private BooleanContent(String key, boolean content) {
        this.key = key;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("\"%s\": %s", key, content);
    }

    public static BooleanContent of(String key, boolean content) {
        return new BooleanContent(key, content);
    }
}
