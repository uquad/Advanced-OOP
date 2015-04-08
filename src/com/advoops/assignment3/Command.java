

package com.advoops.assignment3;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.codec.binary.Base64;

public abstract class Command implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public abstract boolean execute(Inventory inventObject);
	
	public void save(File commandList)
	{
		Base64 encoder=new Base64();	  	
        String commandString;
        try 
        {
            ByteArrayOutputStream byteArrStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrStream);
            objectOutputStream.writeObject(this);
            commandString = encoder.encodeAsString(byteArrStream.toByteArray());
         
            BufferedWriter writer = new BufferedWriter(new FileWriter(commandList, true));	          
            writer.write(commandString);
            writer.newLine();
            writer.close();
        	} 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
	}

	
}
