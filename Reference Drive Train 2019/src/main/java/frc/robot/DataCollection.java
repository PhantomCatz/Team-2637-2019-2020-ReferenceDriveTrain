package frc.robot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataCollection {

    public int robotDataType;

    StringBuilder sb = new StringBuilder();

    public void setDataType(int dataType)
    {
        
    }

    public void dataCollectionInit()
    {

    }

    public void startDataCollection()
    {
        
    }

    public void writeHeader() throws IOException {

        try (
        FileWriter fw = new FileWriter("C:\\User\\T2637 Driver Laptop 1\\Desktop\\Data.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw))

    {
    if(robotDataType == 1) {

        sb.append("Time");
        sb.append(", ");
        sb.append("Voltage 1");
        sb.append(", ");
        sb.append("Voltage 2");
        sb.append(", ");
        sb.append("Voltage 3");
        sb.append(", ");
        sb.append("Voltage 4");      
    }

    {
    if(robotDataType == 2) {
    
            sb.append("Time");
            sb.append(", ");
            sb.append("Current 1");
            sb.append(", ");
            sb.append("Current 2");
            sb.append(", ");
            sb.append("Current 3");
            sb.append(", ");
            sb.append("Current 4");      
    }

    {
        if(robotDataType == 1) {
    
            sb.append("Time");
            sb.append(", ");
            sb.append("Temp 1");
            sb.append(", ");
            sb.append("Temp 2");
            sb.append(", ");
            sb.append("Temp 3");
            sb.append(", ");
            sb.append("Temp 4");      
        }

        {
            if(robotDataType == 4) {
        
                sb.append("Time");
                sb.append(", ");
                sb.append("Position 1");
                sb.append(", ");
                sb.append("Position 2");
                sb.append(", ");
                sb.append("Position 3");
                sb.append(", ");
                sb.append("Position 4");      
            }
    }
 }

}   
    }
}

    public void writeData(ArrayList<CatzLog> data) {

        sb.append("\n");
        
        sb.append(data);

        sb.append("\n");


    }

    public void exportData() throws IOException{
try (
        FileWriter fw = new FileWriter("C:\\User\\T2637 Driver Laptop 1\\Desktop\\Data.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw))
{
        pw.print(sb.toString());
    }}
}