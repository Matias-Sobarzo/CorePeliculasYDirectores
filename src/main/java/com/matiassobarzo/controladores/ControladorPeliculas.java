package com.matiassobarzo.controladores;


import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControladorPeliculas {
	private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();
	
	public ControladorPeliculas() {
		listaPeliculas.put("Winnie the Pooh", "Don Hall");	
		listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
		listaPeliculas.put("Tarzán", "Kevin Lima");		
		listaPeliculas.put("Mulán", "Barry Cook");
		listaPeliculas.put("Oliver", "Kevin Lima");	
		listaPeliculas.put("Big Hero 6", "Don Hall");	
	}
	
	
	@GetMapping("/saludo")
	public String inicio() {
		return "Hola Spring Boot!";
	}
	
	@GetMapping("/peliculas")
	public String obtenerTodasLasPeliculas() {
		String str = "";
		for(Entry<String, String> entry : listaPeliculas.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    str +=  ("Titulo: " + key + ", Director: " + value + " ");
		    }
		return "Las peliculas son: " + str; 
	}
	
	
	@GetMapping("/peliculas/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable("nombre") String nombre) {
		if (listaPeliculas.containsKey(nombre)){
			return "La pelicula es: " + nombre + ", dirigida por: " + listaPeliculas.get(nombre);
		}else {
			return "La película no se encuentra en nuestra lista.";
		}
	}
	
	@GetMapping("/peliculas/director/{nombre}")
	public String obtenerPeliculasPorDirector(@PathVariable("nombre") String nombre) {
		if (listaPeliculas.containsValue(nombre)){
			String str = "";	
			for(Entry<String, String> entry : listaPeliculas.entrySet()) {
			    String key = entry.getKey();
			    String value = entry.getValue();
			    if(value.contentEquals(nombre)) {
			    	 str+=  ("Titulo: " + key + " ");
			    }
		    }
			return "El director: " + nombre + ", ha dirigido: " + 
		    str;
		}else {
			return "No contamos con películas con ese director en nuestra lista.";
		}
	}
	
		
}

	


