package ru.stqa.javaCursBarancev.addressbook.model;

public class PersonalDataKontact {
  private final String firstname;
  private final String middlename;
  private final String lastname;

  public PersonalDataKontact(String firstname, String middlename, String lastname) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }
}
