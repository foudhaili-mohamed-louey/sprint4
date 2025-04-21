package com.Foudhaili.Camera.Models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Camera {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 4 , max = 50)
	private String type;
	
	@NotNull
	@Size(min = 4 , max = 50)
	private String name;
	
	@NotNull
	@Max(value = 1000000000)
	@Min(value = 100000000)
	private Long resolution;
	
	@NotNull(message = "Warranty expiration date is required")
	@Temporal(TemporalType.DATE) 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Warranty expiration date must be today or in the future")
	private Date warranty_expiry_date;
	
	@ManyToOne
	private Lens lens;
	
	public Lens getLens() {
		return lens;
	}
	public void setLens(Lens lens) {
		this.lens = lens;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getResolution() {
		return resolution;
	}
	public void setResolution(Long resolution) {
		this.resolution = resolution;
	}
	public Date getWarranty_expiry_date() {
		return warranty_expiry_date;
	}
	public void setWarranty_expiry_date(Date warranty_expiry_date) {
		this.warranty_expiry_date = warranty_expiry_date;
	}
	public Camera() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Camera(String type, String name, Long resolution, Date warranty_expiry_date) {
		super();
		this.type = type;
		this.name = name;
		this.resolution = resolution;
		this.warranty_expiry_date = warranty_expiry_date;
	}
	@Override
	public String toString() {
		return "Camera [id=" + id + ", type=" + type + ", name=" + name + ", resolution=" + resolution
				+ ", warranty_expiry_date=" + warranty_expiry_date + "]";
	}
}