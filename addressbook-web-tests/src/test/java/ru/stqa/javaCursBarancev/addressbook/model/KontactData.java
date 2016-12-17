package ru.stqa.javaCursBarancev.addressbook.model;

/**
 * Created by yafar_000 on 17.12.2016.
 */
public class KontactData {

  private String group;
  private String address;
  private String nickname;
  private String title;
  private String company;
  private String mobile;
  private String address2;
  private String notes;

  public KontactData(String group, String address, String nickname, String title, String company, String mobile, String address2, String notes) {
    this.group = group;
    this.address = address;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.mobile = mobile;
    this.address2 = address2;
    this.notes = notes;
  }

  public String getGroup() {
    return group;
  }

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
