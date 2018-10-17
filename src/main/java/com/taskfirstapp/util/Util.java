package com.taskfirstapp.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class Util {
	private Util() {
	}

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static <T> T readValue(String content, Class<T> valueType) {
		try {
			return objectMapper.readValue(content, valueType);
		} catch (IOException e) {
			throw new RuntimeException(e); // TODO add common module with exception and other common code like mapper
											// for all projects
		}
	}

}
