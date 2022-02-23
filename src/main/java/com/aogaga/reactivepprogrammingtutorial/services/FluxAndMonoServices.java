package com.aogaga.reactivepprogrammingtutorial.services;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoServices {

  public Flux<String> fruitFlux(){
    return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
        .log();
  }

  public Mono<String> fruitMono(){
    return Mono.just("Mango")
        .log();
  }

  public Flux<String> fruitFluxMap(){
    return Flux.fromIterable(List.of("Mango", "Apple", "Banana"))
        .map(String::toUpperCase)
        .log();
  }

  public Flux<String> fruitFluxFilter(int number){
    return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
        .filter(s->s.length() > number)
        .log();
  }


  public Flux<String> fruitFluxFilterAndMap(int number){
    return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
        .filter(s->s.length() > number)
        .map(String::toUpperCase)
        .log();
  }


  public Flux<String> fruitFluxFlatMap(){
    return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
        .flatMap(s-> Flux.just(s.split("")))
        .log();
  }

  public Flux<String> fruitFluxFlatMapAsync(){
    return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
        .flatMap(s-> Flux.just(s.split("")))
        .delayElements(Duration.ofMillis(
            new Random().nextInt(100)
        ))
        .log();
  }


  public Mono<List<String>> fruitMonoFlatMap(){
    return Mono.just("Mango")
        .flatMap(s -> Mono.just(List.of(s.split(""))))
        .log();
  }

  public Flux<String> fruitsFluxConcatMap(){
    return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
        .concatMap(s -> Flux.just(s.split("")))
        .delayElements(Duration.ofMillis(
            new Random().nextInt(1000)
        ))
        .log();
  }
  public static void main(String [] args){
    FluxAndMonoServices fluxAndMonoServices =
        new FluxAndMonoServices();

    fluxAndMonoServices.fruitFlux()
        .subscribe(s->{
          System.out.println("s = " + s);
        });

    fluxAndMonoServices.fruitMono()
        .subscribe(s -> {
          System.out.println("Mono -> s" + s);
        });
  }



}
