

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BufferedImage imgBuf = new BufferedImage(350, 350, BufferedImage.TYPE_INT_RGB);
		Graphics gr = imgBuf.createGraphics();
		
		//Random class for random values
		Random r = new Random();
		
		int randomColor = r.nextInt(5);
		int randomForm = r.nextInt(4);
		
		//switch between cases of random sizes
		switch (randomColor) {
		case 0:
			//Blue if 0
			gr.setColor(Color.BLUE);
			break;
		case 1:
			//Red if 1
			gr.setColor(Color.RED);
			break;
		case 2:
			//Yellow if 2
			gr.setColor(Color.YELLOW);
			break;
		case 3:
			//Green if 3
			gr.setColor(Color.GREEN);
			break;
		case 4:
			//Cyan if 4
			gr.setColor(Color.CYAN);
			break;
		}
		
		switch (randomForm) {
		case 0:
			//Rectangle
			gr.fillRect(10, 10, 50, 50);
			break;
		case 1:
			//Circle
			gr.fillOval(20, 20, 300, 300);
			break;
		case 2:
			//Oval
			gr.fillOval(20, 20, 300, 200);
			break;
		case 3:
			//Arc
			gr.fillArc(20, 20, 500, 500, 50, 50);
			break;
		}
		
		//Don't use that pic anymore so ImageIO class can write to the website
		gr.dispose();
		
		
		//Write a picture on the site
		ImageIO.write(imgBuf, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
