package com.credmarg.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.data.model.EmailDt;
import com.credmarg.data.model.Vendor;
import com.credmarg.data.service.EmailService;
import com.credmarg.data.service.VendorService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
//@RequestMapping("/api/vendors")
public class VendorController
{
	@Autowired
	private EmailService emailService;

	 @Autowired
	    private VendorService vendorService;

	    @PostMapping("/saveVendor")
	    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
	        Vendor savedVendor = vendorService.saveVendor(vendor);
	        return ResponseEntity.ok(savedVendor);
	    }

	    @GetMapping("/getVendors")
	    public ResponseEntity<List<Vendor>> getAllVendors() {
	        return ResponseEntity.ok(vendorService.getAllVendors());
	    }
	    
	    @PostMapping("/sendEmails")
	    public ResponseEntity<Void> sendEmails(@RequestBody List<EmailDt> emails) {
	        emails.forEach(email -> emailService.sendEmail(email.getTo(), "Vendor Notification", email.getMessage()));
	        return ResponseEntity.ok().build();
	    }

}
