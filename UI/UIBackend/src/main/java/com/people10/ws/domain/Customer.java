package com.people10.ws.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Customer implements Serializable {
    @ApiModelProperty(notes = "The customer ID")
    @Id
    private Long id;
    @ApiModelProperty(notes = "The customer first name")
    private String first_name;
    @ApiModelProperty(notes = "The customer last name")
    private String last_name;
    @ApiModelProperty(notes = "The customer email")
    private String email;
    @ApiModelProperty(notes = "Latitude")
    private float latitude;
    @ApiModelProperty(notes = "Longitude")
    private float longitude;
    @ApiModelProperty(notes = "IP address")
    private String ip;
    @ApiModelProperty(notes = "Created date")
    private LocalDateTime created_at;
    @ApiModelProperty(notes = "Updated date")
    private LocalDateTime updated_at;
}
