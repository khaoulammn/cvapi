package com.cvapi.controller;

import com.cvapi.model.CV;
import com.cvapi.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// cette classe est un controller REST qui va gerer les routers API (http)
@RestController
//toutes les routes de cette classe vont commancer par /cv
@RequestMapping("api/cv")
public class CVController {

    @Autowired
    private CVService cvService;
    //ENDPOINT
    // POST /cv/upload

    @PostMapping("/upload")
    public CV uploadCv(@RequestBody CV cv) {
        return cvService.uploadCv(cv);
    }


    // POST /cv/extract?id=1
    @PostMapping("/extract")
    public CV extractCv(@RequestParam Long id) {
        return cvService.extractFromPdf(id);
    }

    // GET /cv
    @GetMapping
    public List<CV> getAllCvs() {
        return cvService.getAllCvs();
    }

    // GET /cv/{id}
    @GetMapping("/{id}")
    public CV getCvById(@PathVariable Long id) {
        return cvService.getCvById(id);
    }
}
