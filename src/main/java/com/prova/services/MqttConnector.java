package com.prova.services;

import org.springframework.stereotype.Component;

@Component
public class MqttConnector {

	
	public MqttConnector() {}
	
		
	public void connectToServer() 
	{
		System.out.println("########################### CONNESSIONE A MQTT #############################");
	}
}
