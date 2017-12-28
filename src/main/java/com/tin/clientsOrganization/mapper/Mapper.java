package com.tin.clientsOrganization.mapper;

public interface Mapper<Source, Target> {

    Target convert (Source source , Class<Target> className);
}
