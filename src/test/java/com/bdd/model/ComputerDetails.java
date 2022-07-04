package com.bdd.model;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ComputerDetails {
    private String computerName;
    private String introduced = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    private String discontinued = new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.addDays(new Date(),30));
    private String company;

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getIntroduced() {
        return introduced;
    }

    public void setIntroduced(String introduced) {
        this.introduced = introduced;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputerDetails)) return false;
        ComputerDetails that = (ComputerDetails) o;
        return Objects.equals(getComputerName(), that.getComputerName()) &&
                Objects.equals(getIntroduced(), that.getIntroduced()) &&
                Objects.equals(getDiscontinued(), that.getDiscontinued()) &&
                Objects.equals(getCompany(), that.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComputerName(), getIntroduced(), getDiscontinued(), getCompany());
    }

    @Override
    public String toString() {
        return "ComputerDetails{" +
                "computerName='" + computerName + '\'' +
                ", introduced='" + introduced + '\'' +
                ", discontinued='" + discontinued + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
