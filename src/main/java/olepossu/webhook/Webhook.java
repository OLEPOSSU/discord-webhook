package olepossu.webhook;

import olepossu.webhook.content.objects.WebhookMessage;
import olepossu.webhook.content.objects.AttachmentObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Webhook {
    private final URI uri;

    public Webhook(URI uri) {
        this.uri = uri;
    }

    public Webhook(String uri) {
        this(URI.create(uri));
    }

    public boolean send(WebhookMessage message) {
        return send(message, HttpResponse.BodyHandlers.ofString()).statusCode() == 200;
    }

    public <T> HttpResponse<T> send(WebhookMessage message, HttpResponse.BodyHandler<T> bodyHandler) {
        String boundary = "--LuhBoundary--";
        String newLine = "\r\n";

        StringBuilder builder = new StringBuilder();
        builder.append("--").append(boundary).append(newLine);
        builder.append("Content-Disposition: form-data; name=\"payload_json\"").append(newLine);
        builder.append("Content-Type: application/json").append(newLine).append(newLine);
        builder.append(message.toString()).append(newLine);

        builder.append("--").append(boundary);

        List<AttachmentObject> attachments = message.getAttachments();
        for (int i = 0; i < attachments.size(); i++) {
            AttachmentObject attachment = attachments.get(i);
            builder.append(newLine).append("Content-Disposition: form-data; name=\"files[").append(i).append("]\"; ");
            builder.append("filename=\"").append(attachment.getName()).append("\"").append(newLine);
            builder.append("Content-Type: octet-stream").append(newLine).append(newLine);
            builder.append(attachment);
            builder.append(newLine).append("--").append(boundary);
        }

        builder.append("--");

        HttpRequest request = HttpRequest.newBuilder()
            .uri(uri)
            .header("Content-Type", "multipart/form-data; boundary=" + boundary)
            .POST(HttpRequest.BodyPublishers.ofByteArray(builder.toString().getBytes(StandardCharsets.ISO_8859_1)))
            .build();

        return sendHttp(request, bodyHandler);
    }

    private <T> HttpResponse<T> sendHttp(HttpRequest request, HttpResponse.BodyHandler<T> bodyHandler) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            return client.send(request, bodyHandler);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
