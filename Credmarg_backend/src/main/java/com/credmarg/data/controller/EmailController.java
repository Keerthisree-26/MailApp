package com.credmarg.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.data.model.EmailRecord;
import com.credmarg.data.model.Vendor;
import com.credmarg.data.service.EmailService;
import com.credmarg.data.service.VendorService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private VendorService vendorService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmailToVendors(@RequestBody List<Vendor> vendorDetails) {
        for (Vendor vendor : vendorDetails) {
            String body = "Sending payments to vendor " + vendor.getName() + " at UPI " + vendor.getUpi();
            emailService.sendEmail(vendor.getEmail(), "Payment Notification", body);
        }
        return ResponseEntity.ok("Emails sent successfully.");
    }

    @GetMapping("/vendors")
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }
    @GetMapping("/email-records")
    public ResponseEntity<List<EmailRecord>> getAllEmailRecords() {
        return ResponseEntity.ok(emailService.getAllEmailRecords());
    }
}
