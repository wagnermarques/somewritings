package helloworldwithgradle.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

//https://docs.oracle.com/javafx/2/get_started/form.htm
public class CadastroDeAlunoScene extends Scene{

	private GridPane gridPaneRoot;

	public CadastroDeAlunoScene(GridPane gridPaneRoot, double width, double height) {
		super(gridPaneRoot, width, height);
		this.gridPaneRoot = gridPaneRoot;
		this.gridPaneRoot.setAlignment(Pos.CENTER);
		this.gridPaneRoot.setHgap(10);
		this.gridPaneRoot.setVgap(10);
		this.gridPaneRoot.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Cadastro de Aluno");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.gridPaneRoot.add(scenetitle, 0, 0, 2, 1);

		Label nomeAluno = new Label("Nome do Aluno:");
		this.gridPaneRoot.add(nomeAluno, 0, 1);

		TextField txtFieldNomeAluno = new TextField();
		this.gridPaneRoot.add(txtFieldNomeAluno, 1, 1);

		Label lbCartaoDoAluno = new Label("Cartao do aluno:");
		this.gridPaneRoot.add(lbCartaoDoAluno, 0, 2);

		TextField pwBox = new TextField();
		this.gridPaneRoot.add(pwBox, 1, 2);
	}

	
	
}
