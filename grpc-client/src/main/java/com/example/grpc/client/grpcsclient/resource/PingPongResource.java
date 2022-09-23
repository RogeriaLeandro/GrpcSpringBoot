package com.example.grpc.client.grpcsclient.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grpc.client.grpcsclient.service.GRPCClientService;

@RestController
public class PingPongResource {

	@Autowired
	GRPCClientService grpcClienteService;
	
	@Autowired
	public PingPongResource (GRPCClientService grpcClientService) {
		this.grpcClienteService = grpcClientService;
	}

	@GetMapping("/ping") 
	public String ping(){
		return grpcClienteService.ping();
		
	}
	
}
