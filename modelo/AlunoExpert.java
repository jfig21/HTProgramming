/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Utilizador
 */
public class AlunoExpert {

    public AlunoExpert(String number, int presences, int sp, int sv, int ic, 
            int pp, int basic, int ifs, int loop, int arrays, int adv, double expected) {
        this.number = number;
        this.presences = presences;
        this.sp = sp;
        this.sv = sv;
        this.ic = ic;
        this.pp = pp;
        this.basic = basic;
        this.ifs = ifs;
        this.loop = loop;
        this.arrays = arrays;
        this.adv = adv;
        this.expected = expected;
    }
    public AlunoExpert(String number) {
        this.number = number;
        this.presences = 0;
        this.sp = 0;
        this.sv = 0;
        this.ic = 0;
        this.pp = 0;
        this.basic = 0;
        this.ifs = 0;
        this.loop = 0;
        this.arrays = 0;
        this.adv = 0;
        this.expected = 0;
    }
    
    private String number;
    private int presences;
    private int sp;         //Student Programming
    private int sv;         //Spatial Visualization
    private int ic;         //Introductory Concepts
    private int pp;         //Parson Problems
    private int basic;      //Basic Concepts Coding
    private int ifs;        //If/switch Coding
    private int loop;       //Loops
    private int arrays;     
    private int adv;        //Advanced Concepts Coding
    private double expected;//Expected value MBP

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPresences() {
        return presences;
    }

    public void setPresences(int presences) {
        this.presences = presences;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getSv() {
        return sv;
    }

    public void setSv(int sv) {
        this.sv = sv;
    }

    public int getIc() {
        return ic;
    }

    public void setIc(int ic) {
        this.ic = ic;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getBasic() {
        return basic;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    public int getIfs() {
        return ifs;
    }

    public void setIfs(int ifs) {
        this.ifs = ifs;
    }

    public int getLoop() {
        return loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    public int getArrays() {
        return arrays;
    }

    public void setArrays(int arrays) {
        this.arrays = arrays;
    }

    public int getAdv() {
        return adv;
    }

    public void setAdv(int adv) {
        this.adv = adv;
    }

    public double getExpected() {
        return expected;
    }

    public void setExpected(double expected) {
        this.expected = expected;
    }

    public String toStringCSV() {
        return presences + "," + sp + "," + sv + "," + ic + "," + pp + "," + basic + "," + ifs + "," + 
                loop + "," + arrays + "," + adv;
    }
    
    
    
}
