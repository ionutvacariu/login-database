package login;

public class Login {

    public boolean login(String user, String pwd){
        /*
            //executeQuery
            se uita in DB sa vada daca user si pwd exista
            select * from users where userName = " + user + " and password =  " + pwd;
         */
        return true; // false
    }

    public boolean register(String userName, String pwd){
        // check if userName already exists
        // insert into users
        //executeUpdate

        return false; // user deja exista
        //return true --> am adaugat;
    }
}
