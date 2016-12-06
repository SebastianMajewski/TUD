package com.example.jdbcdemo.domain;
import java.util.ArrayList;

import com.example.jdbcdemo.domain.Part;

public class Phone 
{

	private int id;
	private boolean sold;
	private double price;
	private String model;
	private int megapixels;
	private ArrayList<Part> parts = new ArrayList<Part>();
	
	public int getId() 
	{
		return this.id;
	}
	
	public void setId(int id) 
	{
		this.id=id;
	}
	
	public boolean getSold() 
	{
		return this.sold;
	}
	
	public void setSold(boolean sold) 
	{
		this.sold = sold;
	}
	
	public double getPrice() 
	{
		return this.price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public String getModel() 
	{
		return this.model;
	}
	
	public void setModel(String model) 
	{
		this.model = model;
	}
	
	public int getMegapixels() 
	{
		return this.megapixels;
	}
	
	public void setMegapixels(int megapixels) 
	{
		this.megapixels = megapixels;
	}	
	public void addPart(Part part) 
	{
		this.parts.add(part);
	}
	
	public ArrayList<Part> getParts() 
	{
		return this.parts;
	}
}
