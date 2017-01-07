package ru.stqa.javaCursBarancev.addressbook.model;

/**
 * Created by yafar_000 on 17.12.2016.
 */
public class KontactData {
  private int id = 0;
  private  String firstname;
  private  String middlename;
  private  String lastname;
  private  String nickname;
  private  String title;
  private  String company;
  private  String address;
  private String homePhone;
  private  String mobile;
  private  String allPhones;
  private String workPhone;
  private  String email;
  private  String email2;
  private  String email3;
  private  String group;
  private  String address2;
  private  String notes;


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
}
