package com.multi.myStagebox;


public class PlaceVO {
	
	String place_id,place_name,place_cnt;
	String kind,city,district,open_year;
	
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPlace_cnt() {
		return place_cnt;
	}
	public void setPlace_cnt(String place_cnt) {
		this.place_cnt = place_cnt;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getOpen_year() {
		return open_year;
	}
	public void setOpen_year(String open_year) {
		this.open_year = open_year;
	}
	
	@Override
	public String toString() {
		return "PlaceVO [place_id=" + place_id + ", place_name=" + place_name + ", place_cnt=" + place_cnt + ", kind="
				+ kind + ", city=" + city + ", district=" + district + ", open_year=" + open_year + "]";
	}
	
	
}
