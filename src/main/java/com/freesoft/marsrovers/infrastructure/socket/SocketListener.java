package com.freesoft.marsrovers.infrastructure.socket;

import com.freesoft.marsrovers.application.RoverManager;
import com.freesoft.marsrovers.application.RoverMap;
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
                    SocketInputParser inputParser = SocketInputParser.INSTANCE;
                    List<String> inputComponents = inputParser.splitInput(inputLine);
                    Plateau plateau = inputParser.createPlateau(inputComponents.get(0), inputComponents.get(1));
                    List<Rover> rovers = inputParser.createRovers(inputComponents.subList(3, inputComponents.size() + 1));
                    rovers.forEach(RoverMap.INSTANCE::addRover);
                    RoverManager.INSTANCE.init(plateau, RoverMap.INSTANCE);
                } catch (RuntimeException validationEx) {

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
