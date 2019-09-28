package com.people10.etl.service;

import com.people10.etl.domain.Customer;
import com.people10.etl.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public boolean upload(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return false;
        }
        int created_at=0,first_name=0,last_name=0,email=0,latitude=0,longitude=0,ip=0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line=br.readLine();
            String [] s=line.split(",");
            for(int i=0;i<s.length;i++) {
                if(s[i].equals("SignUpDate") || s[i].equals("createDatetime")) created_at=i;
                else if(s[i].equals("First") || s[i].equals("firstName")) first_name=i;
                else if(s[i].equals("Last") || s[i].equals("lastName")) last_name=i;
                else if(s[i].equals("Email") || s[i].equals("emailAddress")) email=i;
                else if(s[i].equals("Latitude") || s[i].equals("geoLat")) latitude=i;
                else if(s[i].equals("Longitude") || s[i].equals("geoLong")) longitude=i;
                else if(s[i].equals("IP") || s[i].equals("ipAddress")) ip=i;
            }
             while ((line = br.readLine()) != null) {
                    s = line.split(",");
                    Customer c= new Customer();
                    try {
                        DateFormat format = new SimpleDateFormat("yyyy-MM-d HH:mm:ss");
                        c.setCreated_at(format.parse(s[created_at]));
                    }
                    catch (Exception e) {
                        c.setCreated_at(new Date());
                    }
                    c.setFirst_name(s[first_name]);
                    c.setLast_name(s[last_name]);
                    c.setEmail(s[email]);
                    try {
                        c.setLatitude(Float.parseFloat(s[latitude]));
                        c.setLongitude(Float.parseFloat(s[longitude]));
                    }
                    catch (Exception e) {
                        c.setLatitude(0f);
                        c.setLongitude(0f);
                    }
                    c.setIp(s[ip]);
                    customerRepository.save(c);
                }
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
