/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JFig
 */
public class ConnectBD implements DadosPeduca {

    public ConnectBD() {
        this.tHost = DadosPeduca.tHost;
        this.defaultBD = DadosPeduca.defaultBD;
        this.user = DadosPeduca.user;
        this.passwd = DadosPeduca.passwd;
        host = this.tHost[0];
        url = "jdbc:mysql://" + host + ":3306/" + this.defaultBD;
        iHost = 0;
        
    }
    public ConnectBD(boolean local) {
        if (local) {
            this.tHost = DadosPeducaOld.tHost;
            this.defaultBD = DadosPeducaOld.defaultBD;
            this.user = DadosPeducaOld.user;
            this.passwd = DadosPeducaOld.passwd;
            host = this.tHost[0];
            url = "jdbc:mysql://" + host + ":3306/" + this.defaultBD;
            iHost = 0;
        } else {
            this.tHost = DadosPeduca.tHost;
            this.defaultBD = DadosPeduca.defaultBD;
            this.user = DadosPeduca.user;
            this.passwd = DadosPeduca.passwd;
            host = this.tHost[0];
            url = "jdbc:mysql://" + host + ":3306/" + this.defaultBD;
            iHost = 0;
        }
        
    }

    public ConnectBD(int ihost) {
        jdbc:
        mysql://bd.ipg.pt:3306/peduca
        url = "jdbc:mysql://bd.ipg.pt:3306/peduca";
        iHost = 2;
    }

    public ConnectBD(String host, String database, String user, String password) {
        this.tHost = DadosPeduca.tHost;
        defaultBD = database;
        this.user = user;
        passwd = password;
        this.host = host;
        url = "jdbc:mysql://" + host + ":3306/" + defaultBD;
        iHost = 0;
    }

    private String tHost[];
    private String defaultBD;
    private String user;
    private String passwd;
    private String host;
    private String url;
    private Connection con;
    private String driver;
    private int iHost;

    private void driverTest() {
        try {
            this.setDriver("com.mysql.jdbc.Driver");
            Class.forName(this.getDriver());
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found ... ");
        }
    }

    public Connection makeCon() {
        this.driverTest();
        try {
            this.setUrl("jdbc:mysql://" + this.getHost() + ":3306/" + this.getDefaultBD());
            this.setCon((Connection) DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPasswd()));
            return getCon();
        } catch (SQLException ex) {
            System.out.println("Ligação não pode ser efectuada com : " + getUrl());
           // System.out.println("Ligação não pode ser efectuada !");

        }
        return getCon();
    }

    public Connection makeConName(String host) {
        this.driverTest();
        try {
            this.setUrl("jdbc:mysql://" + host + ":3306/" + this.getDefaultBD());
            setCon((Connection) DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPasswd()));
            return getCon();
        } catch (SQLException ex) {
//            System.out.println("Ligação não pode ser efectuada com : " + getUrl());
            System.out.println("Ligação não pode ser efectuada !");
        }
        return getCon();
    }

    public Connection makeConNumber(int host) {
        this.driverTest();
        try {
            this.setUrl("jdbc:mysql://" + tHost[host] + ":3306/" + this.getDefaultBD());
            setCon((Connection) DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPasswd()));
            return getCon();
        } catch (SQLException ex) {
//            System.out.println("Ligação não pode ser efectuada com : " + getUrl());
            System.out.println("Ligação não pode ser efectuada !");
        }
        return getCon();
    }

    public Connection makeConAuto() {
        this.driverTest();
        while (iHost < gettHost().length) {
            try {
                this.setUrl("jdbc:mysql://" + this.gettHost()[iHost] + ":3306/" + this.getDefaultBD());
                this.setCon((Connection) DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPasswd()));
                this.setHost(this.gettHost()[iHost]);
//                System.out.println("Ligação efectuada em : " + getUrl());
                return getCon();
            } catch (SQLException ex) {
//                System.out.println("Ligação não pode ser efectuada com : " + url);
                System.out.println("makeConAuto: Ligação não pode ser efectuada...");
                iHost++;
            }
        }
        return getCon();
    }

    public void closeConnection() {
        if (this.getCon() != null) {
            try {
                this.getCon().close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ResultSet exeQuery(Connection con, String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = (Statement) con.createStatement();
            rs = (ResultSet) stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error executing sql query statement");
        }
        return rs;
    }

    public void exeUpdate(Connection con, String sql) {
        try {
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error executing sql update statement");
        }
    }

    /**
     * @return the tHost
     */
    public String[] gettHost() {
        return tHost;
    }

    /**
     * @param tHost the tHost to set
     */
    public void settHost(String[] tHost) {
        this.tHost = tHost;
    }

    /**
     * @return the defaultBD
     */
    public String getDefaultBD() {
        return defaultBD;
    }

    /**
     * @param defaultBD the defaultBD to set
     */
    public void setDefaultBD(String defaultBD) {
        this.defaultBD = defaultBD;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the iHost
     */
    public int getiHost() {
        return iHost;
    }

    /**
     * @param iHost the iHost to set
     */
    public void setiHost(int iHost) {
        this.iHost = iHost;
    }

}
