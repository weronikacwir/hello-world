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

public class SierpinskiTriangle extends Application {
	BorderPane bp;
	TextField order;
	SierpinskiTrianglePane stp;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		bp = new BorderPane();
		Scene scene = new Scene(bp, 400, 400);
		order = new TextField();
		stp = new SierpinskiTrianglePane();
		order.setOnAction(this::draw);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(new Label("Enter you order: "), order);
		hbox.setAlignment(Pos.CENTER);
		bp.setCenter(stp);
		bp.widthProperty().addListener(ov-> stp.paint());
		bp.heightProperty().addListener(ov -> stp.paint());
		
		bp.setBottom(hbox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Sierpinski Triangle");
		primaryStage.show();
	}
	
	public void draw(ActionEvent e) {
		stp.setOrder(Integer.parseInt(order.getText()));
	}

	public static void main(String[] args) {
		launch(args);
	}

	class SierpinskiTrianglePane extends Pane {
		private int order;
		
		
		public SierpinskiTrianglePane() {
			setOrder(-1);
		}
		
		public void setOrder(int order) {
			this.order = order;
			paint();
		}
		
		public void paint() {
			this.getChildren().clear();
			
			double sideLength = getWidth() * 2/3;
			double height = (sideLength * Math.sqrt(3)) / 2;
			double x = (getWidth() - sideLength) / 2;
			double y = height + (getHeight() - height) / 2;
			Point2D A = new Point2D(x, y);
			Point2D B = new Point2D(x + sideLength, y);
			Point2D C = new Point2D((A.getX() + B.getX()) / 2, y - height);
			
			display(order, A, B, C);
		}
		
		private void display(int order, Point2D p1, Point2D p2, Point2D p3) {
			if(order < 0)
				return;
			if(order == 0) {
				displayLine(p1, p2);
				displayLine(p2, p3);
				displayLine(p3, p1);		
			}
			else {
				Point2D p12 = p1.midpoint(p2);
				Point2D p23 = p2.midpoint(p3);
				Point2D p31 = p3.midpoint(p1);
				
				display(order - 1, p1, p12, p31);
				display(order - 1, p2, p12, p23);
				display(order - 1, p3, p23, p31);		
			}
		}
		
		private void displayLine(Point2D A, Point2D B){
			this.getChildren().add(new Line(A.getX(), A.getY(), B.getX(), B.getY()));
		}
	}
}
