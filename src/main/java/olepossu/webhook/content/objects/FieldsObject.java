package olepossu.webhook.content.objects;

import olepossu.webhook.content.contents.KeyArrayContent;

public class FieldsObject extends KeyArrayContent {
    private FieldsObject() {
        super("fields");
    }

    public static FieldsObject empty() {
        return new FieldsObject();
    }

    public static FieldsObject empty(EmbedObject embed) {
        FieldsObject fields = empty();
        embed.fields(fields);
        return fields;
    }
}
