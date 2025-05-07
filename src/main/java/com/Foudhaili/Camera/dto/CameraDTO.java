package com.Foudhaili.Camera.dto;

import java.util.Date;

import com.Foudhaili.Camera.Models.Lens;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class CameraDTO {
	
	private int id;
	private String type;
	private String name;
	private Long resolution;
	private Date warranty_expiry_date;
	private Lens lens;
	
	
	
	
}
