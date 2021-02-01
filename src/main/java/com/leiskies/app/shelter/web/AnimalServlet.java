package com.leiskies.app.shelter.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leiskies.app.shelter.dao.ModelDAO;
import com.leiskies.app.shelter.model.Animal;
import com.leiskies.app.shelter.model.Animal_Images;
import com.leiskies.app.shelter.model.Location;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

@WebServlet("/") 
public class AnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	@SuppressWarnings("unused")
	private List<Animal> animalList;
	public void init() {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getServletPath();
		final String string = action.substring(1);
		
		List<Location> locationList = new ModelDAO<Location,Integer>(Location.class).readAll();
		for(Location location:locationList) {
			
			if(location.getName().replace(" ", "_").equalsIgnoreCase(string.replace(" ", "_"))) {
				listAnimalsByLocation(request, response, action.substring(1));
			}
		}
		
		
		switch(action) {
		case "r":
			System.out.println("inside /list");
			listAnimals(request,response);
			break;
		case "/":
			System.out.println("inside /");
			listAnimals(request,response);
			break;
		case "":
			System.out.println("inside \"\""); 
			listAnimals(request,response);
			break;
		case "/all":
			System.out.println("inside /all");
			listAnimals(request,response);
			break;
		}
	}
	private void listAnimals(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ModelDAO<Animal,Integer> dao = new ModelDAO<Animal,Integer>(Animal.class);
		List<Animal> animalList = dao.readAll();
		
		request.setAttribute("animalList", animalList);
		request.getRequestDispatcher(""
				+ "all.jsp").forward(request, response);
	}
	
	private void listAnimalsByLocation(HttpServletRequest request, HttpServletResponse response, String location) 
			throws ServletException, IOException {
		ModelDAO imgDao = new ModelDAO<Animal_Images,Integer>(Animal_Images.class);
		List<Animal_Images> imgList = imgDao.readAll();
		
		
		ModelDAO<Location,Object> locationDao = new ModelDAO<Location,Object>(Location.class);	
		int locationCode = locationDao.readByAttribute("name", location.replace("_", " ")).getId();
		locationDao = null;
		ModelDAO<Animal,Integer> animalDao = new ModelDAO<Animal,Integer>(Animal.class);
		List<Animal> animalList = animalDao.readAll()
				.stream().filter(a->a.getLocation()==locationCode).collect(Collectors.toList());
		Collections.shuffle(animalList);
		request.setAttribute("location", location.replace("_", " "));
		request.setAttribute("animalList", animalList);
		request.setAttribute("imgList", imgList);
		request.getRequestDispatcher("animalView.jsp").forward(request, response);
	}
}
