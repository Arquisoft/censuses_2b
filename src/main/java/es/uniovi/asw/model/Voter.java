package es.uniovi.asw.model;

/**
 * Created by Ignacio Fernandez on 10/02/2016.
 */
public class Voter {


    private String name;

    private String email;

    private String NIF;

    private String password;

    private int pollingStatio;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNIF() {
        return NIF;
    }

    public String getPassword() {
        return password;
    }

    public int getPollingStatio() {
        return pollingStatio;
    }

    public void setPollingStatio(int pollingStatio) {
        this.pollingStatio = pollingStatio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voter)) return false;

        Voter voter = (Voter) o;

        return NIF.equals(voter.NIF);

    }

    @Override
    public int hashCode() {
        return NIF.hashCode();
    }
}
