package olepossu.webhook.content.objects;

import olepossu.webhook.content.contents.BooleanContent;
import olepossu.webhook.content.contents.ListContent;
import olepossu.webhook.content.contents.StringContent;

public final class FieldObject extends ListContent {
    private FieldObject() {

    }

    public static FieldObject nameValue(String name, String value) {
        FieldObject content = new FieldObject();
        content.append(StringContent.of("name", name));
        content.append(StringContent.of("value", value));
        return content;
    }

    public static FieldObject of(String name, String value, boolean inline) {
        FieldObject content = new FieldObject();
        content.append(StringContent.of("name", name));
        content.append(StringContent.of("value", value));
        content.append(BooleanContent.of("inline", inline));
        return content;
    }
}
