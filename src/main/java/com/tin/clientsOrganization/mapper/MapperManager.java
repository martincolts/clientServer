package com.tin.clientsOrganization.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperManager<Target, Source> {

    @Autowired
    private List<BaseMapper> mappers ;

    public Target convert (Source c , Class<Target> className){
        Mapper mapper = getMapper(c, className);
        if (mapper != null){
            return (Target) mapper.convert(c,className);
        }
        return null;
    }

    public List<Target> convert (List<Source> c , Class<Target> className){
        List<Target> listToReturn = new ArrayList<>();
        for (Source source : c){
            listToReturn.add(convert(source,className));
        }
        return listToReturn;
    }

    private Mapper getMapper(Source c, Class<Target> className) {
        for (BaseMapper mapper : mappers){
            if (c.getClass().toString().equals(mapper.getSourceClass())&&
                    className.toString().equals(mapper.getTargetClass())){
                return mapper ;
            }
        }
        return null;
    }

}
