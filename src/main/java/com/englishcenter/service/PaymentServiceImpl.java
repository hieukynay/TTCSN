package com.englishcenter.service;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Map<String, Object> createMomoPayment(String amount, String orderInfo) {
        // Giả lập response từ MoMo
        return Map.of(
                "payUrl", "https://test-payment.momo.vn/pay/123456",
                "amount", amount,
                "orderInfo", orderInfo,
                "resultCode", 0,
                "message", "Tạo thanh toán thành công (giả lập)"
        );
    }
}
