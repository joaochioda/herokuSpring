package com.example.heroku2.controller;

import com.example.heroku2.model.Person;
import com.example.heroku2.model.WaitApprove;
import com.example.heroku2.service.WaitApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WaitApproveController {

    @Autowired
    private WaitApproveService waitApproveService;


    @RequestMapping(method = RequestMethod.GET, value="/waitapprove")
    public List<WaitApprove> getwaitApproveService() {
        return waitApproveService.getwaitApproveService();
    }

    @RequestMapping(method = RequestMethod.POST, value= "/waitapprove")
    public WaitApprove addWaitApprove(@RequestBody WaitApprove waitApprove) {
        return waitApproveService.addWaitApprove(waitApprove);
    }
    @RequestMapping(method = RequestMethod.POST, value= "/waitapprove/{id}/approve")
    public WaitApprove addApprovePerson(@PathVariable Long id, @RequestBody Person person) {
        return waitApproveService.addApprovePerson(id,person);
    }

    @RequestMapping(method = RequestMethod.POST, value= "/waitapprove/{id}/deny")
    public WaitApprove addDenyPerson(@PathVariable Long id, @RequestBody Person person) {
        return waitApproveService.addDenyPerson(id,person);
    }

}
