package com.hvs.lab.ecommerce.logistics.services.implementations;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
public class NotificationHandlerService {
    public void sendNotification(String message) throws IOException {
        Path path = Paths.get("./notifications.txt");
        Files.write(path, message.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.write(path, "\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
