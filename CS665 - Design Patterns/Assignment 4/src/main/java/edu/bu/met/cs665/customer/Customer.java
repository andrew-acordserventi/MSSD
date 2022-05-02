package edu.bu.met.cs665.customer;

/**
 * Customer class. Customers have names, emails, and phone numbers.
 * Customer class also keeps track of flags for their background check, email
 * verification, etc. (mostly for testing purposes)
 */
public class Customer {
  private String name;
  private String email;
  private String phoneNumber;

  // attributes to help test command pattern
  private boolean backgroundCheck = false;
  private boolean emailVerification = false;
  private boolean welcomeEmailSent = false;
  private boolean rejectionEmailSent = false;

  public Customer(String name, String email, String phoneNumber) {
    this.setName(name);
    this.setEmail(email);
    this.setPhoneNumber(phoneNumber);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public boolean isBackgroundCheck() {
    return backgroundCheck;
  }

  public void setBackgroundCheck(boolean backgroundCheck) {
    this.backgroundCheck = backgroundCheck;
  }

  public boolean isEmailVerification() {
    return emailVerification;
  }

  public void setEmailVerification(boolean emailVerification) {
    this.emailVerification = emailVerification;
  }

  public boolean isWelcomeEmailSent() {
    return welcomeEmailSent;
  }

  public void setWelcomeEmailSent(boolean welcomeEmailSent) {
    this.welcomeEmailSent = welcomeEmailSent;
  }

  public boolean isRejectionEmailSent() {
    return rejectionEmailSent;
  }

  public void setRejectionEmailSent(boolean rejectionEmailSent) {
    this.rejectionEmailSent = rejectionEmailSent;
  }
}
