package org.pathfinder.service;

import org.modelmapper.ModelMapper;
import org.pathfinder.data.RouteRepository;
import org.pathfinder.model.Picture;
import org.pathfinder.model.Route;
import org.pathfinder.service.dto.RouteShortInfoDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private RouteRepository routeRepository;

    private Random random;

    private ModelMapper modelMapper;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;

        this.random = new Random();
        this.modelMapper = new ModelMapper();
    }
    @Transactional
    public List<RouteShortInfoDto> getAll(){
        return routeRepository.findAll()
                .stream().map(this::mapToShortInfo)
                .toList();
    }


    @Transactional
    public RouteShortInfoDto getRandomRoute(){

        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount) + 1;

        Optional<Route> route = routeRepository.findById(randomId);

        if (route.isEmpty()){

        }




        return  mapToShortInfo(route.get());
    }


    private RouteShortInfoDto mapToShortInfo(Route route) {

        RouteShortInfoDto dto = modelMapper.map(route,RouteShortInfoDto.class);
        Optional<Picture> first = route.getPictures().stream().findFirst();
        dto.setImageUrl(first.get().getUrl());


        return dto;

    }

}

















