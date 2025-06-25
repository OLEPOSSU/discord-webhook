package olepossu.webhook;

import olepossu.webhook.content.objects.*;

import java.awt.*;
import java.net.http.HttpResponse;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Test {
    private static final String URL = "nuh uh";

    public static void main(String[] args) {
        Webhook webhook = new Webhook(URL);

        WebhookMessage message = WebhookMessage.empty();
        EmbedsObject embeds = EmbedsObject.empty(message);

        message.content("Test message");

        embeds.add(embed -> {
            embed.title("Test title1");
            embed.description("Test description1");
            embed.image(ImageObject.of("https://bigrat.monster/media/bigrat.jpg"));
        });

        embeds.add(embed -> {
            embed.title("Test title2");
            embed.description("Test description2");
            embed.color(Color.RED);
            embed.footer(FooterObject.text("footer"));
            embed.author(AuthorObject.name("author"));
            embed.timestamp(getTimestamp());
        });

        message.addAttachment(AttachmentObject.of("testfile.txt", "testcontent"));

        HttpResponse<String> response = webhook.send(message, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    private static String getTimestamp() {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime time = ZonedDateTime.now(zoneId);

        return time.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
