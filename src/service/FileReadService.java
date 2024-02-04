package service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class FileReadService {
    public static String readData(Path path) {
        try (FileChannel channel = FileChannel.open(path)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            StringBuilder content = new StringBuilder();
            while (channel.read(byteBuffer) > 0 || byteBuffer.position() > 0) {
                byteBuffer.flip();
                content.append(new String(byteBuffer.array(), 0, byteBuffer.limit()));
                byteBuffer.clear();
            }
            return content.toString().trim();
        } catch (IOException e) {
            return "Exception: " + e.getMessage() + " not found";
        }
    }
}
