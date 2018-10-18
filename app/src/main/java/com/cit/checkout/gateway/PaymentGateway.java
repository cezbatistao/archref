package com.cit.checkout.gateway;

import com.cit.checkout.domain.Payment;
import com.cit.checkout.domain.PaymentStatus;

public interface PaymentGateway {

    PaymentStatus process(Payment payment, double total);

}
