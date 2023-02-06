package com.fci.advanced.se.personsmanagement.PaymentFactroy_Controller;

import com.fci.advanced.se.personsmanagement.PaymentMethod_Package.Payment;
import com.fci.advanced.se.personsmanagement.PaymentMethod_Package.PaymentMethod;

import java.util.List;

public interface PaymentFactory {
    Payment createPaymentMethod(List<String> paymentData);
}
