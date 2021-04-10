import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//hello my friends

public class VaccineMain {

	public static void main(String[] args) {
		
		//instantiate only one persisting viewBundler and controller
		VaccineViewBundler viewBundler = new VaccineViewBundler();
		VaccineController controller = new VaccineController();

		//connect the two together
		viewBundler.setController(controller);
		controller.setBundler(viewBundler);
	}

}
