package ru.stqa.javaCursBarancev.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

/**
 * Created by yafar_000 on 17.12.2016.
 */

@XStreamAlias("kontact")

public class KontactData {
  @XStreamOmitField
  private int id = 0;
  @Expose
  private  String firstname;
  @Expose
  private  String middlename;
  @Expose
  private  String lastname;
  @Expose
  private  String nickname;
  @Expose
  private  String title;
  @Expose
  private  String company;
  @Expose
  private  String address;
  @Expose
  private String homePhone;
  @Expose
  private  String mobile;
  @Expose
  private  String allPhones;
  @Expose
  private String workPhone;
  @Expose
  private  String email;
  @Expose
  private  String email2;
  @Expose
  private  String email3;
  @Expose
  private  String allEmails;
  @Expose
  private  String group;
  @Expose
  private  String address2;
  @Expose
  private  String notes;
  @XStreamOmitField
  private File photo;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    KontactData that = (KontactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return address != null ? address.equals(that.address) : that.address == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "KontactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            '}';
  }

   public int getId() {
    return id;
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

  public String getMobilePhone() {
    return mobile;
  }

  public String getAddress2() {
    return address2;
  }

  public String getNotes() {
    return notes;
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

  public String getAllEmails() {
    return allEmails;
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

  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public File getPhoto() {
    return photo;
  }

  public KontactData withId(int id) {
    this.id = id;
    return this;
  }

  public KontactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public KontactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public KontactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public KontactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public KontactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public KontactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public KontactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public KontactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public KontactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public KontactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public KontactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public KontactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public KontactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public KontactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public KontactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }


  public KontactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public KontactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public KontactData withAllPhones(String allPones) {
    this.allPhones = allPones;
    return this;
  }
  public KontactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }
}
