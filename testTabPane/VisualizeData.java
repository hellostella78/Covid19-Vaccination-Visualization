import javax.swing.JPanel;

public class VisualizeData extends JPanel {
    private VaccineViewBundler viewBundler;
    
    public VisualizeData() {

    }

    //visualize uses bundler to access controller
	public void setBundler(VaccineViewBundler viewBundler) {
		this.viewBundler = viewBundler;
	}

}
