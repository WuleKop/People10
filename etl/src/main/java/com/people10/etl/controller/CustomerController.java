package com.people10.etl.controller;

import com.people10.etl.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping ("/")
    public String getUploadForm() {
        return "uploadForm";
    }
    @PostMapping("/upload")
    public String uploadData(MultipartFile file, RedirectAttributes attr) {
        if(customerService.upload(file)) {
            attr.addFlashAttribute("fileName",file.getName());
            return "redirect:/success";
        }
        return "Wrong Data Submission";
    }
    @GetMapping("/success")
    public String updateSuccess() {
        return "uploadSuccess";
    }
}
