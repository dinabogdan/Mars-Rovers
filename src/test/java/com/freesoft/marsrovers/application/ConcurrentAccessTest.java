package com.freesoft.marsrovers.application;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class ConcurrentAccessTest {

    @Test
    public void GIVENTwoConcurrentRequestsWHENExecutingThemTHENReturnTheExpectedOutputForEachSequentially() throws ExecutionException, InterruptedException {
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(() -> InitializationService.INSTANCE.execute.apply("5 5 1 2 N LMLMLMLMM"));
        CompletableFuture<String> secondFuture = CompletableFuture.supplyAsync(() -> InitializationService.INSTANCE.execute.apply("5 5 3 3 E MMRMMRMRRM"));

        CompletableFuture.allOf(firstFuture, secondFuture).get();

        assertEquals("1 3 N ", firstFuture.get());
        assertEquals("5 1 E ", secondFuture.get());

    }
}
