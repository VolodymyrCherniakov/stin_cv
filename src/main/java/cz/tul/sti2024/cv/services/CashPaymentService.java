package cz.tul.sti2024.cv.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.tul.sti2024.cv.models.Payment;
import org.springframework.stereotype.Component;

@Component
public class CashPaymentService implements IPaymentService {

    private final PaymentServiceProcessing paymentServiceProcessing;
    private final PaymentTransformations paymentTransformations;

    public CashPaymentService(PaymentServiceProcessing paymentServiceProcessing, PaymentTransformations paymentTransformations) {
        this.paymentServiceProcessing = paymentServiceProcessing;
        this.paymentTransformations = paymentTransformations;
    }

    @Override
    public void processPayment(Payment payment) {
        String toPay = payment.getAmount() + "/" + payment.getCurrency();
        paymentServiceProcessing.pay(toPay);
    }
}
