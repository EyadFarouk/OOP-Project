package ASU.CIS.Project.Resturants;



public class Restaurant extends Menu {

    public String name;
    public String address;
    public String contactInformation;
    public double rating;
    int numberOfRating;
    public void displayMenu(){
        for (int i=0;i<10;i++){
            System.out.println("name of item "+(i+1) +" : "+menu.get(i).name);
            System.out.println("description of item "+(i+1) +" : "+menu.get(i).description);
            System.out.println("price of item "+(i+1) +" : "+menu.get(i).price);
            System.out.println("categories of item "+(i+1) +" : "+menu.get(i).categories);
            System.out.println("rating of item "+(i+1) +" : "+menu.get(i).rating);
        }
    }
    public void searchAboutDishWithName(String name){
        for (int i=0;i<menu.size();i++){
            if (name.equals(menu.get(i).name)){
                System.out.println("dish is available");
            }
            else{
                System.out.println("dish is not available");
            }
        }
    }
    public void searchAboutDishWithDescription(String description){
        for (int i=0;i<menu.size();i++){
            if (description.equals(menu.get(i).description)){
                System.out.println("dish is available");
            }
            else{
                System.out.println("dish is not available");
            }
        }
    }
    public void searchAboutDishWithCategories(String categories){
        for (int i=0;i<menu.size();i++){
            if (categories.equals(menu.get(i).categories)){
                System.out.println("dish is available");
            }
            else{
                System.out.println("dish is not available");
            }
        }
    }


}
