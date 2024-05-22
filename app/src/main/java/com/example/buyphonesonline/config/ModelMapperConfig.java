package com.example.buyphonesonline.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperConfig {
    private static final ModelMapper modelMapper;
    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    public static ModelMapper getModelMapper(){
        return modelMapper;
    }

}
