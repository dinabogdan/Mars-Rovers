package com.freesoft.marsrovers;

import com.freesoft.marsrovers.infrastructure.socket.SocketListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws IOException {
        try (ServerSocket listener = new ServerSocket(9091)) {
            System.out.println("The MarsRover server is running ...");
            ExecutorService executorService = Executors.newFixedThreadPool(20);
            while (true) {
                executorService.execute(SocketListener.aListener(listener.accept()));
            }
        }
    }
}
