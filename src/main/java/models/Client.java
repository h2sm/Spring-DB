package models;

import lombok.Data;

import java.util.Date;

@Data
public class Client {
    private final int id;
    private final String fullName;
    private final String passport;
    private final String phoneNumber;
    private final Date birthDate;
}
