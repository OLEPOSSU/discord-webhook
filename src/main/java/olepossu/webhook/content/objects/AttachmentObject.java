package olepossu.webhook.content.objects;

import olepossu.webhook.content.AbstractContent;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class AttachmentObject extends AbstractContent {
    private final String name;
    private final byte[] data;

    private AttachmentObject(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }

    public static AttachmentObject of(String name, byte[] data) {
        return new AttachmentObject(name, data);
    }

    public static AttachmentObject of(String name, String content) {
        return of(name, content.getBytes(StandardCharsets.ISO_8859_1));
    }

    public static AttachmentObject of(File file) {
        return of(file.getName(), file);
    }

    public static AttachmentObject of(String name, File file) {
        try {
            return of(name, Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static AttachmentObject of(String name, InputStream stream) {
        try {
            return of(name, stream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new String(data, StandardCharsets.ISO_8859_1);
    }
}
