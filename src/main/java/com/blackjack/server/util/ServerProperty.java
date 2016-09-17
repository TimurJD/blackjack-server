package com.blackjack.server.util;

import java.util.Properties;

/**
 * @author Timur Berezhnoi
 */
public enum ServerProperty {

	PORT("server.port"),
	NAME("server.name");
	
	private String key;

    ServerProperty(String key) {
		this.key = key;
	}

	private static Properties properties;

	static {
		properties = new Properties();
		try {
			properties.load(ServerProperty.class.getClassLoader().getResourceAsStream("server.properties"));
		} catch (Exception e) {
			throw new RuntimeException("Error when loading configuration file", e);
		}
	}

	/**
	 * Call the <tt>Properties</tt> method {@code get}
	 * to get data by key provided in the current enum value. 
	 * @return value by key
	 */
	public String getValue() {
		return properties.getProperty(key);
	}
}