package ru.kata.pp_3_1_5_restapi;

public class Main {
    public static void main(String[] args) {
        RestApiClient client = new RestApiClient();
        System.out.println(client.getDataFromUrl());
    }
}
