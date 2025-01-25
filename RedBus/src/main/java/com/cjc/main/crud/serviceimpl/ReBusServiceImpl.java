package com.cjc.main.crud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.crud.model.RedBus;
import com.cjc.main.crud.repository.RedBusRepository;
import com.cjc.main.crud.servic.RedBusService;

@Service
public class ReBusServiceImpl implements RedBusService{

	@Autowired
	private RedBusRepository rb;
	
	
	@Override
	public Iterable findAllBuses() {
		// TODO Auto-generated method stub
		return rb.findAll();
	}


	@Override
	public void savedetails(RedBus r) {
		rb.save(r);
	}


	

}
