package com.designpatterns.creational.singleton;

/**
 * Email service demonstrating Logger usage across different services
 */
public class EmailService {
    private Logger logger;
    
    public EmailService() {
        this.logger = Logger.getInstance();
    }
    
    public void sendEmail(String to, String subject, String body) {
        logger.info("EmailService: Sending email to " + to);
        logger.debug("EmailService: Subject - " + subject);
        
        if (to == null || !to.contains("@")) {
            logger.error("EmailService: Invalid email address - " + to);
            throw new IllegalArgumentException("Invalid email address");
        }
        
        if (subject == null || subject.trim().isEmpty()) {
            logger.warning("EmailService: Email has no subject");
        }
        
        // Simulate email sending
        logger.info("EmailService: Email sent successfully to " + to);
    }
}