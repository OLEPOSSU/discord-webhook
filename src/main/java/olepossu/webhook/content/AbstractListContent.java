package olepossu.webhook.content;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListContent extends AbstractContent {
    protected final List<AbstractContent> contents = new ArrayList<>();

    private final String open;
    private final String close;

    protected AbstractListContent(String open, String close) {
        this.open = open;
        this.close = close;
    }

    public AbstractListContent append(AbstractContent content) {
        contents.add(content);
        return this;
    }

    @Override
    public final String toString() {
        if (contents.isEmpty()) return open + close;

        StringBuilder builder = new StringBuilder(String.valueOf(open));

        builder.append(contents.getFirst());

        for (int i = 1; i < contents.size(); i++) {
            AbstractContent content = contents.get(i);
            builder.append(",").append(content);
        }

        builder.append(close);

        return builder.toString();
    }
}
