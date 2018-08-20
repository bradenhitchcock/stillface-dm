package io.github.bradenhc.stillface.client.model;

import com.googlecode.cqengine.attribute.Attribute;
import java.sql.Date;

import static com.googlecode.cqengine.query.QueryFactory.attribute;

/**
 * Provides the data structure for holding information from an import entry in the database.
 */
public class DataPoint {

    /* The member variables representing the schema of the database table. An additional argument (pid) is provided
     * to construct the whole PID of the entry from the import given its components. */
    private int importID = 0;
    private String filename;
    private int year;
    private int familyID;
    private int participantNumber;
    private Tag tag;
    private String alias;
    private Date date;
    private String pid;

    /*
     * The following variables are defined for use with the CQEngine IndexedCollections. This allows us to
     * create extremely fast indexing capabilities and cache data in memory for use. Data is only cached if
     * the model.cache configuration option is set to 'true'
     */
    public static final Attribute<DataPoint, Integer> IMPORT_ID =
            attribute("importID", DataPoint::getImportID);
    public static final Attribute<DataPoint, String> FILENAME =
            attribute("filename", DataPoint::getFilename);
    public static final Attribute<DataPoint, Integer> YEAR =
            attribute("year", DataPoint::getYear);
    public static final Attribute<DataPoint, Integer> FAMILY_ID =
            attribute("familyID", DataPoint::getFamilyID);
    public static final Attribute<DataPoint, Integer> PARTICIPANT_ID =
            attribute("participantNumber", DataPoint::getParticipantNumber);
    public static final Attribute<DataPoint, Tag> TAG =
            attribute("tag", DataPoint::getTag);
    public static final Attribute<DataPoint, String> ALIAS =
            attribute("alias", DataPoint::getAlias);
    public static final Attribute<DataPoint, Date> DATE =
            attribute("date", DataPoint::getDate);
    public static final Attribute<DataPoint, String> PID =
            attribute("pid", DataPoint::getPid);

    public DataPoint(int importID, String filename, int year, int familyID, int participantNumber,
                           Tag tag, String alias, Date date) {
        this.importID = importID;
        this.filename = filename;
        this.year = year;
        this.familyID = familyID;
        this.participantNumber = participantNumber;
        this.tag = tag;
        this.alias = alias;
        this.date = date;
        this.pid = String.format("%d-%03d-%02d", this.year, this.familyID, this.participantNumber);
    }

    public DataPoint(String filename, int year, int familyID, int participantNumber,
                           Tag tag, String alias, Date date) {
        this.filename = filename;
        this.year = year;
        this.familyID = familyID;
        this.participantNumber = participantNumber;
        this.tag = tag;
        this.alias = alias;
        this.date = date;
        this.pid = String.format("%d-%d-%d", this.year, this.familyID, this.participantNumber);
    }

    public int getImportID() {
        return importID;
    }

    public String getFilename() {
        return filename;
    }

    public int getYear() {
        return year;
    }

    public int getFamilyID() {
        return familyID;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }

    public String getAlias() {
        return alias;
    }

    public Date getDate() {
        return date;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFamilyID(int familyID) {
        this.familyID = familyID;
    }

    public void setParticipantNumber(int participantNumber) {
        this.participantNumber = participantNumber;
    }

    public String getPid() { return this.pid; }

    public void setPid(String pid) { this.pid = pid;}

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass()) return false;
        DataPoint sfImport = (DataPoint)o;
        if(sfImport.getImportID() != this.getImportID()) return false;
        return true;
    }

    @Override
    public String toString(){
        return String.format("%s : %s - %s [%s]", pid, tag, alias,date);
    }
}