package com.example.wiki;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HelloLombok {
    private String hello;
    private int lombok;

    public static void main(String[] args) {

        HelloLombok helloLombok = HelloLombok.builder()
                .hello("헬로")
                .lombok(5)
                .build();

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());

    }
}
