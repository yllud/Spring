package com.multi.myStagebox;

import java.sql.Date;

public class PlayVO {
	String play_id,play_name;
	Date play_start;
	Date play_end;
	String place_name,poster,genre_name,state,openrun;
	public String getPlay_id() {
		return play_id;
	}
	public void setPlay_id(String play_id) {
		this.play_id = play_id;
	}
	public String getPlay_name() {
		return play_name;
	}
	public void setPlay_name(String play_name) {
		this.play_name = play_name;
	}
	public Date getPlay_start() {
		return play_start;
	}
	public void setPlay_start(Date play_start) {
		this.play_start = play_start;
	}
	public Date getPlay_end() {
		return play_end;
	}
	public void setPlay_end(Date play_end) {
		this.play_end = play_end;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOpenrun() {
		return openrun;
	}
	public void setOpenrun(String openrun) {
		this.openrun = openrun;
	}
	@Override
	public String toString() {
		return "PlayVO [play_id=" + play_id + ", play_name=" + play_name + ", play_start=" + play_start + ", play_end="
				+ play_end + ", place_name=" + place_name + ", poster=" + poster + ", genre_name=" + genre_name
				+ ", state=" + state + ", openrun=" + openrun + "]";
	}
	
	
	
}
