package helloworldwithgradle.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LoginScene extends Scene{
	
	private static String senhaInformada;
	private static String usuarioInformado;
	
	private Label lbUser = new Label("Usuario:");
	private TextField txtUser = new TextField("Entre com seu usuario aqui...");
	private Label lbSenha = new Label("Senha:");
	private PasswordField txtSenha = new PasswordField();
	private Button btnLogin = new Button();
	
	private VBox layoutContainerRoot;
	
	public LoginScene(VBox layoutContainerRoot, double width, double height) {
		super(layoutContainerRoot, width, height);
		this.layoutContainerRoot = layoutContainerRoot;

		this.btnLogin.setText("Login");
		this.btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
                System.out.println("Botao de login pressionado!!!");
            }
        });
 
		this.layoutContainerRoot.getChildren().add(this.lbUser); 
		this.layoutContainerRoot.getChildren().add(this.txtUser);
		this.layoutContainerRoot.getChildren().add(this.lbSenha);
		this.layoutContainerRoot.getChildren().add(this.txtSenha);
        this.layoutContainerRoot.getChildren().add(this.btnLogin);
                         
	}
	
}
