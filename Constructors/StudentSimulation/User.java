package LearningOOP.Constructors.StudentSimulation;

public class User
 {
    
    private int userID;
    private String userName, firstName, lastName;

    User(int userID, String userName, String firstName, String lastName)//this can be used still to 
    // initialize the value of the datas but they still cannot be accessed in the main
    {
        this.userID = userID;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    void setUserID(int userID){
        this.userID = userID;
    }
    int getUserID()
    {
        return userID;
    }
}

