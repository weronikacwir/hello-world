package fractals;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class HTree extends Application {
	BorderPane bp;
	TextField order;
	HTreePane treepane;


	@Override
	public void start(Stage primaryStage) throws Exception {
		bp = new BorderPane();
		Scene scene = new Scene(bp, 400, 400);
		order = new TextField();
		treepane = new HTreePane();
		order.setOnAction(this::draw);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(new Label("Enter you order: "), order);
		hbox.setAlignment(Pos.CENTER);
		bp.setCenter(treepane);
		bp.widthProperty().addListener(ov-> {
				treepane.paint();
		});
		bp.heightProperty().addListener(ov ->{
				treepane.paint();
		});
		
		bp.setBottom(hbox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("HTree");
		primaryStage.show();
		
	}
	
	public void draw(ActionEvent e) {
		treepane.setOrder(Integer.parseInt(order.getText()));
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	class HTreePane extends Pane {
		private int order;
		
		public HTreePane() {
			setOrder(-1);
		}
		
		public void setOrder(int order) {
			this.order = order;
			paint();
		}
		
		public void paint() {
			this.getChildren().clear();
			display(order, getWidth()/3, new Point2D(getWidth()/2, getHeight()/2));
			
		}
		
		private void display(int order, double length, Point2D p) {
			if(order < 0)
				return;
			
			double d = length/2;
			double x = p.getX();
			double y = p.getY();
			
			Point2D p1 = new Point2D(x - d, y - d);
			Point2D p2 = new Point2D(x - d, y + d);
			Point2D p3 = new Point2D(x + d, y - d);
			Point2D p4 = new Point2D(x + d, y + d);
			this.getChildren().add(new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
			this.getChildren().add(new Line(p3.getX(), p3.getY(), p4.getX(), p4.getY()));
			this.getChildren().add(new Line(x - d, y, x + d, y));
			
			display(order - 1, d, p1);
			display(order - 1, d, p2);
			display(order - 1, d, p3);
			display(order - 1, d, p4);	
			
		}
	}


}
