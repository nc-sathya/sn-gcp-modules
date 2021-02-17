package com.sathya.k8s.k8slearning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * This controller is to get details of a person
 */




@RestController
@RequestMapping("/api/details")
public class DetailsController {

@RequestMapping(
        value = "/fullname",
        method = RequestMethod.GET
)
public String getPersonFullName(@RequestParam String firstname, @RequestParam String lastname)throws Exception {
    return "<html><body style=\"background-color:green;\"><b>"+firstname+" " + lastname + "</b></body></html>";
}


}
