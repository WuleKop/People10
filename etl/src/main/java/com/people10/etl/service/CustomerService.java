package com.people10.etl.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CustomerService {
    boolean upload(MultipartFile file);
}
