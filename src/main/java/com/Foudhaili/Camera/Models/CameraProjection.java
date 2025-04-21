package com.Foudhaili.Camera.Models;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "name", types = { Camera.class }) 
public interface CameraProjection {
	public String getName();
}
