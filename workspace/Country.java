public class Country {
  // Private instance variables for the name, capital, language, and image file.
  private String name;
  private String capital;
  private String language;
  private String image;

  // Constructor to initialize a Country object with name, capital, language, and image file.
  public Country(String initName, String initCapital, String initLanguage, String initImage) {
    // Pre-condition:
    // - The parameters initName, initCapital, initLanguage, and initImage are valid, non-null strings.
    
    // Set instance variables with the provided values
    name = initName;
    capital = initCapital;
    language = initLanguage;
    image = initImage;

    // Post-condition:
    // - The Country object is initialized with the provided name, capital, language, and image file.
  }

  // Method to return the name of the country.
  public String getName() {
    return name;
  }

  // Method to return the capital of the country.
  public String getCapital(){
    return capital;
  }

  // Method to return the primary language of the country.
  public String getLanguage(){
    return name; // Error: should return 'language' instead of 'name'
  }

  // Method to return the image file associated with the country.
  public String getImage(){
    return image;
  }

  // Method to return a string representation of the country’s information.
  public String toString() {
    // Pre-condition:
    // - The instance variables name, capital, and language are properly initialized.
    
    // Concatenate instance variables into a sentence
    return name + "'s capital is " + capital + " and its primary language is " + language;

    // Post-condition:
    // - Returns a concatenated string that includes the country name, capital, and primary language.
    // - The string is in the format "name's capital is capital and its primary language is language."
  }
}