package com.multi.myStagebox;


public class PlaceDetailVO {
	
	String place_id,place_name,place_cnt;
	String kind,open_year,seat_cnt,tel,website,address,latitude,longitude;
	
	
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
	public String getOpen_year() {
		return open_year;
	}
	public void setOpen_year(String open_year) {
		this.open_year = open_year;
	}
	public String getSeat_cnt() {
		return seat_cnt;
	}
	public void setSeat_cnt(String seat_cnt) {
		this.seat_cnt = seat_cnt;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "PlaceDetailVO [place_id=" + place_id + ", place_name=" + place_name + ", place_cnt=" + place_cnt
				+ ", kind=" + kind + ", open_year=" + open_year + ", seat_cnt=" + seat_cnt + ", tel=" + tel
				+ ", website=" + website + ", address=" + address + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
	
	
	
	
	
	
}
