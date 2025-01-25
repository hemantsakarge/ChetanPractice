package com.cjc.main.crud.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.cjc.main.crud.model.RedBus;
import com.cjc.main.crud.servic.RedBusService;

@RestController
public class RedBusController {

	@Autowired
	RedBusService rb;
	
	@Autowired
	private RestTemplate rt;
	
	
	@GetMapping("/getallbuses")
	public List<RedBus> findALLBuses()
	{
		String url="http://localhost:9090/findallpurplebuses";
		List<RedBus> itr=rt.getForObject(url, List.class);
		
		String url1="http://localhost:9091/findallakasa";
		List<RedBus> itr1=rt.getForObject(url1, List.class);
		
		List<List<RedBus>> list=new ArrayList();
		
		list.add(itr);
		list.add(itr1);
		for (List<RedBus> pb : list) {
			for (RedBus list2 : pb) {
				Comparator<RedBus>cr=(o1, o2) ->(int)(o1.getBusPrice()-o2.getBusPrice()); 
				List<RedBus> l=new ArrayList<RedBus>();
				l.add(list2);
				l.sort(cr);
				return l;
			}
			
		}
		return itr1;
		
	}
	
	
	@GetMapping("/getallbusesredbussortingprice")
	public List<RedBus> findAllBusesSortingPrice()
	{
			
			String url="http://localhost:9090/findallpurplebussortingprice";
			List<RedBus> itr=rt.getForObject(url,List.class);
			
			String url1="http://localhost:9091/findallakasabussortingprice";
			List<RedBus> itr1=rt.getForObject(url1, List.class);
			
			List<RedBus> list=new LinkedList<RedBus>();
			list.addAll(itr);
			list.addAll(itr1);
		
//			for (RedBus pb : list) {
//				Comparator<RedBus>cr=(o1, o2) ->(int)(o1.getBusPrice()-o2.getBusPrice()); 
//				list.sort(cr);
//				return list;
//			}
			return list;

			
				
				
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			
//			return list.stream()
//		               .map(innerList -> innerList.stream()
//		                                          .sorted(Comparator.comparingDouble(RedBus::getBusPrice).reversed())
//		                                          .collect(Collectors.toList()))
//		               .collect(Collectors.toList());
//			
//			//list.stream().forEach(a -> a.stream().sorted().collect(Collectors.toList()));
//		//	list.stream().forEach(a -> a.stream().sorted((o1,o2)-> (int)o1.getBusPrice() - (int)o2.getBusPrice()).collect(Collectors.toList()));
//			//return list;
//			
//			List<List<RedBus>> sortprice = new ArrayList<>();
//			for(List<RedBus> newlist: list)
//			{
//				//System.out.println(newlist);
//				List<RedBus> collect = newlist.stream().sorted((o1,o2)->(int)o2.getBusId()- (int)o1.getBusId()).collect(Collectors.toList());
//			
//				//RedBus rb=newlist.iterator();
//				sortprice.add(collect);
//				System.out.println(collect);
//			}
//			return sortprice;
	}
	
	
	@PostMapping("/saveredbustetailspurple")
	public String saveDetaispurple(@RequestBody RedBus r)
	{
		rb.savedetails(r);
		
		String url="http://localhost:9090/savebuspurple";
		String msg=rt.postForObject(url,r, String.class);
		return msg;
	}
	
	@PostMapping("/saveredbustetailsakasa")
	public String saveDetaisakasaS(@RequestBody RedBus r)
	{
		rb.savedetails(r);
		
		String url="http://localhost:9091/savepaasengerdetailsakasa";
		String msg1=rt.postForObject(url,r, String.class);
		return msg1;
	}

	
}
