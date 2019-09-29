package com.freesoft.marsrovers.infrastructure.socket;

import com.freesoft.marsrovers.application.InitializationService;
import com.freesoft.marsrovers.application.RoverManager;
import com.freesoft.marsrovers.application.InputParser;
import com.freesoft.marsrovers.application.OutputBuilder;
import com.freesoft.marsrovers.application.exception.InvalidInputException;
import com.freesoft.marsrovers.domain.RoverMap;
import com.freesoft.marsrovers.domain.Plateau;
import com.freesoft.marsrovers.domain.Rover;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public final class SocketListener implements Runnable {

    private final Socket socket;

    private SocketListener(Socket socket) {
        this.socket = socket;
    }

    public static SocketListener aListener(Socket socket) {
        return new SocketListener(socket);
    }

    @Override
    public void run() {
        System.out.println("Connected: " + socket);
        try {
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (in.hasNextLine()) {
                try {
                    String inputLine = in.nextLine();
                    System.out.println("Received input: " + inputLine);
                    String result = InitializationService.INSTANCE.execute.apply(inputLine);
                    out.println(result);
                } catch (InvalidInputException validationEx) {
                    out.println("The received input is invalid! The reason is: " + validationEx.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + socket);
        } finally {
            try {
                socket.close();
            } catch (IOException ioEx) {
            }
            System.out.println("Closed: " + socket);
        }
    }
}
