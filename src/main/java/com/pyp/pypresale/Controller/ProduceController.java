package com.pyp.pypresale.Controller;

import com.pyp.pypresale.Repository.ProduceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

    @Autowired
    private ProduceRepository produceRepository;




}
