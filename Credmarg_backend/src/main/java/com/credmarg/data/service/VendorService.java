package com.credmarg.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credmarg.data.model.Vendor;
import com.credmarg.data.repository.VendorRepository;

@Service
public class VendorService {
	 @Autowired
	    private VendorRepository vendorRepository;

	    public Vendor saveVendor(Vendor vendor) {
	        return vendorRepository.save(vendor);
	    }

	    public List<Vendor> getAllVendors() {
	        return vendorRepository.findAll();
	    }

}
