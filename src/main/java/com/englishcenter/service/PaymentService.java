package com.englishcenter.service;
import java.util.Map;

public interface PaymentService {
    Map<String, Object> createMomoPayment(String amount, String orderInfo);
}
