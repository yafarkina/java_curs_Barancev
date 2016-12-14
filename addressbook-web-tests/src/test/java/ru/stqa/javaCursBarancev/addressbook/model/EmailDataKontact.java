package ru.stqa.javaCursBarancev.addressbook.model;

public class EmailDataKontact {
  private final String email;
  private final String email2;
  private final String email3;

  public EmailDataKontact(String email, String email2, String email3) {
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }
}
