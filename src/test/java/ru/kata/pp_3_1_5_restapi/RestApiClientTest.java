package ru.kata.pp_3_1_5_restapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RestApiClientTest {
    
    @Test
    void testGetDataFromUrl() {
        // 1. Создаем наш клиент
        RestApiClient client = new RestApiClient();
        
        // 2. Вызываем метод, который делает запросы
        String result = client.getDataFromUrl();
        
        // 3. Проверяем, что результат не пустой (сервер ответил)
        assertNotNull(result, "Результат не должен быть null");
        
        // 4. Проверяем, что длина итогового кода ровно 18 символов
        assertEquals(18, result.length(), "Длина итогового кода должна быть 18 символов");
        
        // 5. (Опционально) Выводим результат в консоль для наглядности
        System.out.println("Тест пройден! Код: " + result);
    }
}