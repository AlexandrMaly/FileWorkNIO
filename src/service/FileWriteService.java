package service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriteService {

    public static String writeData(Path path, String content) {
        try (FileChannel channel = FileChannel.open(path,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE)) {
            byte[] contentBytes = content.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(contentBytes.length);
            byteBuffer.put(contentBytes);
            byteBuffer.flip();
            channel.write(byteBuffer);
        } catch (IOException e) {
            return "Exception: " + e.getMessage();
        }
        return "The content has been written.";
    }

}
