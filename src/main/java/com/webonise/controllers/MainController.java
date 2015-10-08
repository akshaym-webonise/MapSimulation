package com.webonise.controllers;

import com.webonise.models.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @Autowired
    MainScreenController mainScreenController;

    @Autowired
    Coordinates coordinates;
}
