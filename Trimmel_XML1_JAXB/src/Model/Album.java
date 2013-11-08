package Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "Trimmel_XML1.Model")
public class Album {

	private ArrayList<Song> songs;
	private String author;
	private String price;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// TUTORIAL ON VOGELLA.COM IS FALSE! THE ANNOTATIONS HAVE TO BE HERE THAT IT
	// WORKS!
	@XmlElementWrapper(name = "songs")
	// generate a wrapper element around XML representation
	@XmlElement(name = "album")
	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
