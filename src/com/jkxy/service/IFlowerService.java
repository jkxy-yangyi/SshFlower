package com.jkxy.service;

import java.util.List;

import com.jkxy.model.Flower;

public interface IFlowerService {
		public List<Flower> getNewFlower();
		public List<Flower> getFlowerByCatalogidPaging(int catalogid,int currentPage,int pageSize);
		public int getTotalByCatalog(int catalogid);
		public Flower getFlowerById(int id);
		public boolean addOrUpdateFlower(Flower flower);
		public List<Flower> getAllFlower();
		public boolean deleteFlowerById(int id);
}
