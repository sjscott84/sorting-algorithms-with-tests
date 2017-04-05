package scott.sarah.algorithmsui;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import scott.sarah.algorithms.CountingSort;
import scott.sarah.algorithms.Sort;

public class AlgorithmsController implements Initializable{

	@FXML
    private Button randomArray;
	@FXML
    private Button worstArray;
	@FXML
    private Button sortArray;
	@FXML
    private Button clearArray;	
	@FXML
    private TextField arrayLength;
	@FXML
    private Text unsortedArrayText;
	@FXML
    private Text sortedArrayText;
	@FXML
    private Text sortTime;
	@FXML
    private ToggleGroup ToggleGroup;
	
	public int[] array;
	public int highNum;

	// Reference to the main application.
	private MainApp mainApp;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}
	
	private void buildRandomArray(int length){
		int[] newArray = new int[length];
		for(int i = 0; i < length; i++){
			int random = (int )(Math.random() * length + 1);
			newArray[i] = random;
		}
		this.array = newArray;
	}
	/**
	 * Build a worse case array, sorted in reverse order
	 * @param length
	 */
	private void buildWorstArray(int length){
		int[] newArray = new int[length];
		int value = length;
		for(int i = 0; i < length; i++){
			newArray[i] = value;
			value--;
		}
		this.array = newArray;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert randomArray != null : "fx:id=\"randomArray\" was not injected: check your FXML file 'algorithm.fxml'.";
		
	    randomArray.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	        	int num = 0;
	        	try{
	        		  num = Integer.parseInt(arrayLength.getText());
	        		} catch (NumberFormatException e) {
	        		  System.out.println("Please enter a number!");
	        		}
	        	buildRandomArray(num);
	        	highNum = num;
	        	unsortedArrayText.setText("Unsorted Array: "+Arrays.toString(array));
	        }
	    });
	    
	    worstArray.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	        	int num = 0;
	        	try{
	        		  num = Integer.parseInt(arrayLength.getText());
	        		} catch (NumberFormatException e) {
	        		  System.out.println("Please enter a number!");
	        		}
	        	buildWorstArray(num);
	        	highNum = num;
	        	unsortedArrayText.setText("Unsorted Array: "+Arrays.toString(array));
	        }
	    });
	    
	    sortArray.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
	        	String sortType = ((Labeled) ToggleGroup.getSelectedToggle()).getText().toString();
	        	float totalTime = 0;
            	if(!sortType.equals("CountingSort")){
	            	String className = "scott.sarah.algorithms." + sortType;
	            	System.out.println(className);
	            	try {
						Class<Sort> clazz = (Class<Sort>) Class.forName(className);
						Sort newInstance = clazz.newInstance();
						
						newInstance.setArray(array);
						
						long startTime = System.nanoTime();
						int[] sortedArray = newInstance.sort();
						long endTime = System.nanoTime();
						float estTime = (endTime - startTime)/1000000000f;
						totalTime = totalTime + estTime;
						
						sortedArrayText.setText("Sorted Array: "+Arrays.toString(sortedArray));
						sortTime.setText(sortType+ " took "+totalTime+" seconds to complete");
						
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
						System.out.println("Cant find " + className);
						e.printStackTrace();
					}
            	}else{
            		CountingSort countingSort = new CountingSort(array, highNum);

            		long startTime = System.nanoTime();
            		int[] sortedArray = countingSort.sort();
            		long endTime = System.nanoTime();
					float estTime = (endTime - startTime)/1000000000f;
					totalTime = totalTime + estTime;

            		sortedArrayText.setText("Sorted Array: "+Arrays.toString(sortedArray));
            		sortTime.setText(sortType+ " took "+totalTime+" seconds to complete");
            	}
	        }
	    });
	    
	    clearArray.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent event) {
				unsortedArrayText.setText("");
				sortedArrayText.setText("");
				sortTime.setText("");
				arrayLength.setText("Enter array length");
	        }
	    });
		
	}
}
