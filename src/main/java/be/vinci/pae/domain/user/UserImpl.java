package be.vinci.pae.domain.user;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Date;

import be.vinci.pae.exception.MissingFieldException;

public class UserImpl implements User {

  private int id;
  private String pseudo;
  private String nom;
  private String prenom;
  private String adresse;
  private String email;
  private String mdp;
  private Date dateInscription;
  private char status;

  public int getID() {
    return id;
  }

  public void setID(int id) {
    this.id = id;
  }

  public String getPseudo() {
    return this.pseudo;
  }

  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;

  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMdp() {
    return mdp;
  }

  public void setMdp(String mdp) {
    this.mdp = mdp;
  }

  public Date getDateInscription() {
    return dateInscription;
  }

  public void setDate(Date dateInscription) {
    this.dateInscription = dateInscription;
  }

  public UserImpl() {

  }

  @Override
  public String toString() {
    return "UserImpl [id=" + id + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom
        + ", adresse=" + adresse + ", email=" + email + ", mdp=" + mdp + ", dateInscription="
        + dateInscription + ", status=" + status + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }

    UserImpl other = (UserImpl) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }


  @Override
  public boolean hashPassword() {
    String sel = BCrypt.gensalt();
    String mdpHash = BCrypt.hashpw(this.mdp, sel);
    if (mdpHash.equals(this.mdp)) {
      throw new IllegalArgumentException("probleme hashing");
    }
    this.setMdp(mdpHash);
    return true;
  }

  @Override
  public boolean checkPwd(String motDePasseNonHashe) {
    if (motDePasseNonHashe.isEmpty()) {
      throw new MissingFieldException("Mot de passe vide");
    }
    return BCrypt.checkpw(motDePasseNonHashe, mdp);
  }

  public char getStatus() {
    return status;
  }

  public void setStatus(char status) {
    this.status = status;
  }

  @Override
  public boolean checkCanBeAdmin() {
    if (getStatus() == 'A') {
      return true;
    }
    return false;
  }

  @Override
  public void changeToAdmin() {
    if (checkCanBeAdmin()) {
      setStatus('N');
    }
  }
}
