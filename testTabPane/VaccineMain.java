import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//hello my friends

public class VaccineMain {

	public static void main(String[] args) {

		VaccineViewBundler viewBundler = new VaccineViewBundler();
		VaccineController controller = new VaccineController();

		viewBundler.setController(controller);
		controller.SetBundler(viewBundler);
	}

}
