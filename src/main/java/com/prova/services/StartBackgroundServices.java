package com.prova.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartBackgroundServices implements CommandLineRunner{

	
	public StartBackgroundServices() {}

	@Override
	public void run(String... args) throws Exception 
	{
		
		MqttConnector mqttConnector = new MqttConnector();
		mqttConnector.connectToServer();
		
	}
	
	
}
