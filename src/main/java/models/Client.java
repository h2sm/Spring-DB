package models;

import lombok.Data;

import java.util.Date;
@Data
public class Client {
    private int id;
    private String fullName;
    private String passport;
    private String phoneNumber;
    private Date birthDate;

//    @Override
//    public String toString(){
//        return "Client [id =  " + id + ", name = " + fullName + ", passport = " + passport +
//                ", phone number = " + phoneNumber +
//                ", date of birth = " + birthDate.toString() + "]";
//    }
}
