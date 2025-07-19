package com.allura.currencyconverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Se definió ConversionRecord como una clase «Record».
public record ConversionRecord(
        String baseCurrency,
        String targetCurrency,
        double amount,
        double convertedAmount,
        double rate,
        LocalDateTime timestamp
) {

    // Llama al constructor canónico (generado por el record) y le pasa el LocalDateTime.now().
    public ConversionRecord(String baseCurrency, String targetCurrency, double amount, double convertedAmount, double rate) {
        this(baseCurrency, targetCurrency, amount, convertedAmount, rate, LocalDateTime.now());
    }

    // Sobreescribe toString() para un formato más legible para el historial.
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = timestamp.format(formatter);

        return String.format("[%s] %.2f %s equivale a %.2f %s (Tasa: %.4f)",
                formattedTimestamp, amount, baseCurrency, convertedAmount, targetCurrency, rate);
    }
}
