package org.charleslambret.operateur;

public class OperationData {
    private String fileName;
    private double param1;
    private double param2;
    private String operator;
    private String type; // Ajout de la propriété type

    public OperationData(String fileName, double param1, double param2, String operator, String type) {
        this.fileName = fileName;
        this.param1 = param1;
        this.param2 = param2;
        this.operator = operator;
        this.type = type; // Initialisation de la propriété type
    }
    
    public String getType() {
        return type;
    }

    public String getFileName() {
        return fileName;
    }

    public double getParam1() {
        return param1;
    }

    public double getParam2() {
        return param2;
    }

    public String getOperator() {
        return operator;
    }
}
