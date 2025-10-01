package com.designpatterns.creational.singleton;

/**
 * Another service demonstrating the same Logger instance
 * Follows Dependency Inversion Principle
 */
public class PaymentService {
    private Logger logger;
    private static final double LARGE_TRANSACTION_THRESHOLD = 10000.0;
    
    public PaymentService() {
        this.logger = Logger.getInstance();
    }
    
    public void processPayment(double amount) {
        logger.info("PaymentService: Processing payment of $" + amount);
        
        if (amount <= 0) {
            logger.error("PaymentService: Payment failed - Invalid amount: $" + amount);
            throw new IllegalArgumentException("Payment amount must be positive");
        }
        
        if (amount > LARGE_TRANSACTION_THRESHOLD) {
            logger.warning("PaymentService: Large transaction detected - $" + amount);
        }
        
        // Simulate payment processing
        logger.info("PaymentService: Payment processed successfully - $" + amount);
    }
    
    public void refundPayment(double amount, String reason) {
        logger.info("PaymentService: Processing refund of $" + amount);
        logger.debug("PaymentService: Refund reason - " + reason);
        
        if (amount <= 0) {
            logger.error("PaymentService: Refund failed - Invalid amount: $" + amount);
            throw new IllegalArgumentException("Refund amount must be positive");
        }
        
        logger.info("PaymentService: Refund processed successfully - $" + amount);
    }
}