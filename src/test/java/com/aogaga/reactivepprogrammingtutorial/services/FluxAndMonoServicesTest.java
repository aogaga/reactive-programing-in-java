package com.aogaga.reactivepprogrammingtutorial.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoServicesTest {

  FluxAndMonoServices fluxAndMonoServices
      = new FluxAndMonoServices();
  @Test
  void fruitFlux() {
    var fruitFlux = fluxAndMonoServices.fruitFlux();

    StepVerifier.create(fruitFlux)
        .expectNext("Mango", "Orange", "Banana")
        .verifyComplete();
  }

  @Test
  void fruitMono() {
    var fruitMono = fluxAndMonoServices.fruitMono();

    StepVerifier.create(fruitMono)
        .expectNext("Mango")
        .verifyComplete();
  }

  @Test
  void fruitFluxMap() {
    var fruitFlux = fluxAndMonoServices.fruitFluxMap();
    StepVerifier.create(fruitFlux)
        .expectNext("MANGO", "APPLE", "BANANA")
        .verifyComplete();
  }

  @Test
  void fruitFluxFilter() {
    var fruitFlux = fluxAndMonoServices.fruitFluxFilter(5);

    StepVerifier.create(fruitFlux)
        .expectNext("Orange", "Banana")
        .verifyComplete();
  }

  @Test
  void fruitFluxFilterAndMap() {
    var fruitFlux = fluxAndMonoServices.fruitFluxFilterAndMap(5);

    StepVerifier.create(fruitFlux)
        .expectNext("ORANGE", "BANANA")
        .verifyComplete();
  }

  @Test
  void fruitFluxFlatMap() {
    var fruitFlux = fluxAndMonoServices.fruitFluxFlatMap();

    StepVerifier.create(fruitFlux)
        .expectNextCount(17)
        .verifyComplete();
  }

  @Test
  void fruitFluxFlatMapAsync() {
    var fruitFlux = fluxAndMonoServices.fruitFluxFlatMapAsync();

    StepVerifier.create(fruitFlux)
        .expectNextCount(17)
        .verifyComplete();
  }

  @Test
  void fruitMonoFlatMap() {
    var fruitFlux = fluxAndMonoServices.fruitMonoFlatMap();
    StepVerifier.create(fruitFlux)
        .expectNextCount(1)
        .verifyComplete();
  }

  @Test
  void fruitsFluxConcatMap() {
  }
}