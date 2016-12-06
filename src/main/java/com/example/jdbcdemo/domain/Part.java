package com.example.jdbcdemo.domain;

public class Part 
{
	private int id;
	private String name;
	private double price;
	private int ownerId;
	
	public int getId() 
	{
		return this.id;
	}
	
	public void setId(int id) 
	{
		this.id=id;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void setName(String name) 
	{
		this.name=name;
	}
	
	public double getPrice() 
	{
		return this.price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public double getOwnerId() 
	{
		return this.ownerId;
	}
	
	public void setOwnerId(int owner) 
	{
		this.ownerId = owner;
	}
}
