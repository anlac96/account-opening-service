package com.github.anlac96.account.opening.service.api.converter;

import org.mapstruct.factory.Mappers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApiConverterFactory {

    private static final ApiConverterFactory INSTANCE = new ApiConverterFactory();

    private final Map<Class<?>, Object> mapperInstances = new ConcurrentHashMap<>();

    private ApiConverterFactory() {
    }

    public static ApiConverterFactory getInstance() {
        return INSTANCE;
    }

    public RegistrationConverter getRegistrationConverter() {
        return getMapperFromCache(RegistrationConverter.class);
    }

    private <T> T getMapperFromCache(Class<T> mapperClass) {
        T mapperImplInstance = (T) mapperInstances.get(mapperClass);
        if (mapperImplInstance == null) {
            mapperImplInstance = Mappers.getMapper(mapperClass);
            mapperInstances.put(mapperClass, mapperImplInstance);
        }
        return mapperImplInstance;
    }

}
