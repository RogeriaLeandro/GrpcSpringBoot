package com.example.grpc.client.grpcsclient.service;

import org.springframework.stereotype.Service;

import com.example.grpc.client.grpcclient.protobuf.grpcjava.com.example.grpc.client.grpcclient.PingPongServiceGrpc;
import com.example.grpc.client.grpcclient.protobuf.java.com.example.grpc.client.grpcclient.PingRequest;
import com.example.grpc.client.grpcclient.protobuf.java.com.example.grpc.client.grpcclient.PongResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class GRPCClientService {

	public String ping() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8088)
				.usePlaintext()
				.build();
		
		PingPongServiceGrpc.PingPongServiceBlockingStub stub = PingPongServiceGrpc.newBlockingStub(channel);
		
		PongResponse helloResponse = stub.ping(PingRequest.newBuilder()
				.setPing("")
				.build());
		
		channel.shutdown();
		
		return helloResponse.getPong();
	}
	
}
