package com.sandeep.RESTFW.Utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.Sources;


@Sources({ 
	"file:src\\test\\resources\\propertyFiles\\dev.properties" // mention the property file name ${enviroment}
})
public interface ConfigProperties extends Config{

	@Key("baseURI")
	String getbaseURI();
	
	@Key("basePath")
	String getbasePath();
	
	@Key("username")
	String getusername();
	
	@Key("portNumber")
	int getPortNumber();
	
	@Key("SheetName")
	String getsheetname();
	
	@Key("secretKey")
	String getsecretKey();
	
	
	
}
