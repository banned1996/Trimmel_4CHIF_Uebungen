package Model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {

	private static final String XML_LOC = "./XML_Collection.xml";

	public static void main(String[] args) throws JAXBException, IOException {
		// TODO Auto-generated method stub

		ArrayList<Song> songList = new ArrayList<Song>();

		// creating different instances and adding them to songList
		Song song1 = new Song();
		song1.setAuthor("Author1");
		song1.setGenre("Genre1");
		song1.setSinger("Singer1");
		song1.setTitle("Title1");
		songList.add(song1);

		Song song2 = new Song();
		song2.setAuthor("Author2");
		song2.setGenre("Genre2");
		song2.setSinger("Singer2");
		song2.setTitle("Title2");
		songList.add(song2);

		Song song3 = new Song();
		song3.setAuthor("Author3");
		song3.setGenre("Genre3");
		song3.setSinger("Singer3");
		song3.setTitle("Title3");

		// creating album, assigning song
		Album album = new Album();
		album.setAuthor("Author_Album1");
		album.setPrice("lol - This is a string :P");
		album.setSongs(songList);

		// create Context and instantiate marshaller
		JAXBContext con = JAXBContext.newInstance(Album.class);
		Marshaller m = con.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// write to System.out
		m.marshal(album, System.out);

		// write to File
		m.marshal(album, new File(XML_LOC));

		System.out.println();
		System.out.println("Output:");
		Unmarshaller m2 = con.createUnmarshaller();
		Album album2 = (Album) m2.unmarshal(new FileReader(XML_LOC));
		ArrayList<Song> songList2 = album2.getSongs();
		for (Song s : songList2) {
			System.out.println(s.getTitle() + ", sung by " + s.getSinger()
					+ " [Genre: " + s.getGenre() + ", written by "
					+ s.getAuthor() + "]");
		}
	}
}
