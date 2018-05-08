package com.tachyon.experimental.simplepasswordgen;

import java.io.Console;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
        try {
        	Console console = System.console();
        	
        	if(console == null) {
        		System.out.println("Could not get instance of console");
        		System.exit(0);        		
        	}
        	
        	char[] passwordArray = console.readPassword("Enter Master Password : ");
        	char[] siteArray = console.readPassword("Enter site for which password is required : ");
        	
        	StringBuilder initialHash = new StringBuilder();        	
        	initialHash.append(DigestUtils.md5Hex(new String(passwordArray).toUpperCase()).toLowerCase());
        	initialHash.append(DigestUtils.md5Hex(new String(siteArray).toLowerCase()).toUpperCase());
        	
        	//Most sites require a capital letter and special character
        	StringBuilder finalHash = new StringBuilder("X$");
        	finalHash.append(DigestUtils.md5Hex(initialHash.toString()).substring(0, 14));
        	System.out.println("Password is : " + finalHash.toString());
        	
        	initialHash = null;
        	finalHash = null;
        	passwordArray = null;
        	siteArray = null;
        	console = null;

        	System.exit(0);        	
        	
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
}
