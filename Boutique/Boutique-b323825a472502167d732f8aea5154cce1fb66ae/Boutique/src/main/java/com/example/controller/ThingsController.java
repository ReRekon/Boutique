package com.example.controller;

import com.example.entity.Things;
import com.example.service.ThingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/things")
public class ThingsController
{
    @Autowired
    private ThingsService thingsService;

    @RequestMapping("/insert/{id}")
    public String GetThings(@PathVariable Integer id)
    {
        return thingsService.selectThings(id).toString();
    }
}
