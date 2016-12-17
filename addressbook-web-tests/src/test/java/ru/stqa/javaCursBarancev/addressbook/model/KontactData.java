package ru.stqa.javaCursBarancev.addressbook.model;

/**
 * Created by yafar_000 on 17.12.2016.
 */
public class KontactData {

 // private final String group;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String mobile;
  private final String address2;
  private final String notes;

  public KontactData(String nickname, String title, String company, String address, String mobile, String address2, String notes) {
    //this.group = group;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.address2 = address2;
    this.notes = notes;
  }

  //public String getGroup() {
   // return group;
  //}

  public String getAddress() {
    return address;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getMobile() {
    return mobile;
  }

  public String getAddress2() {
    return address2;
  }

  public String getNotes() {
    return notes;
  }
}
