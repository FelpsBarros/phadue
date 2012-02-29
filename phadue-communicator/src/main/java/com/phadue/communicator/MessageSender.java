package com.phadue.communicator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * User: Filipe
 * Date: 21/02/12
 */
public class MessageSender {

    /**
     * @param message The <code>message</code> to be send
     * @return The response message from the Socket
     */
    public String send(final String message) throws IOException {
        // TODO: Deal with Exceptions
        // TODO: Change ip number to a configuration file
        // TODO: Create a class to hold socket connection
        // TODO: Log
        // TODO: Validate parameters

        final Socket socket = new Socket("192.168.0.99", 1802);

        final OutputStream outputStream = socket.getOutputStream();
        final InputStream inputStream = socket.getInputStream();
        final Scanner scanner = new Scanner(inputStream);

        try {

            outputStream.write(message.getBytes());

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            return "";

        } finally {
            scanner.close();
            inputStream.close();
            outputStream.close();
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final MessageSender messageSender = new MessageSender();

        while (!Thread.interrupted()) {
            messageSender.send(scanner.next());
        }
    }

}
