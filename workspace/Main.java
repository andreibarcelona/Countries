import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

//Andrei Barcelona
// 1-14-25
// This app quizzes users on their geogaraphy skills (asks what country is displayed on the map)


public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField input; 
  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  public void loadCountries() 
{
  // Open the data file - do not change
  File file = new File("/workspaces/Countries/workspace/countries-data.csv");
  Scanner scan = null;
  try {
    scan = new Scanner(file);
  } catch(FileNotFoundException e) { 
      System.out.println("File not found");     
  }
  
  // Pre-condition:
  // - The countryArray is declared and has a predefined size (it must be able to hold data).
  // - The file "/workspaces/Countries/workspace/countries-data.csv" exists and is accessible.
  // - The Country constructor accepts 4 arguments: name, capital, region, and image filename.
  // - The Scanner object scan is successfully initialized.
  
  // Write a for loop that goes through the countryArray.
  for(int i = 0; i < countryArray.length; i++ ) {
    // Do the following inside the loop
    String input = scan.nextLine();
    String[] data = input.split(",");
    System.out.println("Read in " + data[0]);
    
    countryArray[i] = new Country(data[0], data[1], data[2], data[3]);
    // inside the loop, create a new Country using your constructor with 3 arguments and pass in data[0], data[1], data[2], data[3] as arguments.
    // inside the loop, set countryArray[i] to the created Country object
  }

  // Post-condition:
  // - The countryArray is populated with Country objects, each created from data read from the CSV file.
  // - Each Country in the array is initialized with values from the CSV file (name, capital, region, image filename).
  // - The Scanner object has processed the data file, and the file has been closed (implicitly by Scanner when the method ends).
}

public void showCountry() {
  // Get the country at index from countryArray
  Country c = countryArray[index];
  String imagefile = c.getImage();

  // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
  // Use the following code to create a new Image Icon and put it into the GUI
  img = new ImageIcon("/workspaces/Countries/workspace/"+ imagefile);
  imageLabel.setIcon(img);

  // Pre-condition:
  // - The index variable is within valid bounds (0 to countryArray.length - 1).
  // - countryArray is populated with valid Country objects.
  // - Each Country object in the array has a valid image filename (through its getImage() method).
  
  // Post-condition:
  // - The appropriate country's image is displayed in the GUI using ImageIcon.
  // - The image is updated on the imageLabel component in the GUI.
}

public void nextButtonClick()
{
  index++;

  if (index > 9) 
  {
    index = 0;
  }

  outputLabel.setText("");

  showCountry();

  // Pre-condition:
  // - The index variable exists and is an integer.
  // - The countryArray has been populated with Country objects.
  // - The outputLabel is a valid GUI component that can update its text.

  // Post-condition:
  // - The index is incremented by 1.
  // - If the index exceeds the maximum valid index (9), it wraps around to 0.
  // - The outputLabel is cleared by setting its text to an empty string.
  // - showCountry() is called to update the image display based on the new index.
}

public void reviewButtonClick()
{
  Country c = countryArray[index];
  String countryInfo = c.toString();

  System.out.println(countryInfo);

  outputLabel.setText(countryInfo);

  // Pre-condition:
  // - The index variable exists and points to a valid entry in countryArray.
  // - countryArray has been populated with Country objects.
  // - Each Country object implements a toString() method that returns a string representing the country's information.
  // - outputLabel is a valid GUI component that can update its text.

  // Post-condition:
  // - The country at the current index is retrieved from the countryArray.
  // - The country’s information is printed to the console.
  // - The information is displayed in the outputLabel as text.
}

private boolean questionAsked = false; // Flag to track if question has been asked

public void quizButtonClick() {
  if (!questionAsked) {
    // Show the question to the user
    outputLabel.setText("What is the name of the country?");
    questionAsked = true;  // Mark that the question has been asked
  } else {
    // Check the answer
    Country c = countryArray[index];
    
    if (input.getText().equalsIgnoreCase(c.getName())) {
      System.out.println("correct!");
      outputLabel.setText("Correct!");
    } else {
      System.out.println("Incorrect! The correct answer is " + c.getName() + ".");
      outputLabel.setText("Incorrect! The correct answer is " + c.getName() + ".");
    }

    // Reset the questionAsked flag so that next time it will ask a new question
    questionAsked = false;
  }
}


  // Pre-condition:
  // - The index variable exists and points to a valid entry in countryArray.
  // - The countryArray is populated with Country objects.
  // - outputLabel is a valid GUI component capable of displaying text.
  // - The input (presumably a text field for user input) is available to get the user's answer.
  // - The Country class has a getName() method to retrieve the country’s name.

  // Post-condition:
  // - The outputLabel is cleared.
  // - The user’s input is compared to the name of the current country (from countryArray).
  // - If the user’s answer matches the country name (case-insensitive), the output label displays "correct!".
  // - If the user’s answer is incorrect, the output label displays "Incorrect! The correct answer is [country name]."
  // - A corresponding message ("correct!" or "Incorrect!") is printed to the console.





  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
        
        input = new JTextField(20);
        jFrame.add(input);


        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}
