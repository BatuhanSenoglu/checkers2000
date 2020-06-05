import javax.swing.JFrame;

public abstract class JavaFrame extends JFrame{
	public void sixe() {
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
