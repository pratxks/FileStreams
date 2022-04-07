
import java.io.Serializable;

public class Product implements Serializable
{
    private String m_sName;
    private String m_sDescription;
    private String m_sID;
    private double m_fCost;

    Product()
    {
        m_sName = "";
        m_sDescription = "";
        m_sID = "";
        m_fCost = 0.0f;
    }

    Product(String Name, String Description, String ID, double Cost)
    {
        m_sName = Name;
        m_sDescription = Description;
        m_sID = ID;
        m_fCost = Cost;
    }

    public String getM_sID() {
        return String.format("%6s", m_sID);
    }

    public String getM_sName() {
        return String.format("%-35s", m_sName);
    }

    public String getM_sDescription() {
        return String.format("%-75s", m_sDescription);
    }

    public double getM_fCost() {
        return m_fCost;
    }

    public void setM_sID(String m_sID) {
        this.m_sID = m_sID;
    }

    public void setM_sName(String m_sName) {
        this.m_sName = m_sName;
    }

    public void setM_sDescription(String m_sDescription) {
        this.m_sDescription = m_sDescription;
    }

    public void setM_fCost(double m_fCost) {
        this.m_fCost = m_fCost;
    }
}
