package com.Foudhaili.Camera.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor 
@Entity
public class Lens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLens;
	private String focalLength;
    private String aperture;
    private String mountType;
    
    @JsonIgnore
    @OneToMany(mappedBy = "lens")
    private List<Camera> cameras;
}

