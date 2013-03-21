package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.domain.Address;

/**
 * 同样用于显示.
 * 
 * @author liukai
 * 
 */
@Service("addressService")
@Transactional
public class AddressService {

	protected static Logger logger = Logger.getLogger("service");

	/**
	 * 获得�?��的地�?
	 * 
	 * @return
	 */
	public List<Address> getAll() {
		logger.debug("Retrieving all addresses");

		List<Address> addresses = new ArrayList<Address>();

		// New address
		Address address = new Address();
		address.setId(1);
		address.setStreet("1 Street");
		address.setCity("City 1");
		address.setZipCode("11111");

		// Add to list
		addresses.add(address);

		// New address
		address = new Address();
		address.setId(2);
		address.setStreet("2 Street");
		address.setCity("City 2");
		address.setZipCode("22222");

		// Add to list
		addresses.add(address);

		// New address
		address = new Address();
		address.setId(3);
		address.setStreet("3 Street");
		address.setCity("City 3");
		address.setZipCode("33333");

		// Add to list
		addresses.add(address);

		// Return all addresses
		return addresses;
	}

}
