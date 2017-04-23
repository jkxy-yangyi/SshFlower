package com.jkxy.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;



import com.jkxy.model.Catalog;
import com.jkxy.model.Flower;
import com.jkxy.service.ICatalogService;
import com.jkxy.service.IFlowerService;
import com.jkxy.util.Pager;
import com.jkxy.util.Uploadzp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class FlowerAction extends ActionSupport {
	private ICatalogService catalogService;
	private IFlowerService  flowerService;
	private int catalogid;	//同名成员变量，获取页面传过来的catalogid
	private int currentPage=1;
	private Flower flower;
	private String picture;
	private File upload;
	//根据页面控件提取要上传的（upload与控件名称一致）文件的名字
	private String uploadFileName;
	private int flowerid;
	private List<Catalog> catalogs;
	
	public List<Catalog> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

	public int getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public IFlowerService getFlowerService() {
		return flowerService;
	}

	public void setFlowerService(IFlowerService flowerService) {
		this.flowerService = flowerService;
	}

	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public Flower getFlower() {
		return flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public int getFlowerid() {
		return flowerid;
	}

	public void setFlowerid(int flowerid) {
		this.flowerid = flowerid;
	}
	
	public String addFlower() throws Exception{

		catalogs=catalogService.getAllCatalogs();
		return "success";
	}

	public String browseCatalog() throws Exception{

		catalogs=catalogService.getAllCatalogs();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("catalogs",catalogs);
		return "success";
	}
	
	public String browseNewFlower() throws Exception{

		List newflowers=flowerService.getNewFlower();
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("newflowers",newflowers);
		return SUCCESS;
	}
	public String browseFlowerPaging()throws Exception{
		//catalogid 是menu.jsp 页面中传递多来的id；（struts原理）要获取需要做同名成员变量（private int catalogid）
		int totalSize=flowerService.getTotalByCatalog(catalogid);
		Pager page=new Pager(currentPage, totalSize);
		List<Flower> flowers=flowerService.getFlowerByCatalogidPaging(catalogid, currentPage, page.getPageSize());
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("flowers",flowers);
		request.put("page",page);
		return SUCCESS;	
	}
	
	public String addOrUpdateFlower()throws Exception{
		//图片存放
		String path=ServletActionContext.getServletContext().getRealPath("/pic");
		System.out.println(path);
		List list=flowerService.getNewFlower();
		Flower flower1=(Flower)list.get(0);
		int currentFlowerId=flower1.getFlowerid()+1;
		path=path+"\\"+currentFlowerId+this.getUploadFileName();
		if(this.getUpload()!=null){
			 new Uploadzp().upload(this.getUpload(), path);
		}
  	    flower.setPicture(currentFlowerId+this.getUploadFileName());
  	    Flower flower2=new Flower();
  	    flower2.setCatalog(flower.getCatalog());
  	    flower2.setFlowername(flower.getFlowername());
  	    if(flower.getPicture()==null)
  	    	 flower2.setPicture(picture);	
  	    else
  	    flower2.setPicture(flower.getPicture());
  	    flower2.setPrice(flower.getPrice());
  	    flower2.setFlowerid(flower.getFlowerid());
  	    if (flowerService.addOrUpdateFlower(flower2))

			return SUCCESS;
		else 
			return ERROR;			
		
	}
	public String browseAllFlowerPaging()throws Exception{
		List flowers=flowerService.getAllFlower();
	
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("flowers",flowers);
		
		return SUCCESS;	
	}
	/**
	 * 修改花品
	 * @return
	 * @throws Exception
	 */
	public String displayOneFlower()throws Exception{
		
		Flower modifyFlower=flowerService.getFlowerById(flowerid);
		System.out.println("modify");
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("flower",modifyFlower);
		return SUCCESS;
		
	}
	/**
	 * 删除花品
	 * @return
	 * @throws Exception
	 */
	public String deleteOneFlower()throws Exception{
		flowerService.deleteFlowerById(flowerid);
		System.out.println("delete");
		return SUCCESS;
		
	}
}
