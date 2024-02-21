package Models;

public enum Products {

   JAVASELENIUMWEBDRIVER("Java Selenium WebDriver"),
   BDDCUCUMBER("BDD Cucumber"),
    GITBASICS("GIT basics");

   String name;

    Products(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
