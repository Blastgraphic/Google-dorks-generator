import javafx.application.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Gdg extends Application {
	private final String FILTRO="-";
	private final String VIRGOLETTA="\"";
	private List<String> arr = new ArrayList<String>();
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GDG - Google Dorks Generator");
        primaryStage.setResizable(false);
        GridPane grid = new GridPane();
		//grid.setGridLinesVisible(true);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));

		Label title = new Label("Titolo pagina:");
		grid.add(title, 0, 1);

		TextField titleTextField = new TextField();
		titleTextField.setTooltip(new Tooltip("Ricerca pagine con un certo titolo"));
		grid.add(titleTextField, 1, 1);

		CheckBox cb1 = new CheckBox("Filtra");
		cb1.setTooltip(new Tooltip("Escludi dalla ricerca il contenuto di questo campo"));
		grid.add(cb1, 2, 1);

		Label inurl = new Label("Url:");
		grid.add(inurl, 3, 1);

		TextField inurlTextField = new TextField();
		inurlTextField.setTooltip(new Tooltip("Ricerca pagine con un certo url"));
		grid.add(inurlTextField, 4, 1);

		CheckBox cb2 = new CheckBox("Filtra");
		cb2.setTooltip(new Tooltip("Escludi dalla ricerca il contenuto di questo campo"));
		grid.add(cb2, 5, 1);

		Label intext = new Label("Testo pagina:");
		grid.add(intext, 0, 2);

		TextField intextTextField = new TextField();
		intextTextField.setTooltip(new Tooltip("Ricerca pagine contenenti un determinato testo"));
		grid.add(intextTextField, 1, 2);

		CheckBox cb3 = new CheckBox("Filtra");
		cb3.setTooltip(new Tooltip("Escludi dalla ricerca il contenuto di questo campo"));
		grid.add(cb3, 2, 2);

		Label site = new Label("Sito:");
		grid.add(site, 3, 2);

		TextField siteTextField = new TextField();
		siteTextField.setTooltip(new Tooltip("Ricerca pagine su un determinato sito"));
		grid.add(siteTextField, 4, 2);

		CheckBox cb4 = new CheckBox("Filtra");
		cb4.setTooltip(new Tooltip("Escludi dalla ricerca il contenuto di questo campo"));
		grid.add(cb4, 5, 2);

		Label filetype = new Label("Estensione/i file:");
		grid.add(filetype, 0, 3);
	
		TextField filetypeTextField = new TextField();
		filetypeTextField.setTooltip(new Tooltip("Ricerca pagine contenenti un determinato file"));
		grid.add(filetypeTextField, 1, 3);
		
		CheckBox cb5 = new CheckBox("Filtra");
		cb5.setTooltip(new Tooltip("Escludi dalla ricerca il contenuto di questo campo"));
		grid.add(cb5, 2, 3);

		Label kw = new Label("Parola chiave:");
		grid.add(kw, 3, 3);

		TextField kwTextField = new TextField();
		kwTextField.setTooltip(new Tooltip("Cerca parole chiave"));
		grid.add(kwTextField, 4, 3);

		Button button = new Button("Genera!");
		grid.add(button, 0, 4);

		Alert info = new Alert(Alert.AlertType.INFORMATION);
		info.setTitle("Informazione");
		info.setHeaderText(null);
		info.setContentText("Dork copiata nella clipboard!");

		Scene scene = new Scene(grid);

		button.setOnAction(e -> {
		if (!titleTextField.getText().equals("")){
			if(cb1.isSelected()) arr.add(FILTRO);
			arr.add("intitle:"+VIRGOLETTA+titleTextField.getText()+VIRGOLETTA+" ");
		}
		if (!inurlTextField.getText().equals("")){
			if(cb2.isSelected()) arr.add(FILTRO);
			arr.add("inurl:"+VIRGOLETTA+inurlTextField.getText()+VIRGOLETTA+" ");
		}
		if (!intextTextField.getText().equals("")){
			if(cb3.isSelected()) arr.add(FILTRO);
			arr.add("intext:"+VIRGOLETTA+intextTextField.getText()+VIRGOLETTA+" ");
		}
		if (!siteTextField.getText().equals("")){
			if(cb4.isSelected()) arr.add(FILTRO);
			arr.add("site:"+VIRGOLETTA+siteTextField.getText()+VIRGOLETTA+" ");
		}
		if (!filetypeTextField.getText().equals("")){
			if(cb5.isSelected()) arr.add(FILTRO);
			arr.add("filetype:"+filetypeTextField.getText()+" ");
		}
		if (!kwTextField.getText().equals("")){
			arr.add(VIRGOLETTA+kwTextField.getText()+VIRGOLETTA+" ");
		}
		if(arr.size()>=1){

			 final Clipboard clipboard = Clipboard.getSystemClipboard();
			 clipboard.clear();
		     final ClipboardContent content = new ClipboardContent();
		     String listString = String.join("", arr);
		     content.putString(listString);	
		     clipboard.setContent(content);
			 info.showAndWait();
			 arr.clear();
		}
						
		});

		primaryStage.setScene(scene);
        primaryStage.show();
    }
}