package olepossu.webhook.content.contents;

import olepossu.webhook.content.AbstractContent;

public class StringContent extends AbstractContent {
    private final String key;
    private final String content;

    private StringContent(String key, String content) {
        this.key = key;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("\"%s\": \"%s\"", key, content);
    }
    
    public static StringContent of(String key, String content) {
        return new StringContent(key, content);
    }
}
