import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;

public class GroupSizeApp1 extends Application{
	@Override
	public void start(Stage primaryStage){
		

		GridPane grid = new GridPane();
			ColumnConstraints column1 = new ColumnConstraints();
			column1.setPercentWidth(5);
			grid.getColumnConstraints().add(column1);
			ColumnConstraints column2 = new ColumnConstraints();
			column2.setPercentWidth(30);
			grid.getColumnConstraints().add(column2);
			ColumnConstraints column3 = new ColumnConstraints();
			column3.setPercentWidth(30);
			grid.getColumnConstraints().add(column3);
			ColumnConstraints column4 = new ColumnConstraints();
			column4.setPercentWidth(30);
			grid.getColumnConstraints().add(column4);
			ColumnConstraints column5 = new ColumnConstraints();
			column5.setPercentWidth(5);
			grid.getColumnConstraints().add(column5);

			RowConstraints row1 = new RowConstraints();
			RowConstraints row2 = new RowConstraints();
			RowConstraints row3 = new RowConstraints();
			row1.setPercentHeight(33);
			row2.setPercentHeight(34);
			row3.setPercentHeight(33);
			grid.getRowConstraints().add(row1);
			grid.getRowConstraints().add(row2);
			grid.getRowConstraints().add(row3);

		grid.setVgap(5);
		grid.setHgap(5);

		Label prompt = new Label("Enter number of people playing");
		
		TextField input = new TextField();

		Button submit = new Button("Submit");
		submit.setDefaultButton(true);
		Button cancel = new Button("Cancel");
		Button ok = new Button("OK");
		ok.setDefaultButton(true);

		grid.add(prompt, 1, 0);
		GridPane.setColumnSpan(prompt, 3);
		grid.add(input, 1, 1);
		GridPane.setColumnSpan(input, 3);
		grid.add(submit, 1, 2);
		grid.add(cancel, 3, 2);
		
		submit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent submita){
				
				double people;
				String intext = input.getText();
				try{
					people = Integer.parseInt(intext);

					if(people>10){
					double output = people/2;	
					grid.getChildren().remove(input);
					grid.getChildren().remove(submit);
					GridPane.setRowSpan(prompt, 2);
					grid.add(ok, 1, 2);
					prompt.setText("You have " + people + " and your team size is " + output);
					}
					else if(people>=3 && people<=10){
					double output = people/3;
					grid.getChildren().remove(input);
					grid.getChildren().remove(submit);
					GridPane.setRowSpan(prompt, 2);
					grid.add(ok, 1, 2);
					prompt.setText("You have " + people + " and your teams size is " + output);
					}
					else{
					prompt.setText("The amount of people need to be at least 3. Input again");
					}
				} catch(NumberFormatException FUCKYOU){
				}
			}
		});
		
		ok.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent oka){
				grid.getChildren().remove(ok);
				GridPane.setRowSpan(prompt, 1);
				grid.add(input, 1, 1);
				grid.add(submit, 1, 2);
				prompt.setText("Enter number of people playing");
				submit.setDefaultButton(true);
			}
		});
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent cancela){
				System.exit(0);
			}
		});
		Scene scene = new Scene(grid, 500, 90);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
