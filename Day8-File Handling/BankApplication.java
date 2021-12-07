package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Candidate {

    private int id;
    private int experience;
    private String name;
    private String primarySkill;
    private String qualification;

    public int getId(){
        return  id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrimarySkill() {
        return primarySkill;
    }
    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public String toString() {
        return "Candidate [ id= "+ id +", name=" + name + ", primarySkill="  + primarySkill+ ",experience=" + experience + ", qualification=" + qualification+ "]";
    }

}


public class BankApplication {
    public static void displayCandidateDetails(Candidate cand)
    {
        System.out.println( "Candidate [id=" + cand.getId()+ ", name=" + cand.getName()+ ",primarySkill=" + cand.getPrimarySkill()+ ", experience=" + cand.getExperience() + ", qualification=" +cand.getQualification()+ "]");

    }
    public static Candidate readCandidateDetails()
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Candidate c=new Candidate();
        try
        {
            System.out.println("Enter id of the Candidate");
            int id = Integer.parseInt(br.readLine());
            c.setId(id);
            System.out.println("Enter name of the Candidate");
            String name = br.readLine();
            c.setName(name);
            System.out.println("Enter Primary Skill");
            String primarySkill = br.readLine();
            c.setPrimarySkill(primarySkill);
            System.out.println("Enter Qualification");
            String qualification = br.readLine();
            c.setQualification(qualification);
            System.out.println("Enter Total Experience in Months");
            int exp = Integer.parseInt(br.readLine());
            c.setExperience(exp);
        }catch(IOException ie)
        {
            System.out.println("IOException generated");
            ie.printStackTrace();

        }
        return c;
    }

    public static void main(String[] args) {

        Candidate c=readCandidateDetails();
        displayCandidateDetails(c);

    }

}

