package com.englishcenter.controller;

import com.englishcenter.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/momo")
    public Map<String, Object> createMomoPayment(
            @RequestParam String amount,
            @RequestParam String orderInfo
    ) {
        return paymentService.createMomoPayment(amount, orderInfo);
    }

    // (Tùy chọn) IPN callback từ MoMo
    @PostMapping("/momo/ipn")
    public String momoIpn(@RequestBody Map<String, Object> payload) {
        System.out.println("📩 IPN MoMo: " + payload);
        return "IPN nhận thành công";
    }
}
