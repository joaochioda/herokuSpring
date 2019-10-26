package com.example.heroku2.controller;

import com.example.heroku2.model.BodyWaitApprove;
import com.example.heroku2.model.EditApprove;
import com.example.heroku2.model.Person;
import com.example.heroku2.model.WaitApprove;
import com.example.heroku2.service.EditApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EditApproveController {

    @Autowired
    private EditApproveService editApproveService;

    @RequestMapping(method = RequestMethod.POST, value= "/editapprove")
    public EditApprove addEditApprove(@RequestBody EditApprove editApprove) {
        return editApproveService.addEditApprove(editApprove);
    }

    @RequestMapping(method = RequestMethod.GET, value= "/editapprove")
    public List<EditApprove> getwaitApproveService() {
        return editApproveService.getEditApprove();
    }

    @RequestMapping(method = RequestMethod.POST, value= "/editapprove/{id}/approve")
    public EditApprove addApprovePerson(@PathVariable Long id, @RequestBody Person person) {
        return editApproveService.addAproveEdit(id,person);
    }

    @RequestMapping(method = RequestMethod.POST, value= "/editapprove/{id}/deny")
    public EditApprove addDenyPerson(@PathVariable Long id, @RequestBody Person person) {
        return editApproveService.addDenyEdit(id,person);
    }
    }



