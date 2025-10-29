package com.englishcenter.service;

import com.englishcenter.config.MomoConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class MomoService {

    private final MomoConfig momo;
    private final ObjectMapper mapper = new ObjectMapper();

    public MomoService(MomoConfig momo) {
        this.momo = momo;
    }

    public Map<String, Object> createPayment(String orderId, String orderInfo, long amount) throws Exception {
        String requestId = UUID.randomUUID().toString();

        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("partnerCode", momo.partnerCode);
        payload.put("accessKey", momo.accessKey);
        payload.put("requestId", requestId);
        payload.put("amount", String.valueOf(amount));
        payload.put("orderId", orderId);
        payload.put("orderInfo", orderInfo);
        payload.put("redirectUrl", momo.redirectUrl);
        payload.put("ipnUrl", momo.ipnUrl);
        payload.put("requestType", "captureWallet");
        payload.put("extraData", "");

        // ✅ Tạo chữ ký HMAC SHA256 theo tài liệu MoMo
        String rawSignature = "accessKey=" + momo.accessKey +
                "&amount=" + amount +
                "&extraData=" +
                "&ipnUrl=" + momo.ipnUrl +
                "&orderId=" + orderId +
                "&orderInfo=" + orderInfo +
                "&partnerCode=" + momo.partnerCode +
                "&redirectUrl=" + momo.redirectUrl +
                "&requestId=" + requestId +
                "&requestType=captureWallet";

        String signature = hmacSHA256(rawSignature, momo.secretKey);
        payload.put("signature", signature);

        // ✅ Gửi request POST đến endpoint của MoMo
        java.net.URI uri = java.net.URI.create(momo.endpoint);
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = mapper.writeValueAsBytes(payload);
            os.write(input, 0, input.length);
        }

        // ✅ Đọc phản hồi JSON từ MoMo, chuyển sang Map<String, Object> an toàn kiểu dữ liệu
        Map<String, Object> response = mapper.readValue(
                conn.getInputStream(),
                new TypeReference<Map<String, Object>>() {}
        );

        conn.disconnect();
        return response;
    }

    // 🔒 Hàm tạo chữ ký HMAC SHA256
    private String hmacSHA256(String data, String secretKey) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] hash = sha256_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hash);
    }

    // 🔄 Chuyển byte[] sang chuỗi hex
    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) sb.append(String.format("%02x", b));
        return sb.toString();
    }
}
